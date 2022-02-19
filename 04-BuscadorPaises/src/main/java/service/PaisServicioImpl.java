package service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import locator.PaisLocator;
import model.Pais;

//Este servicio ya esta conectado con el json por el locator
@Service
public class PaisServicioImpl implements MostrarPaisesServicio, MasHabitantesServicio, MostrarContinentesServicio {
	
	List<Pais> a = PaisLocator.getPais().collect(Collectors.toList());
	
	@Override
	public List<String> MostrarContinentes(){
		return PaisLocator.getPais().map(Pais::getContinente).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Pais> PaisesDatos(String region){
		return PaisLocator.getPais().filter(t -> t.getContinente().equals(region)).collect(Collectors.toList());
	}
	
	@Override
	public List<Pais> PaisesMasHabitantes(Long population){
		return PaisLocator.getPais().filter(t->t.getHabitantes()>population).sorted(Comparator.comparing(t->t.getHabitantes())).collect(Collectors.toList());
	}

}
