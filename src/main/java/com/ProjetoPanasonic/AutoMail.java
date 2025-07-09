package com.ProjetoPanasonic;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class AutoMail {
    public static void email(String[] ags){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("","");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));
            message.setRecipients(Message.RecipientType.TO, "");
            message.setSubject("" + java.time.LocalDate.now());
            message.setText("");

            MimeBodyPart corpo = new MimeBodyPart();
            corpo.setText("");

            MimeBodyPart anexo = new MimeBodyPart();
            anexo.attachFile("caminho");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(corpo);
            multipart.addBodyPart(anexo);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email enviado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
