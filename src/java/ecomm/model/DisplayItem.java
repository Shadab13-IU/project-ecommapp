/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author shadab
 */
public class DisplayItem implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        Dao dc=new Dao();
        String driver="com.mysql.cj.jdbc.Driver";
        Connection con;
        Statement st=null;
        System.out.println("reached");
        // file image
        try (PrintWriter ot=response.getWriter()){
//            
//            response.reset();
//            response.setContentType("");
//            response.getOutputStream().write(b);
//            response.getOutputStream().flush();
//            response.getOutputStream().close();
            con=dc.toConnect(driver);
            st=con.createStatement();
            //String q1="SELECT * FROM product_table";
            CallableStatement csmt=con.prepareCall("{CALL get_item()}");
            ResultSet rs=csmt.executeQuery();
            
            String product_name=null,p=null,product_brand=null,product_dimension=null,product_description=null;
            double product_price,product_discount,product_selling_price,product_weight; 
            int product_warranty;
            JSONArray ilj=new JSONArray();
            ResultSetMetaData metaData=rs.getMetaData();
            int columnCount=metaData.getColumnCount();
            while(rs.next()){
                JSONObject obj=new JSONObject();
                for(int i=1; i<=columnCount; i++){
                    String colName=metaData.getColumnName(i);
                    Object value=rs.getObject(i);
                    if(colName.equals("product_image_path")){
//                        System.out.println((String)value);
                        File f=new File((String) value);
                        byte[] b=Files.readAllBytes(f.toPath());
                        value=Base64.getEncoder().encodeToString(b);
                    }
                    System.out.println(colName+" "+value);
                    obj.put(colName, value);
                }   
                ilj.add(obj);
            }
            JSONObject fres=new JSONObject();
            fres.put("items", ilj);
            System.out.println(fres);
            String item=fres.toJSONString();
            ot.print(item);
        } catch (IOException ex) {
            System.getLogger(DisplayItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(DisplayItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(DisplayItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        
    }
    
}
