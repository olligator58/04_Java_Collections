import javax.mail.*;
import  javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class Task1050 {

    public static void main(String[] args) throws MessagingException {
        String username = "user@gmail.com";
        String password = "password";

        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.setSubject("test");
        message.setText("Hi! This is a test message.");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("olligator80@yandex.ru"));
        message.setSentDate(new Date());

        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, username, password);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    }
}
