//Fichero para dividir logica de empresa de logica de datos
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;

@Repository
public class ContactosDaoImpl implements ContactosDao {

	@PersistenceContext
	EntityManager emanager;
	
	@Transactional
	@Override
	public void save(Contacto contacto) {
		emanager.persist(contacto);

	}

	@Override
	public Contacto findById(int idContacto) {
		return emanager.find(Contacto.class, idContacto);
	}

	@Override
	public Contacto findByEmail(String email) {
		var jpql = "SELECT c FROM Contacto c WHERE c.email=?1";
		var query = emanager.createQuery(jpql, Contacto.class);
		query.setParameter(1, email);
		var resultados = query.getResultList();
		return resultados.size()>0?resultados.get(0):null;
	}

	@Transactional
	@Override
	public void delete(Contacto contacto) {
		//Para eliminar objetos en base de datos usar refresh (incluye el objeto de persistencia)
		//emanager.refresh(contacto);
		//emanager.remove(contacto);
		emanager.remove(findById(contacto.getIdContacto()));

	}

	@Override
	public List<Contacto> findAll() {
		String jpql = "SELECT c FROM Contacto c";
		TypedQuery<Contacto> query = emanager.createQuery(jpql, Contacto.class);
		return query.getResultList();
	}

}
