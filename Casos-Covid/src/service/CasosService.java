package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import locator.CasosLocator;
import model.Data;
import model.Casos;

public class CasosService {

	Data data = CasosLocator.getCasos();
	List<Casos> datos = data.getData();

	public List<String> Municipios() {
		return datos.stream()
				.map(Casos::getMunicipio).distinct()
				.collect(Collectors.toList());
		}

	public long CasosAcumulados(String municipio) {
		return datos.stream()
				.filter(t->t.getMunicipio().equals(municipio))
				.max(Comparator.comparing(n->n.getCasostotales()))
				.orElse(new Casos(municipio, 0, 0, municipio))
				.getCasostotales();
	}
	
	public double IncidenciaAcumulada (String municipio) {
		return datos.stream().filter(t->t.getMunicipio().equals(municipio))
				.max(Comparator.comparing(n->TransformarFecha(n.getFecha())))//Aplicar la transformacion de fecha
				.orElse(new Casos(municipio, 0, 0, municipio))
				.getIncidencia();
	}
	
	public List<Casos> CasosActuales(){
			return datos.stream()
					.collect(Collectors.groupingBy(it->it.getMunicipio(),
								Collectors.maxBy(Comparator.comparing(it->TransformarFecha(it.getFecha())))))
					
					.values()  //colección de todos los últimos Item, pero encapsulados en Optional
					.stream()
					.map(n->n.orElse(new Casos(null, 0, 0, null)))
					.collect(Collectors.toList());
		}
	
	public double IncidenciaMedia() {
		return datos.stream()
				.map(Casos::getIncidencia)
				.collect(Collectors.averagingDouble(num -> Double.parseDouble(num.toString())));
	}
	
	public long CasosTotales() {
		return datos.stream()
				.map(Casos::getCasostotales)
				.collect(Collectors.summingLong(Long::longValue));
	}

	private LocalDate TransformarFecha (String fecha) {
		//Formatear fecha
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
	}
}