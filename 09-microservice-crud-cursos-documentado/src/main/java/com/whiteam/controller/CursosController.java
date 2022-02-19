package com.whiteam.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whiteam.model.Curso;
import com.whiteam.service.CursosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Operaciones CRUD sobre cursos")
@CrossOrigin("*")
@RestController
public class CursosController {

	@Autowired
	CursosService app;

	
	@ApiOperation("Alta de nuevos cursos")
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alta(@ApiParam("Datos del curso") @RequestBody Curso curso) {
		app.AltaCurso(curso);
	}

	@PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso actualizacion(@RequestBody Curso curso) {
		return app.actualizarCurso(curso);
	}

	@ApiOperation("Devuelve lista de cursos registrados")
	@GetMapping(value = "showall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> ListCursos() {
		return app.recuperarTodos();
	}

	@DeleteMapping(value = "curso/{denominacion}")
	public boolean eliminar(@PathVariable("denominacion") String denominacion) {
		if (app.recuperarTodos().stream().anyMatch(t -> t.getDenominacion().equals(denominacion))) {
			app.eliminarCursos(denominacion);
			return true;
		}
		return false;
	}

	@GetMapping(value = "cursosduracion/{duracion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosCortos(@PathVariable("duracion") int duracion) {
		return app.cursosDuracionMaxima(duracion);
	}

	@GetMapping(value = "cursostematica/{tematica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosTematica(@PathVariable("tematica") String tematica) {
		return app.cusosPorTematica(tematica);
	}

	@GetMapping(value = "tematicas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> tematicas() {
		return app.recuperarTodos().stream().map(Curso::getTematica).distinct().collect(Collectors.toList());
	}
}
