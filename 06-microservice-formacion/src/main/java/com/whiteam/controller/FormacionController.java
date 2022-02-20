package com.whiteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whiteam.modelo.Formacion;
import com.whiteam.service.FormacionService;

@CrossOrigin("*")
@RestController
public class FormacionController {

	@Autowired
	FormacionService app;

	@GetMapping(value="formaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> formaciones(){
		return app.existentes();
	}
	
	//consumes solo para peticiones post o put
	@PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> alta(@RequestBody Formacion formacion) {
		return app.alta(formacion);
	}
	
	@DeleteMapping(value="formaciones/{turno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> eliminar(@PathVariable("turno") String turno){
		return app.eliminarPorTurno(turno);
	}
}
