package es.codeurjc.emperorsleague.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clasificacion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    public Clasificacion() {
    }
}
