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

		helper.setSubject("subject");
		helper.setTo("");
		helper.setText("", true);

		javaMailSender.send(message);
	}
}
