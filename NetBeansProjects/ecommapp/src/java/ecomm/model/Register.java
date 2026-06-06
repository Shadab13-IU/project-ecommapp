/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import static java.text.NumberFormat.Field.INTEGER;
import java.util.concurrent.Callable;

/**
 *
 * @author shadab
 */
public class Register implements Model {
    @Override
    public void businessLogic(HttpServletRequest request,HttpServletResponse response){
        Dao dc=new Dao();
        String driver="com.mysql.cj.jdbc.Driver";
        String em=request.getParameter("email");
        String pw=request.getParameter("pwd");
        String fn=request.getParameter("fname");
        String ln=request.getParameter("lname");
        String gn=request.getParameter("gender");
        int gm=Integer.parseInt(gn);
        try { 
            Connection con=dc.toConnect(driver);
            Statement st=con.createStatement();
            /*String q1="SELECT uid FROM ecomm_user ORDER BY uid DESC LIMIT 1";
            ResultSet rs=st.executeQuery(q1);
            int id=0;
            if(!rs.next()){
                id=1;
                st=con.createStatement();
                String q2="INSERT INTO ecomm_user(uid,first_name,last_name,gender) VALUES(1,'"+fn+"','"+ln+"','"+gn+"')";
                st.execute(q2);
            }else{
                id=rs.getInt("uid")+1;
                String q3="INSERT INTO ecomm_user(uid,first_name,last_name,gender) VALUES('"+id+"','"+fn+"','"+ln+"','"+gn+"')";
                st.execute(q3); 
            }
            String q4="INSERT INTO ecomm_login(email,passwd,status,category,uid) VALUES('"+em+"','"+pw+"',0,2,'"+id+"')";
            if(st.execute(q4))System.out.println("Register Succesful");*/
            CallableStatement cl=con.prepareCall("{CALL userregistration(?,?,?,?,?)}");
            cl.setString(1,em);
            cl.setString(2, pw);
            cl.setString(3,fn);
            cl.setString(4,ln);
            cl.setInt(5,gm);
            
            cl.execute();
            cl.close();
            con.close();
            request.getRequestDispatcher("regsuccess").forward(request, response);
                
        } catch (ClassNotFoundException ex) {
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.out.println("shadab");
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (FileNotFoundException ex) {
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ServletException ex) {
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
}
