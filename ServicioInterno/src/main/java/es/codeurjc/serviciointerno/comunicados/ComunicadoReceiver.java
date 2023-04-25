package es.codeurjc.serviciointerno.comunicados;

import javax.mail.MessagingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComunicadoReceiver {
    @Autowired
    private EmailSender emailSender;

    @RabbitListener(queues = "comunicados", containerFactory = "jsonRabbitListener")
    public void receiveComunicacion(Comunicado comunicado) throws MessagingException {
        emailSender.sendEmail(comunicado);
    }
}
