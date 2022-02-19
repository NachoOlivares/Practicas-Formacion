package controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.ContactosService;

@Controller
public class ContactosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired ContactosService app;
	
	@PostMapping("AddContact")	//ModelAttribute va añadiendo al objeto especificado los inputs retornados en el jsp
	public String agregar(@ModelAttribute("contacto") Contacto contactos) {

		app.agregar(contactos);

		// Para que spring lleve a una pagina, devolver el nombre de la misma
		return "Info";
		// Si fuera otro controlador lo que queremos retornar
		// return "forward:/direccion_controlador";
	}
	
	@GetMapping("DeleteContact")
	public String eliminar(@RequestParam("email") String key, HttpServletRequest request) {
		app.eliminar(key);
		//Asi se ejecuta el controlador ListContact tras este
		return "forward:/ListContact";
	}
	
	@GetMapping("SearchContact")
	public String buscar(@RequestParam("clave") String key, HttpServletRequest request) {
		request.setAttribute("contacto", app.buscar(key));
		return "buscar";
	}
	
	@GetMapping("ListContact")
	public String listar(HttpServletRequest request) {
		List<Contacto> contactos = app.recuperarContactos();
		request.setAttribute("contactos", contactos);
		return "ListadoContactos";
	}
}
