package service;

import java.util.List;

import model.Pais;

public interface MasHabitantesServicio {

	List<Pais> PaisesMasHabitantes(Long population);

}