package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Juego;


public interface JuegosDao  extends JpaRepository<Juego, String>{

	@Query(name="Juego.ListGameYear")
	List<Juego> ListGameYear(int year);

}
