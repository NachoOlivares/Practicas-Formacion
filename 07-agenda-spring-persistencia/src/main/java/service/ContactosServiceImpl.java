package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;

@Service
public class ContactosServiceImpl implements ContactosService {

	// Capa persistencia
	@PersistenceContext
	EntityManager emanager;

	@Override
	public boolean agregar(String nombre, String email, int edad) {
		return this.agregar(new Contacto(nombre, edad, email));
	}

	@Transactional
	@Override
	public boolean agregar(Contacto contacto) {
		// persist añade el objeto a una nueva fila en la tabla de la bd
		emanager.persist(contacto);
		return true;
	}

	@Override
	public Contacto buscar(String email) {
		String jpql="SELECT c FROM Contacto c WHERE c.email=?1"; //AND c.nombre=?2
		var query = emanager.createQuery(jpql, Contacto.class);
		query.setParameter(1, email);
		var resultados = query.getResultList();
		return resultados.size()>0?resultados.get(0):null;
		//Si la lista creada contiene algo(el contacto buscado) devuelve ese mismo contacto (en posicion 0)
		//Si no devuelve null
		//Tambien se podria conseguir de la siguiente forma:
		/*	try{
		 * 		return query.getSingleResult();
		 * 	} catch(NonUniqueResultException | NoResultException e){
		 * 		return null;
		 * 	}
		 * */
	}

	@Transactional
	@Override
	public boolean eliminar(String email) {
		var jpql = "DELETE FROM Contacto c WHERE c.email=?1";
		var query = emanager.createQuery(jpql);
		query.setParameter(1, email);
		return query.executeUpdate()>0;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		//Aqui Contacto hace referencia a la entidad(modelo) no a la tabla
		String jpql="SELECT c FROM Contacto c";
		TypedQuery<Contacto> query = emanager.createQuery(jpql, Contacto.class);
		return query.getResultList();
	}

	@Override
	public Contacto buscarPorClave(int idContacto) {
		return emanager.find(Contacto.class, idContacto);
	}

	@Transactional
	@Override
	public boolean eliminarPorClave(int idContacto) {
		Contacto contacto = buscarPorClave(idContacto);
		if (contacto != null) {
			emanager.remove(contacto);
			return true;
		}
		return false;
	}

}
