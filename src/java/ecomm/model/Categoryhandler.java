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
import java.sql.*;
import org.json.simple.JSONObject;

/**
 *
 * @author shadab
 */
public class Categoryhandler implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        try(PrintWriter ot = response.getWriter()){
            Dao dc=new Dao();
            String driver="com.mysql.cj.jdbc.Driver";
            Connection con=dc.toConnect(driver);
            Statement st=con.createStatement();
            String q="SELECT * FROM category_table";
            ResultSet rs=st.executeQuery(q);
            int id=0;
            String c_name=null;
            JSONObject obj=new JSONObject();
            while(rs.next()){
                id=rs.getInt("product_category_id");
                c_name=rs.getString("product_category_name");
                obj.put(id,c_name);
            }
//            obj.put(id,id);
//            obj.put("cname",c_name);
            String s=obj.toJSONString();
            ot.print(s);
        } catch (IOException ex) {
            System.getLogger(Categoryhandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(Categoryhandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(Categoryhandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
