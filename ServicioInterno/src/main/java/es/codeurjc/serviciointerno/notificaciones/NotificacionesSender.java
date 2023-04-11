package es.codeurjc.serviciointerno.notificaciones;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendNotificaciones(PartidoInfo partidoInfo) {
        if (partidoInfo.getGolesLocal() > partidoInfo.getGolesVisitante()) {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoLocal(), "¡Nueva victoria de " + partidoInfo.getEquipoLocal() + "!", "" + partidoInfo.getEquipoLocal() + " ha ganado " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + partidoInfo.getEquipoVisitante()));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoVisitante(), "¡Nueva derrota de " + partidoInfo.getEquipoVisitante() + "!", "" + partidoInfo.getEquipoVisitante() + " ha perdido " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + partidoInfo.getEquipoLocal()));
	    } else if (partidoInfo.getGolesLocal() == partidoInfo.getGolesVisitante()) {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoLocal(), "¡Nuevo empate de " + partidoInfo.getEquipoLocal() + "!", "" + partidoInfo.getEquipoLocal() + " ha empatado " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + partidoInfo.getEquipoVisitante()));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoVisitante(), "¡Nuevo empate de " + partidoInfo.getEquipoVisitante() + "!", "" + partidoInfo.getEquipoVisitante() + " ha empatado " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + partidoInfo.getEquipoLocal()));
		} else {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoLocal(), "¡Nueva derrota de " + partidoInfo.getEquipoLocal() + "!", "" + partidoInfo.getEquipoLocal() + " ha perdido " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + partidoInfo.getEquipoVisitante()));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(partidoInfo.getEquipoVisitante(), "¡Nueva victoria de " + partidoInfo.getEquipoVisitante() + "!", "" + partidoInfo.getEquipoVisitante() + " ha ganado " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + partidoInfo.getEquipoLocal()));
		}
    }
}
