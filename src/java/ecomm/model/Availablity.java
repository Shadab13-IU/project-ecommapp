/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author shadab
 */
public class Availablity implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()){
            String em=request.getParameter("email");
           // String val="Already exist ";
            Dao dc=new Dao();
            String driver="com.mysql.cj.jdbc.Driver";
            Connection con=dc.toConnect(driver);
            Statement st=con.createStatement();
            String query="SELECT uid FROM ecomm_login WHERE(email='"+em+"')";
            ResultSet rs=st.executeQuery(query);
            JSONObject obj=new JSONObject();
            if(rs.next()){
                //out.print("This Email already exist");
               /* obj.put("message","Email is Available");
                String s=obj.toJSONString();
                out.print(s);*/
               // JSONObject obj=new JSONObject();
                /*obj.put("college","Integral University");
                obj.put("stream","Engineering");
                JSONArray list=new JSONArray();
                list.add("CSE");
                list.add("EC");
                list.add("EE");
                list.add("ME");
                obj.put("branches",list);
                String s=obj.toJSONString();
                out.print(s);*/
            }else{
              // out.print("Available");
            }
            // 26 Dec Code  
            
        } catch (IOException ex) {
            System.getLogger(Availablity.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(Availablity.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(Availablity.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
