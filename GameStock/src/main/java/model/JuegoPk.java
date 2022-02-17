package model;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class JuegoPk {

	private String nombre;
	private int Jid;
	public JuegoPk(String nombre, int jid) {
		super();
		this.nombre = nombre;
		Jid = jid;
	}
	public JuegoPk() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getJid() {
		return Jid;
	}
	public void setJid(int jid) {
		Jid = jid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Jid, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JuegoPk other = (JuegoPk) obj;
		return Jid == other.Jid && Objects.equals(nombre, other.nombre);
	}
	
}
