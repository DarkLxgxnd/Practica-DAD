package es.codeurjc.emperorsleague.events;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.codeurjc.emperorsleague.model.Equipo;
import es.codeurjc.emperorsleague.model.Partido;

@Component
public class PartidoSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendPartido(Partido partido) {
        List<Equipo> equipos = partido.getEquiposParticipantes();
        String equipoLocal = equipos.get(0).getNombre();
        String equipoVisitante = equipos.get(1).getNombre();

        PartidoInfo partidoInfo = new PartidoInfo(partido.getGolesLocal(), partido.getGolesVisitante(), equipoLocal, equipoVisitante);
        rabbitTemplate.convertAndSend("partidos", partidoInfo);
    }
}
