package service;

import java.util.List;

import model.Curso;

public interface CursosService {
	boolean nuevoCurso(Curso curso);
	Curso cursoPorId(int idCurso);
	List<Curso> curso();
}
