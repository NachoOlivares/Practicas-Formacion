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

import com.whiteam.model.Formacion;
import com.whiteam.service.FormacionService;
@CrossOrigin("*")
@RestController
public class FormacionController {
	@Autowired
	FormacionService service;
	@GetMapping(value="formaciones",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> formaciones(){
		return service.existentes();
	}
	@PostMapping(value="formacion", 
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> alta(@RequestBody Formacion formacion) {
        return service.alta(formacion);
    }
    @DeleteMapping(value="formaciones/{turno}",
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> eliminacion(@PathVariable("turno") String turno) {
        return service.eliminarPorTurno(turno);
    }
	
}
