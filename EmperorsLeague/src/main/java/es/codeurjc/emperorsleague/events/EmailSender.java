package es.codeurjc.emperorsleague.events;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    public void sendEmail(Comunicacion comunicacion) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "localhost");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@emperorsleague.es"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("srgn807@gmail.com"));
        message.setSubject("Nuevo Comunicado de Emperors League");
        message.setText("" + comunicacion.getTitulo() + "\n\n" + comunicacion.getContenido() + "Atentamente,\nAdmin de Emperors League");

        Transport.send(message);
    }
}
