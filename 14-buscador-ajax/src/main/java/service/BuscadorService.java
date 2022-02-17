package service;

import java.util.List;

import model.item;

public interface BuscadorService {

	//Prototipo de buscador web
	List<item> buscar(String clave);

}