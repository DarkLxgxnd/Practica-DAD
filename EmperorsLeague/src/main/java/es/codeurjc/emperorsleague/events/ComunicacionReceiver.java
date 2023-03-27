package es.codeurjc.emperorsleague.events;

import javax.mail.MessagingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComunicacionReceiver {
    @Autowired
    private EmailSender emailSender;

    @RabbitListener(queues = "comunicaciones", ackMode = "AUTO")
    public void receiveComunicacion(Comunicacion comunicacion) throws MessagingException {
        emailSender.sendEmail(comunicacion);
    }
}
