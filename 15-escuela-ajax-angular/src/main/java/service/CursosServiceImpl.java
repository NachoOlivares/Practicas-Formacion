package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDao;
import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	private CursosDao dao;
	public CursosServiceImpl(@Autowired CursosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public boolean nuevoCurso(Curso curso) {
		if(dao.findByName(curso.getDenominacion())==null) {
			dao.save(curso);
			return true;
		}
		return false;
	}

	@Override
	public Curso cursoPorId(int idCurso) {
		return dao.findById(idCurso);
	}

	@Override
	public List<Curso> curso(){
		return dao.findAll();
	}
}
