package controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
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

import model.Juego;
import service.JuegosService;

@CrossOrigin("*")
@Controller
public class GameController extends HttpServlet {
	@Autowired
	JuegosService service;

	// Peticion get, tambien podria ser post para postear datos
	// Le indicamos tambien la direccion asociada a este metodo
	@PostMapping(value = "AddGame", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean AddGame(@ModelAttribute("Juego") Juego juego, HttpServletRequest request) {
		if (service.searchGame(juego.getNombre())==null) {
			service.AddGame(juego);
			return true;
		}
		return false;
	}

	@GetMapping(value = "SearchGames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Juego JuegoBuscado(@RequestParam("nombre") String key) {
		//Juego error = new Juego("Error", "El juego que busca no existe", 404);
		//if (service.searchGame(key) != null) {
			return service.searchGame(key);
		//} else {
		//	return error;
		//}

	}
	@CrossOrigin("*")
	@GetMapping(value="ListGames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Juego> Games() {
		return service.listGames();

	}

	@PostMapping(value="DeleteGame", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean Delete(@RequestParam("nombre") String key) {
		if(service.searchGame(key)!=null) {
			service.removeGame(key);
			return true;
		}
		return false;
	}

	@GetMapping(value="ListGameYear", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Juego> GamesYear(@RequestParam("year") int year) {
		List<Juego> juegosNull = null;
		if(service.ListGameYear(year)!=null) {
			return service.ListGameYear(year);
		}
		return juegosNull;
	}
}
