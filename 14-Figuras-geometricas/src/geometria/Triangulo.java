package geometria;

public class Triangulo extends Figura {
	private int base, altura;
	

	public Triangulo(String color, int base, int altura) {
		//Al construir se genera automaticamente el color en super
		//Ya que lo hereda de la clase padre
		super(color);
		this.base = base;
		this.altura = altura;
	}


	//Como la clase es abstracta se sobrescribe el metodo superficio (abstracto)
	@Override
	public double superficie() {
		return base*altura/2;
	}

}
