package com.sda.projects.MailService;

import lombok.NoArgsConstructor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor
public class MailService {

    public void sendMessage(String path,String email) throws IOException {
        //Declare recipient's & sender's e-mail id.
        String destmailid = email;
        String sendrmailid = "javasda15@gmail.com";
        //Mention user name and password as per your configuration
        final String uname = "javasda15@gmail.com";
        final String pwd = "Javasda12#";
        //We are using relay.jangosmtp.net for sending emails
        String smtphost = "smtp.gmail.com";
        //Set properties and their values
        Properties propvls = new Properties();
        propvls.put("mail.smtp.auth", "true");
        propvls.put("mail.smtp.starttls.enable", "true");
        propvls.put("mail.smtp.host", smtphost);
        propvls.put("mail.smtp.port", "587");
        //Create a Session object & authenticate uid and pwd
        Session sessionobj = Session.getInstance(propvls,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(uname, pwd);
                    }
                });

        try {
            //Create MimeMessage object & set values
            Message messageobj = new MimeMessage(sessionobj);
            messageobj.setFrom(new InternetAddress(sendrmailid));
            messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destmailid));
            messageobj.setSubject("Kotki");
           // messageobj.setText("Zdjęcia kotków"); <- to jakby tylko słać message, a dalej to z załącznikiem ..
            //multipart ..

            Multipart multipart = new MimeMultipart();
            String msg = "Kitie's Picture !!!";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File(path));
            multipart.addBodyPart(attachmentBodyPart);
            multipart.addBodyPart(mimeBodyPart);
            messageobj.setContent(multipart);
            //Now send the message
            Transport.send(messageobj);
            System.out.println("Your email sent successfully....");
        } catch (MessagingException exp) {
            throw new RuntimeException(exp);
        }
    }
}
