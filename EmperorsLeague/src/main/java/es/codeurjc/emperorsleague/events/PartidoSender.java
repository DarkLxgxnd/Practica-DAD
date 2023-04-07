package es.codeurjc.emperorsleague.events;

import java.util.ArrayList;
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
        List<String> nombreEquipos = new ArrayList<>();
        
        for (Equipo equipo : partido.getEquiposParticipantes()) {
            nombreEquipos.add(equipo.getNombre());
        }

        PartidoInfo partidoInfo = new PartidoInfo(partido.getGolesLocal(), partido.getGolesVisitante(), nombreEquipos);
        rabbitTemplate.convertAndSend("partidos", partidoInfo);
    }
}
