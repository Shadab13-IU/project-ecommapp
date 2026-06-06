/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomm.model;

import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
/**
 * 
 * @author shadab
 */
public class MailSender {
        public void sendMail(String to,String from,String link)throws MessagingException{
            final String username="laraiban23@gmail.com";
            final String password="sceftqlcmurplutv";
            Properties props=new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.port","587");
            Session session=Session.getInstance(props,new jakarta.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username,password);
                    }
            });
            Message msg=new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("Hi");
            msg.setText(link);
            Transport.send(msg);
        }
}
