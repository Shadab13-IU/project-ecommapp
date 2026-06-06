/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 *
 * @author shadab
 */
public class AddToCart implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        try(PrintWriter out=response.getWriter()){
            Dao db=new Dao();
            String driver="com.mysql.cj.jdbc.Driver";
            Connection con=db.toConnect(driver);
            HttpSession session = request.getSession(false);

            if(session == null){
                response.sendRedirect("login");
                return;
            }

            Integer buyerId =
                (Integer) session.getAttribute("buyer_id");

            String productId =
                request.getParameter("id");

            System.out.println("Buyer ID = " + buyerId);
            System.out.println("Product ID = " + productId);
            CallableStatement cs =
            (CallableStatement) con.prepareCall("{CALL add_to_cart(?,?)}");

            cs.setInt(1, buyerId);
            cs.setInt(2, Integer.parseInt(productId));

            cs.execute();
        } catch (IOException ex) {
            System.getLogger(AddToCart.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(AddToCart.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(AddToCart.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
