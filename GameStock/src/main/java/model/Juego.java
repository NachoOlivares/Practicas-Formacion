package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "videojuegos")
@NamedQuery(name="Juego.ListGameYear", query="SELECT c FROM Juego c WHERE c.year=?1")
public class Juego {
	

	@Id
	private String nombre;
	private String genero;
	private int year;
	public Juego(String nombre, String genero, int year) {
		super();
		this.nombre = nombre;
		//this.Jid = Jid;
		this.genero = genero;
		this.year = year;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Juego() {
		super();
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
