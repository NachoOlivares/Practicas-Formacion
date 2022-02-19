package com.whiteam.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiteam.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	String urlBase="http://servicio-cursos";
	@Autowired
	RestTemplate template;

	@Override
	public List<Formacion> alta(Formacion formacion) {
		template.postForLocation(urlBase+"/curso", formacion);
		//return Arrays.asList(template.getForObject(urlBase+"/cursos", Formacion[].class));
		return List.of(template.getForObject(urlBase+"/cursos", Formacion[].class));
	}

	@Override
	public List<Formacion> eliminarPorTurno(String turno) {
		List<Formacion> todos=existentes();
		todos.stream()
		.filter(f->f.getTurno().equals(turno))
		.forEach(f->{
			template.delete(urlBase+"/curso/{denominacion}",f.getCurso());
		});
		return List.of(template.getForObject(urlBase+"/cursos", Formacion[].class));
	}

	@Override
	public List<Formacion> existentes() {
		List<Formacion> todos=List.of(template.getForObject(urlBase+"/cursos", Formacion[].class));
		todos.forEach(f->{
			if(f.getCurso().toLowerCase().contains("java")) {
				f.setTurno("diurno");
			}else {
				f.setTurno("tarde");
			}
		});
		return todos;
		
	}

}
