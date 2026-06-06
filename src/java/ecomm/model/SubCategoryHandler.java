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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

/**
 *
 * @author shadab
 */
public class SubCategoryHandler implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("cid");
       // int id=Integer.
        Dao dc=new Dao();
        String driver="com.mysql.cj.jdbc.Driver";
        Connection con;
        try(PrintWriter ot = response.getWriter()) {
            con = dc.toConnect(driver);
            Statement st=con.createStatement();
            String q="SELECT product_subcategory_id,product_subcategory_name FROM subcategory_table WHERE(product_category_id='"+sid+"')";
            ResultSet rs=st.executeQuery(q);
            int pid=0;
            String scname=null;
            JSONObject obj=new JSONObject();
            while(rs.next()){
                pid=rs.getInt("product_subcategory_id");
                scname=rs.getString("product_subcategory_name");
                obj.put(pid,scname);
            }
            String s=obj.toJSONString();
            ot.print(s);
        } catch (ClassNotFoundException ex) {
            System.getLogger(SubCategoryHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(SubCategoryHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (FileNotFoundException ex) {
            System.getLogger(SubCategoryHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(SubCategoryHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
           
    }
    
}
