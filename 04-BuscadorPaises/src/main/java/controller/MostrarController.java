package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pais;
import service.MasHabitantesServicio;
import service.MostrarContinentesServicio;
import service.MostrarPaisesServicio;

@Controller
public class MostrarController {
	@Autowired
	MostrarPaisesServicio service;

	// Peticion get, tambien podria ser post para postear datos
	// Le indicamos tambien la direccion asociada a este metodo
	@GetMapping("MostrarPaises")
	public String buscar(@RequestParam("clave") String key, HttpServletRequest request, HttpServletRequest request2) {

		List<Pais> paises = service.PaisesDatos(key);
		request.setAttribute("paises", paises);
		request2.setAttribute("key", key);

		// Para que spring lleve a una pagina, devolver el nombre de la misma
		return "Resultado";
		// Si fuera otro controlador lo que queremos retornar
		// return "forward:/direccion_controlador";
	}
	
	@Autowired
	MostrarContinentesServicio apk;
	
	@GetMapping({"MostrarContinentes", "/"})
	public String continentes(HttpServletRequest request) {
		
		List<String> continentes = apk.MostrarContinentes();
		request.setAttribute("continentes", continentes);
		
		return "Continentes";
	}

	@Autowired
	MasHabitantesServicio app;

	//@GetMapping("/") de esta forma este controller se cargara al cargar la pagina inicial. Tambien lo haria con /Inicio
	@GetMapping("MasHabitantes")
	public String habitantes(@RequestParam(value = "clave", required = false) Long key, HttpServletRequest request, HttpServletRequest request2) {

		if (key != null && key > 0) {
			List<Pais> habitantes = app.PaisesMasHabitantes(key);
			request.setAttribute("habitantes", habitantes);
			request2.setAttribute("key", key);
			return "Resultado2";
		} else {return "Error";}
	}

}