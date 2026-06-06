    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
package ecomm.model;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import org.json.simple.JSONObject;

    /**
     *
     * @author shadab
     */
    public class SingleProductDetails implements Model {

        @Override
        public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
            try(PrintWriter ot = response.getWriter();) {
                System.out.println("Reached");
                Dao dc=new Dao();
                String driver="com.mysql.cj.jdbc.Driver";
                Connection con=dc.toConnect(driver);
                String productId = request.getParameter("id");

                CallableStatement cs
                    = (CallableStatement) con.prepareCall("{CALL get_single_product(?)}");

                cs.setInt(1, Integer.parseInt(productId));

                ResultSet rs = (ResultSet) cs.executeQuery();
                JSONObject obj = new JSONObject();

            if(rs.next()){

                ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();

                int count = meta.getColumnCount();

                for(int i=1;i<=count;i++){

                    String colName = meta.getColumnName(i);

                    Object value = rs.getObject(i);

                    if(colName.equals("product_image_path")){

                        File f = new File((String)value);

                        byte[] b = Files.readAllBytes(f.toPath());

                        value = Base64.getEncoder()
                                      .encodeToString(b);
                    }

                    obj.put(colName,value);
                }
            }
            response.setContentType("application/json");
            
            System.out.println("heere");
            ot.print(obj.toJSONString());
            } catch (ClassNotFoundException ex) {
                System.getLogger(SingleProductDetails.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (SQLException ex) {
                System.getLogger(SingleProductDetails.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (FileNotFoundException ex) {
                System.getLogger(SingleProductDetails.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (IOException ex) {
                System.getLogger(SingleProductDetails.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

        }

    }
