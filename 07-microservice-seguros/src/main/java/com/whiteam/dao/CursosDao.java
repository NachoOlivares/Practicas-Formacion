package com.whiteam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.whiteam.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{

	List<Curso> findByTematica(String tematica);
	
	@Query("SELECT c FROM Curso c WHERE c.duracion<=?1")
	List<Curso> findByDuracionLessThan(int duracion);
	
	@Modifying
	@Transactional
	void deleteByDenominacion(String denominacion);

	Curso findByDenominacion(String denominacion);
}
