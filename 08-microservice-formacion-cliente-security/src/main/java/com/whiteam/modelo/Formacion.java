package com.whiteam.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formacion {

	@JsonProperty("denominacion")
	private String curso;
	@JsonProperty("tematica")
	private String asignatura;
	private int duracion;
	private String turno;
	public Formacion(String curso, String asignatura, int duracion, String turno) {
		super();
		this.curso = curso;
		this.asignatura = asignatura;
		this.duracion = duracion;
		this.turno = turno;
	}
	public Formacion() {
		super();
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
}
