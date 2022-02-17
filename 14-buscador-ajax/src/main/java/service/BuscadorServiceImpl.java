package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import model.item;

//Anotaciones para que spring cree los objetos cuando arranque
//@Service es para la capa de servicio
@Service
public class BuscadorServiceImpl implements BuscadorService {

	List<item> items = List.of(
			new item("Casa del libro", "http://casadellibro.es", new String[] { "libros", "lectura", "ocio" },
					"Libros y más cosas"),
			new item("La web del gamer", "http://gamers.es", new String[] { "juegos", "ordenadores", "ocio" },
					"Todo sobre video juegos"),
			new item("My computer", "http://computerall.es", new String[] { "informática", "ordenadores" },
					"Ordenadores al mejor precio"),
			new item("Fnac", "http://fnac.es", new String[] { "juegos", "ordenadores", "libros" },
					"Bienvenido al mundo del ocio y la cultura"),
			new item("Todo pelis", "http://filmers.es", new String[] { "cine", "peliculas", "ocio" },
					"Entra en el mundo del cine"));

	//Prototipo de buscador web
	@Override
	public List<item> buscar(String clave) {
		return items.stream()
				//Para acceder a los datos del array Seo hay que hacer un stream dentro del filter como Arrays
				//y pasarle anyMatch para ver si cada posicion del array contiene la clave
				//Es equivalente a desfragmentar los valores de Seo dentro de items y comparar uno por uno
				.filter(t->Arrays.stream(t.getSeo()).anyMatch(n->n.contains(clave)))
				.collect(Collectors.toList());
	}
}


