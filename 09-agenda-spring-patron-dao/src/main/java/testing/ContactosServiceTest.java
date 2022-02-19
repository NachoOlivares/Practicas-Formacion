package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import configuration.ModeloConfig;
import dao.ContactosDao;
import model.Contacto;
import service.ContactosService;
import service.ContactosServiceImpl;

//Para que la clase este en el contexto de prueba usar las siguientes anotaciones
@ExtendWith(SpringExtension.class)	//Aplicar extensiones de pruebas de spring
@ExtendWith(MockitoExtension.class)	//Para probar sin aplicar cambios a la BD (cosa irresponsable) usar suplantador para el dao => mock
@ContextConfiguration(classes = { ModeloConfig.class })	//Como vamos a probar la logica de negocio le pasamos solo el modeloconfig y no el controller
public class ContactosServiceTest {

	@Mock	//Uso de suplantador en la capa de servicio en lugar del original
	ContactosDao dao;
	//Con esto probamos el servicio, no el acceso a la base de datos
	
	ContactosServiceImpl service;
	@BeforeEach
	void OnInit() {
		service = new ContactosServiceImpl(dao);
	}

	@Test
	void testRecuperarContacto() {
		//Con when definimos que devolveria al llamar a ciertos metodos (ya que no usamos la bd para confirmarlo)
		when(dao.findByEmail("jinx@gmail.com")).thenReturn(new Contacto("jinx", 10, "jinx@gmail.com"));
		when(dao.findByEmail("nonexisting.com")).thenReturn(null);
		//prueba de la capa de servicio
		assertEquals("jinx", service.buscar("jinx@gmail.com").getNombre());
		assertNull(service.buscar("nonexisting.com"));
	}

	@Test
	void testEliminarContacto() {
		when(dao.findByEmail("jinx@gmail.com")).thenReturn(new Contacto("jinx", 10, "jinx@gmail.com"));
		assertTrue(service.eliminar("jinx@gmail.com"));
	}
	
	@Test
	void agregarContacto() {
		//Cuando se busque el email jinx@gmail.com que devuelva un contacto existente
		when(dao.findByEmail("jinx@gmail.com")).thenReturn(new Contacto("jinx", 10, "jinx@gmail.com"));
		//Por tanto que al agregar un contacto existente no deberia permitir agregarlo
		assertFalse(service.agregar(new Contacto("jinx", 10, "jinx@gmail.com")));
	}
	
}
