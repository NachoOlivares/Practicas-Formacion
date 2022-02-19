package view;


import java.util.List;

public class ProgramacionFuncionalView {

	public static void main(String[] args) {
		List<Integer> numeros = List.of(1, 2, 3, 4, 5);
		List<String> cadenas = List.of("aString1", "Sa2", "AString3", "Sa4", "aString5");
		service.ProgramacionFuncionalidad service = new service.ProgramacionFuncionalidad();
		

		//Mostrar cadenas que empiecen por a
		System.out.println("Cadenas que empiezan por a: ");
		System.out.println(service.Cadenas(cadenas, t-> t.startsWith("a") || t.startsWith("A"))+"\n\n\n\n");

		//Mostrar cadenas que contengan mas de 3 caracteres
		System.out.println("Cadenas que contienen mas de 3 caracteres: ");
		System.out.println(service.Cadenas(cadenas, t-> t.length()>3 || t.startsWith("A"))+"\n\n\n\n");

		System.out.println("cadenas con un numero par de caracteres: ");
		//Indicar cuantas cadenas del conjunto tienen un numero par de caracteres
		service.CadenasProc(cadenas, t-> (t.length())%2==0, System.out::println);
		System.out.println("\n\n\n\n");

		System.out.println("Concatenacion de cadenas y lista de numeros: ");
		//Mostrar el resultado de concatenar a cada cadena su correspondiente numero de la lista
		service.Transformacion(cadenas, 
				t->t.equals(t),
				(a, b)->a+" --> "+b,
				()->(numeros),
				t->System.out.println(t));
	}

}
