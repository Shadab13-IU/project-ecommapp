/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;

/**
 *
 * @author shadab
 */
public class UploadItem implements Model {
    
    private String getFileName(final Part part){
        for(String content:part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf("=")).trim().replace("\"","");
            }
        }
        return null;
    }

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        
        String p_name=request.getParameter("prdid");
        String pscid=request.getParameter("subct");
        String p_cp=request.getParameter("prc");
        String p_dc=request.getParameter("description");
        String p_br=request.getParameter("brnd");
        String p_wr=request.getParameter("wrnty");
        String p_qt=request.getParameter("qant");
        String p_sp=request.getParameter("scp");
        String p_dm=request.getParameter("dmns");
        String p_wt=request.getParameter("wght");
        String driver="com.mysql.cj.jdbc.Driver";
        System.out.println(pscid);
        int sid=Integer.parseInt(pscid);
        int wrnty=Integer.parseInt(p_wr);
        int qntty=Integer.parseInt(p_qt);
 
        Dao db=new Dao();
        Connection con;
//        BigDecimal price = new BigDecimal(p_cp);//
//        price=price.setScale(2,RoundingMode.HALF_UP);
        
        double c_price=Double.parseDouble(p_cp);
        double s_price=Double.parseDouble(p_sp);
        double pwt=Double.parseDouble(p_wt);
        double dsc;
        if(s_price<c_price){
             dsc=c_price-s_price;
        }else{
            dsc=0;
        }
//        BigDecimal s_price = new BigDecimal(p_sp);//
//        s_price=s_price.setScale(2,RoundingMode.HALF_UP);
        
        
        
        try {
            
            InputStream fileContent=null;
            final String path="/home/shadab/Pictures/EcommAppImages";
            final Part filePart;
            filePart = request.getPart("img");
            final String fileName=getFileName(filePart).replace("=","");
            
            File f=new File(path+File.separator+pscid);
            f.mkdir();
            OutputStream ot=new FileOutputStream(new File(f.getAbsolutePath()+File.separator+fileName));
            fileContent=filePart.getInputStream();
            int read=0;
            final byte[] bytes=new byte[1024];
            while((read=fileContent.read(bytes))!=-1){
                ot.write(bytes,0,read);
            }
            con = db.toConnect(driver);
            CallableStatement cst=con.prepareCall("{CALL upload_item(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1,p_name);
            cst.setInt(2,sid);
            cst.setDouble(3,c_price);
            cst.setString(4,f.getAbsolutePath()+File.separator+fileName);
            cst.setString(5,p_dc);
            cst.setString(6,p_br);
            cst.setInt(7,wrnty);
            cst.setInt(8,qntty);
            cst.setDouble(9,dsc);
            cst.setDouble(10,s_price);
            cst.setString(11,p_dm);
            cst.setDouble(12,pwt);
            cst.execute();
            cst.close();
        } catch (IOException ex) {
            System.getLogger(UploadItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ServletException ex) {
            System.getLogger(UploadItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(UploadItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(UploadItem.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
