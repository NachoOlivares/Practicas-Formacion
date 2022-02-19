package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

//Anotaciones para persistencia
@Entity
@Table(name = "contactos")
public class Contacto {

	// @Id para indicar cual va a ser la clave primaria (necesario para capa de
	// persistencia)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generated value para valores que puede no sean rellenados,
	@Column (name="idcontactos")													// para evitar problemas (campos autogenerados)
	private Integer idContacto;
	// @Column (name = "nombre")//persistencia, @Column hace lo mismo que
	// @SerializedName pero para atributos de tabla bd
	private String nombre;
	private int edad;
	private String email;

	public Contacto(Integer idContacto, String nombre, int edad, String email) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	public Contacto(String nombre, int edad, String email) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	// Constructor vacio por si no se permitiera algun tipo de dato con un valor
	// determinado (como null)
	// Para persistencia es obligatorio
	public Contacto() {
	}

	public Integer getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
