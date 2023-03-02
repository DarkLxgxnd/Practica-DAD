package es.codeurjc.emperorsleague.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clasificacion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @OneToMany(mappedBy = "clasificacion")
    private List<Equipo> equipos;

    public Clasificacion() {
    }

    public long getId() {
        return id;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void ordenarEquipos() {
        Collections.sort(this.equipos, new CompararPorPuntos());

        int puesto = 1;
        for (Equipo equipo: equipos) {
            equipo.setRanking(puesto);
            puesto++;
        }
    }

    class CompararPorPuntos implements Comparator<Equipo> {
        public int compare(Equipo o1, Equipo o2) {
            return o2.getPuntos() - o1.getPuntos();
        }
    }
}
