package com.whiteam.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

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

@Api("Prueba Swagger from BD")
@CrossOrigin("*")
@RestController
public class CursosController {

	@Autowired
	CursosService app;

	@ApiOperation("Dar de alta")
	@RolesAllowed({"USER"})
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alta(@ApiParam @RequestBody Curso curso) {
		app.AltaCurso(curso);
	}

	@ApiOperation("ACtualizar curso")
	@RolesAllowed({"USER"})
	@PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso actualizacion(@ApiParam @RequestBody Curso curso) {
		return app.actualizarCurso(curso);
	}

	@ApiOperation("Mostrar todos los cursos")
	@RolesAllowed({"ADMIN"})
	@GetMapping(value = "showall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> ListCursos() {
		return app.recuperarTodos();
	}

	@ApiOperation("Mostrar curso por denominacion")
	@RolesAllowed({"USER"})
	@DeleteMapping(value = "curso/{denominacion}")
	public boolean eliminar(@ApiParam @PathVariable("denominacion") String denominacion) {
		if (app.recuperarTodos().stream().anyMatch(t -> t.getDenominacion().equals(denominacion))) {
			app.eliminarCursos(denominacion);
			return true;
		}
		return false;
	}

	@ApiOperation("Mostrar cursos con duracion menor de")
	@RolesAllowed({"ADMIN"})
	@GetMapping(value = "cursosduracion/{duracion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosCortos(@ApiParam @PathVariable("duracion") int duracion) {
		return app.cursosDuracionMaxima(duracion);
	}

	@ApiOperation("Mostrar cursos por tematica")
	@RolesAllowed({"USER"})
	@GetMapping(value = "cursostematica/{tematica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosTematica(@ApiParam @PathVariable("tematica") String tematica) {
		return app.cusosPorTematica(tematica);
	}

	@ApiOperation("Listar tematicas de cursos")
	@RolesAllowed({"USER"})
	@GetMapping(value = "tematicas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> tematicas() {
		return app.recuperarTodos().stream().map(Curso::getTematica).distinct().collect(Collectors.toList());
	}
}
