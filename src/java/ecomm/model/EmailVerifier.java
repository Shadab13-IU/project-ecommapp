/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shadab
 */
public class EmailVerifier implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("uid");
        String driver="com.mysql.cj.jdbc.Driver";
        Dao dc=new Dao();
        Connection con;
        try {
            con = dc.toConnect(driver);
            Statement st=con.createStatement();
            String query="UPDATE ecomm_login SET status=1 WHERE(uid='"+id+"')";
            st.execute(query);
            request.getRequestDispatcher("emvf").forward(request,response);
         
            //HttpSession session=null;
        } catch (ClassNotFoundException ex) {
            System.getLogger(EmailVerifier.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(EmailVerifier.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (FileNotFoundException ex) {
            System.getLogger(EmailVerifier.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ServletException ex) {
            System.getLogger(EmailVerifier.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(EmailVerifier.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
