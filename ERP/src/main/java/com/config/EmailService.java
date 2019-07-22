package com.config;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailService {
    String sender="",passwprd="";
    
    public String sendmail(String receiver,String subject,String body) throws AddressException, MessagingException, IOException {
   Properties props = new Properties();
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.port", "587");
   sender="your@gmail.com";
   passwprd="your-passw0rd";
   String message="Sent";
   try{
   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(sender,passwprd);
      }
   });
   Message msg = new MimeMessage(session);
   msg.setFrom(new InternetAddress(sender, false));

   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
   msg.setSubject(subject);
   msg.setContent(body, "text/html");
   msg.setSentDate(new Date());
   Transport.send(msg); 
   }catch(Exception e){message=e.getMessage();}
   return message;
           
}

}