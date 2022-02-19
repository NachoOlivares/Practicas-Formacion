package com.whiteam.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.whiteam.dao.CursosDao;
import com.whiteam.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public void AltaCurso(Curso curso) {
		if (dao.findByDenominacion(curso.getDenominacion()) == null) {
			dao.save(curso);
		}
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		if (dao.findByDenominacion(curso.getDenominacion()) != null) {
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
	public List<Curso> findByTematica(String tematica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> findByDuracionLessThan(int duracion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByDenominacion(String denominacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso findByDenominacion(String denominacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Curso> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Curso> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Curso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Curso> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Curso entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Curso> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Curso> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Curso> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Curso> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Curso, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> cusosPorTematica(String tematica) {
		// TODO Auto-generated method stub
		return null;
	}




}
