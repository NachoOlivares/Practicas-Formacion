package geometria;

public class Circulo extends Figura {

	private int radio;
	
	
	public Circulo(String color, int radio) {
		super(color);
		this.radio = radio;
	}
	

	//Todas las clases herederas del padre bastracto
	//Tienen que sobreescribir los metodos abstractos
	//Respetando el modelo (En este caso que el nombre de la clase sea superficie
	@Override
	public double superficie() {
		//return Math.PI*radio*radio;
		return Math.PI*Math.pow(radio,2);
	}

}
