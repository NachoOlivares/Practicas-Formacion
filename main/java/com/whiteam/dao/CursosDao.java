package com.whiteam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.whiteam.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{

	List<Curso> findByTematica(String tematica);
	Curso findByDenominacion(String denominacion);
	/*@Query("select c from Curso c where c.duracion<=?1")
	List<Curso> findByDuracionMax(int duracion);*/
	List<Curso> findByDuracionLessThan(int duracion);
	@Modifying
	@Transactional
	void deleteByDenominacion(String denominacion);
}
