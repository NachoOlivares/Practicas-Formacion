package testing;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import configuration.modeloConfig;
import dao.JuegosDao;
import model.Juego;
import service.JuegosServiceImpl;

@ExtendWith(MockitoExtension.class) 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { modeloConfig.class }) 
 
public class JuegosServiceTest {
	//queremos que Spring utilice este suplantador
	//en la capa de servicio, en lugar del dao original
	@Mock
	JuegosDao dao;
	JuegosServiceImpl service;
	@BeforeEach
	void init() {
		service=new JuegosServiceImpl(dao);
		//supuestos para el mock
	}

	@Test
	void AddGameTest() {
		when(dao.findById("Alicia")).thenReturn(new Juego("Alicia","rol",2015));
		assertFalse(service.AddGame(new Juego("Alicia","rol",2015)));
	}
	
	@Test
	void RemoveTest() {
		when(dao.SearchGame("Alicia")).thenReturn(new Juego("Alicia","rol",2015));
		assertTrue(service.removeGame("Alicia"));
	}

}
