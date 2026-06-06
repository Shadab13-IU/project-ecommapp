 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shadab
 */
public class LoginModel implements Model {
    
   
    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
         
         String em=request.getParameter("email");
         String pw=request.getParameter("pwd");
         String ca=request.getParameter("category");
         int ct=Integer.parseInt(ca);
         //System.out.println("category"+ct);
        Dao dc=new Dao();
        String driver="com.mysql.cj.jdbc.Driver";
        Connection con;
        Statement st=null;
        try(PrintWriter ot=response.getWriter()) {
            
            con = dc.toConnect(driver);
            st=con.createStatement();
            // category 1 for buyer and 2 for seller
            if(ct!=2){
                String query="SELECT password,status,category,uid FROM ecomm_login WHERE(email='"+em+"')";
                ResultSet rs=st.executeQuery(query);
                HttpSession session=null;
                int uid=0;
                if(rs.next()){
                    String pass=rs.getString("password");
                    int status1=rs.getInt("status");
                    int category=rs.getInt("category");
                    uid=rs.getInt("uid");
                    //System.out.println(pw);
                    if(pass.equals(pw)){
                        //System.out.println(pass);
                        if(status1==1){
                            session = request.getSession();

                            session.setAttribute("buyer_id", uid);
                            session.setAttribute("buyer_email", em);
                            
                            
                            request.getRequestDispatcher("itd").forward(request, response);
                        }else{
                             /*String link="http://localhost:8080/ecommapp/controller/emailverifier?uid="+uid;  
                             MailSender ms=new MailSender();
                             ms.sendMail(em, "laraiban23@gmail.com",link);
                             //request.getRequestDispatcher("verify").forward(request, response);*/
                        }
                    }else{
                         request.getRequestDispatcher("lfail").forward(request, response);
                    }
                }
            }else{
                
                String query="SELECT seller_password FROM seller_table WHERE(seller_email='"+em+"')";
                ResultSet rs=st.executeQuery(query);
                if(rs.next()){
                    String passw=rs.getString("seller_password");
                    
                    if(pw.equals(passw)){
                        
                        request.getRequestDispatcher("admin").forward(request,response);
                    }else{
                        System.out.println("password is incorrect");
                    }
            }
                
            }
            //System.out.print("error");
            con.close();
        } catch (ClassNotFoundException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (FileNotFoundException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ServletException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         
    }
    
}
