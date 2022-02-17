package service;

import java.util.List;

import model.Juego;

public interface JuegosService {

	boolean AddGame(Juego juego);
	
	boolean removeGame(String nombre);
	
	Juego searchGame(String nombre);


	List<Juego> listGames();


	List<Juego> ListGameYear(int year);

}