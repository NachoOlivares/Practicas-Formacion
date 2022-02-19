package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	boolean agregar (String nombre, String email, int edad);
	boolean agregar(Contacto contacto);
	Contacto buscar(String email);
	boolean eliminar (String email);
	List<Contacto> recuperarContactos();
	
	//Metodos para persistencia
	Contacto buscarPorClave(int idContacto);
	boolean eliminarPorClave(int idContacto);
}
