package dao;

import java.util.List;

import model.Contacto;


public interface ContactosDao {

	void save(Contacto contacto);
	Contacto findById(int idContacto);
	Contacto findByEmail(String email);
	void delete(Contacto contacto);
	List<Contacto> findAll();
}
