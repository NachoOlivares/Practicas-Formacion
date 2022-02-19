package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ContactosDao;
import model.Contacto;

//Interfaz para definir condiciones para aplicar los metodos del service
//Tambien llamado logica de negocio

@Service
public class ContactosServiceImpl implements ContactosService {

	// @Autowired
	// ContactosDao dao;
	// Esta forma de wirear es la recomendada (para testear con mocks hay que usar
	// esto)
	private ContactosDao dao;

	public ContactosServiceImpl(@Autowired ContactosDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean agregar(String nombre, String email, int edad) {
		if (dao.findByEmail(email) == null) {
			dao.save(new Contacto(nombre, edad, email));
			return true;
		}
		return false;
	}

	@Override
	public boolean agregar(Contacto contacto) {
		return agregar(contacto.getNombre(), contacto.getEmail(), contacto.getEdad());
	}

	@Override
	public Contacto buscar(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public boolean eliminar(String email) {
		Contacto contacto = dao.findByEmail(email);
		if (contacto != null) {
			dao.delete(contacto);
			return true;
		}
		return false;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		return dao.findAll();
	}

	@Override
	public Contacto buscarPorClave(int idContacto) {
		return dao.findById(idContacto);
	}

	@Override
	public boolean eliminarPorClave(int idContacto) {
		Contacto contacto = dao.findById(idContacto);
		if (contacto != null) {
			dao.delete(contacto);
			return true;
		}
		return false;
	}

}
