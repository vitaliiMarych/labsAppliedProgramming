package Logs;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class InsureLog {
    private static final String username = "vitalii.marych.kn.2021@lpnu.ua";
    private static final String password = Parol.parol;

    public static Handler HandlerForMail(){
        return new Handler() {
            @Override
            public void publish(LogRecord record) {
                if(record.getLevel() == Level.SEVERE)
                    sendMail(record.getMessage());
            }

            @Override
            public void flush() {}

            @Override
            public void close() throws SecurityException {

            }
        };
    }

    public static void sendMail(String logMessage) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.transport.protocol", "SMTP");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vitalii.marych.kn.2021@lpnu.ua"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("apiskin557@gmail.com")
            );
            message.setSubject("Error");
            message.setText(logMessage);
            Transport.send(message);
        } catch (MessagingException e) {
            Logger.getGlobal().severe("Failed to send email.");
            e.printStackTrace();
        }
    }
}
