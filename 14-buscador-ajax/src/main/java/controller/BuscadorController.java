package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.item;
import service.BuscadorService;

//Esta anotacion significa que confie en cualquier acceso desde otra red
//@CrossOrigin("*")
@Controller
public class BuscadorController {
	@Autowired
	BuscadorService service;
	
	//Peticion get, tambien podria ser post para postear datos
	//Le indicamos tambien la direccion asociada a este metodo
	@GetMapping(value = "buscarDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<item> buscar(@RequestParam("clave") String palabraClave) {
		
		//Para que spring lleve a una pagina, devolver el nombre de la misma
		return service.buscar(palabraClave);
		//Si fuera otro controlador lo que queremos retornar
		//return "forward:/direccion_controlador";
	}
}
