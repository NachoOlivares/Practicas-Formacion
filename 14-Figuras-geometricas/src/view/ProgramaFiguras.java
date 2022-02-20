package view;

import geometria.Circulo;
import geometria.Figura;
import geometria.Triangulo;

//Polimorfismo: usar una misma version para llamar
//A diferentes versiones de un metodo. No hace falta que la clase sea abstracta para usar polimorfismo
public class ProgramaFiguras {

	//Este metodo vale para sacar los datos de cualquier figura,
	//sin necesitas de repetir codigo para cada una
	private static void mostrarDatos(Figura f) {
		System.out.println("Color=> "+f.getColor());
		System.out.println("Superficie=> "+f.superficie());
	}

	public static void main(String[] args) {
		Figura circle = new Circulo("verde", 5);
		Figura triangle = new Triangulo("Azul", 10, 4);
		System.out.println("Circulo: ");
		mostrarDatos(circle);
		System.out.println("\n");
		System.out.println("Triangulo: ");
		mostrarDatos(triangle);
	}

}
