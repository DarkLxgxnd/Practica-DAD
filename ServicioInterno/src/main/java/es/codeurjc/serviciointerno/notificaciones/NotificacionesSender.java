package es.codeurjc.serviciointerno.notificaciones;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendNotificaciones(PartidoInfo partidoInfo) {
        List<String> equipos = partidoInfo.getEquiposParticipantes();
        String equipoLocal = equipos.get(0);
        String equipoVisitante = equipos.get(1);

        if (partidoInfo.getGolesLocal() > partidoInfo.getGolesVisitante()) {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoLocal, "¡Nueva victoria de " + equipoLocal + "!", "" + equipoLocal + " ha ganado " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + equipoVisitante));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoVisitante, "¡Nueva derrota de " + equipoVisitante + "!", "" + equipoVisitante + " ha perdido " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + equipoLocal));
		} else if (partidoInfo.getGolesLocal() == partidoInfo.getGolesVisitante()) {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoLocal, "¡Nuevo empate de " + equipoLocal + "!", "" + equipoLocal + " ha empatado " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + equipoVisitante));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoVisitante, "¡Nuevo empate de " + equipoVisitante + "!", "" + equipoVisitante + " ha empatado " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + equipoLocal));
		} else {
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoLocal, "¡Nueva derrota de " + equipoLocal + "!", "" + equipoLocal + " ha perdido " + partidoInfo.getGolesLocal() + "-" + partidoInfo.getGolesVisitante() + " ante " + equipoVisitante));
            rabbitTemplate.convertAndSend("notificaciones", new Notificacion(equipoVisitante, "¡Nueva victoria de " + equipoVisitante + "!", "" + equipoVisitante + " ha ganado " + partidoInfo.getGolesVisitante() + "-" + partidoInfo.getGolesLocal() + " ante " + equipoLocal));
		}
    }
}
