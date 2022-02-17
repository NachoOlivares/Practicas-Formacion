package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.JuegosDao;
import model.Juego;

@Service
public class JuegosServiceImpl implements JuegosService {

	JuegosDao daoJuegos;

	public JuegosServiceImpl(@Autowired JuegosDao daoJuegos) {
		this.daoJuegos = daoJuegos;
	}

	@Override
	public boolean AddGame(Juego juego) {
		Juego Juego = daoJuegos.getById(juego.getNombre());
		if (Juego == null) {
			daoJuegos.save(juego);
			return true;
		}
		return false;
	}

	@Override
	public Juego searchGame(String nombre) {
		return daoJuegos.findById(nombre).orElse(null);
	}

	@Override
	public boolean removeGame(String nombre) {
		Juego juego = daoJuegos.getById(nombre);
		if (juego.getNombre() != null) {
			daoJuegos.deleteById(nombre);
			return true;
		}
		return false;
	}

	@Override
	public List<Juego> listGames() {
		return daoJuegos.findAll();
	}

	@Override
	public List<Juego> ListGameYear(int year){
		return daoJuegos.ListGameYear(year);
	}
}
