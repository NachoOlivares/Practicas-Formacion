package com.whiteam.service;

import java.util.List;

import com.whiteam.modelo.Formacion;

public interface FormacionService {

	List<Formacion> alta(Formacion formacion);
	
	List<Formacion> eliminarPorTurno(String turno);
	
	List<Formacion> existentes();
}
