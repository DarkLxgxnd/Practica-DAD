package es.codeurjc.serviciointerno.comunicados;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	private JavaMailSender javaMailSender;

	public void sendEmail(Comunicado comunicado) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true);

		helper.setSubject("Nuevo Comunicado: " + comunicado.getTitulo());
		helper.setTo("srgn807@gmail.com");
		helper.setText(comunicado.getContenido(), true);

		javaMailSender.send(message);
	}
}
