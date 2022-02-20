package geometria;

//Clase padre
//Si definimos un metodo abstracto(No sabemos que va a necesitar) hay que definir la clase tambien como abstracta
public abstract class Figura {
	
	private String color;

	public Figura(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double superficie();
	

}
