package com.whiteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiteam.dao.CursosDao;
import com.whiteam.model.Curso;
@Service	
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosDao dao;

	@Override
	public void altaCurso(Curso curso) {
		if(dao.findByDenominacion(curso.getDenominacion())==null) {
			dao.save(curso);
		}

	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		if(dao.findByDenominacion(curso.getDenominacion())!=null) {
			dao.save(curso);
			return curso;
		}
		return null;
		
	}

	@Override
	public List<Curso> recuperarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> cursosDuracionMaxima(int duracion) {
		return dao.findByDuracionLessThan(duracion);
	}

	@Override
	public void eliminarCursos(String denominacion) {
		dao.deleteByDenominacion(denominacion);

	}

	@Override
	public List<Curso> cursosPorTematica(String tematica) {
		return dao.findByTematica(tematica);
	}

}
