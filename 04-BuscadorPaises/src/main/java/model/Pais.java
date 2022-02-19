package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pais {

	//Anotacion para adaptar nombre de atributos a propiedades json
	@SerializedName(value="name")
	@Expose
	private String nombre;
	
	@SerializedName("region")
	@Expose
	private String continente;

	@Expose
	private String capital;
	
	@SerializedName("population")
	@Expose
	private long habitantes;
	//Con esto el json mapea sus propiedades con las nuestras
	
	public Pais(String nombre, String continente, String capital, long habitantes) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.capital = capital;
		this.habitantes = habitantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}
	
}
