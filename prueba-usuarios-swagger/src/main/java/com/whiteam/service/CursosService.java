package com.whiteam.service;

import java.util.List;

import com.whiteam.dao.CursosDao;
import com.whiteam.model.Curso;

public interface CursosService extends CursosDao{

	void AltaCurso(Curso curso);
	
	Curso actualizarCurso(Curso curso);
	
	List<Curso> recuperarTodos();
	
	List<Curso> cursosDuracionMaxima(int duracion);
	
	void eliminarCursos(String denominacion);
	
	List<Curso> cusosPorTematica(String tematica);
	
}
