package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.ProgramacionFuncionalidad;

class ProgramacionFuncionalidadTest {

	ProgramacionFuncionalidad service;
	List<String> cadenas = new ArrayList<>();
	List<String> compList = new ArrayList<>();
	List<Integer> numeros = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		service = new ProgramacionFuncionalidad();
		cadenas = List.of("aString1", "Sa2", "AString3", "Sa4", "aString5");
		compList.clear();
		numeros = List.of(1, 2, 3, 4, 5);
	}

	@Test
	void TestCadenas() {
		assertEquals(3, (service.Cadenas(cadenas, t -> t.startsWith("a") || t.startsWith("A"))).size());
	}

	@Test
	void TestCadenasProc() {
		service.CadenasProc(cadenas, t -> t.length() % 2 == 0, t -> {
			compList.add(t);
		});
		assertEquals(3, compList.size());
	}

	@Test
	void TestTransformacion() {
		service.Transformacion(cadenas, 
				t -> t.equals(t), 
				(a, b) -> a + " --> " + b, 
				() -> (numeros), 
				t -> {
					compList.add(t);
				}
			);
		assertEquals("aString5 --> 5", compList.get(4));
	}

}
