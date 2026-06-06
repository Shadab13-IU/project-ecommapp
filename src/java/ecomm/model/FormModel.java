/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author shadab
 */
public class FormModel implements Model {

    @Override
    public void businessLogic(HttpServletRequest request, HttpServletResponse response) {
        try(PrintWriter out=response.getWriter()){
            //String jsonString = "{\"components\":\"form\",\"action\":\"#\",\"method\":\"GET\",\"fields\":[{\"type\":\"email\",\"name\":\"email\"},{\"type\":\"password\",\"name\":\"ps\"}]}";
        JSONObject formJson = new JSONObject();
        
        
        formJson.put("components", "form");
        formJson.put("action", "lmodel");
        formJson.put("method", "POST");
        
        
        JSONArray fields = new JSONArray();
        
        
        JSONObject emailField = new JSONObject();
        emailField.put("type", "email");
        emailField.put("name", "email");
        emailField.put("placeholder", "Enter your Email");
        emailField.put("id", "eid");
        emailField.put("required", "true");
        fields.add(emailField);
        
        JSONObject catv = new JSONObject();
        catv.put("type", "hidden");
        catv.put("name", "category");
        catv.put("value", "1");
        
        fields.add(catv);
        
        JSONObject passwordField = new JSONObject();
        passwordField.put("type", "password");
        passwordField.put("name", "ps");
        passwordField.put("placeholder", "Enter your password");
        passwordField.put("id", "pid");
        fields.add(passwordField);
        
        JSONObject sbmt=new JSONObject();
        sbmt.put("type","submit");
        fields.add(sbmt);
        
        //System.out.println("shadab");
        formJson.put("fields", fields);
        String frm=formJson.toJSONString();
        out.print(frm);

        } catch (IOException ex) {
            System.getLogger(FormModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
