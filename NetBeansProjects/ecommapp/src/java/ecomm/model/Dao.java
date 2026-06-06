/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author shadab
 */
public class Dao {
    public Connection toConnect(String driver)throws ClassNotFoundException,SQLException, FileNotFoundException{
       /* Properties pr=new Properties();
        try {            
            pr.load(new FileInputStream("src/mypkg/db.properties"));
        } catch (IOException ex) {
            System.out.println(ex);
        }*/
        String url="jdbc:mysql://localhost:3306/ecommdb?useSSL=false&allowPublicKeyRetrieval=true";      
        /*pr.getProperty("db.url");*/
        String name="shadab";                         //pr.getProperty("db.name");
        String pswd="admin"; //pr.getProperty("db.pswd");                   
        Class.forName(driver);
        return DriverManager.getConnection(url,name,pswd);
    }
}
 