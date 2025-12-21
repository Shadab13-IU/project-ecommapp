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
         Dao dc=new Dao();
         String em=request.getParameter("email");
         String pw=request.getParameter("pwd");
         String driver="com.mysql.cj.jdbc.Driver";
         Connection con;
        try {
            con = dc.toConnect(driver);
            Statement st=con.createStatement();
            String query="SELECT passwd,status,category FROM ecomm_login WHERE(email='"+em+"')";
            ResultSet rs=st.executeQuery(query);
            HttpSession session=null;
            if(rs.next()){
                String pass=rs.getString("passwd");
                int status1=rs.getInt("status");
                int category=rs.getInt("category");
                if(pass.equals(pw)){
                    if(status1==1){
                        if(category==1){
                            session=request.getSession(true);
                            request.getRequestDispatcher("admin").forward(request, response);
                        }else if(category==2){
                            session=request.getSession(true);
                            request.getRequestDispatcher("buyer").forward(request, response);
                        }else{
                            
                        }
                    }else{
                         MailSender ms=new MailSender();
                         ms.sendMail(em, "laraiban23@gmail.com");
                         //request.getRequestDispatcher("verify").forward(request, response);
                    }
                }else{
                     request.getRequestDispatcher("lfail").forward(request, response);
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
        } catch (MessagingException ex) {
            System.getLogger(LoginModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         
    }
    
}
