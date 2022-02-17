package controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.AlumnosService;
import service.CursosService;

@CrossOrigin("*")
@Controller
public class AlumnosCursosController {
	@Autowired
	AlumnosService serviceAlumnos;
	@Autowired
	CursosService serviceCursos;

	@PostMapping("altaAlumno") // gestiona la pulsación del botón de alta
	public String altaAlumno(@ModelAttribute("alumno") Alumno alumno, @RequestParam("idCurso") int idCurso) {
		serviceAlumnos.altaAlumno(alumno, idCurso);
		return "Inicio";
	}

	@GetMapping(value = "buscarAlumnos", produces = MediaType.APPLICATION_JSON_VALUE) // gestiona la pulsación del botón de búsqueda
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("idCurso") int idCurso) {
		/*	request.setAttribute("alumnos", serviceAlumnos.alumnosCurso(idCurso));
		return "forward:/paginaBusqueda";	*/
		return serviceAlumnos.alumnosCurso(idCurso);
	}
	
	//devolver lista de cursos para peticion AJAX
	@GetMapping(value="ListaCursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos(){
		return serviceCursos.curso();
	}

	@GetMapping("paginaBusqueda") // pulsación del enlace a página de busqueda
	public String paginaBusqueda(HttpServletRequest request) {
		request.setAttribute("cursos", serviceCursos.curso());
		return "seleccionAlumnos";
	}

	@GetMapping("paginaAlta") // pulsación del enlace a página de alta
	public String paginaAta(HttpServletRequest request) {
		request.setAttribute("cursos", serviceCursos.curso());
		return "paginaAlta";
	}
}
