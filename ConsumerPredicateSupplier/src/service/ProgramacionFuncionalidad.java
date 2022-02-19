package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProgramacionFuncionalidad {

	// Metodo que reciba conjunto de cadena de caracteres
	// y que devuelva el total de cadenas que cumplan con un criterio
	public List<String> Cadenas(List<String> cadenas, Predicate<String> criterio) {
		List<String> resultado = new ArrayList<>();
		for (String cad : cadenas) {
			
			if (criterio.test(cad)) {
				resultado.add(cad);
			}

		}
		return resultado;

	}

	// Metodo que reciba conjunto de cadenas y procese aquellas cadenas
	// que cumplan el criterio
	public void CadenasProc(List<String> cadenas, Predicate<String> criterio, Consumer<String> proceso) {

		for (String cad : cadenas) {
			// Si se cumple el criterio para la lista de numeros
			if (criterio.test(cad)) {
				// Se almacena el resultado en el consumer
				proceso.accept(cad);
			}
		}
	}

	// Metodo que reciba una lista de cadenas y una lista de numeros.
	// Realizara una transformacion que sera aplicada a cada pareja cadena-numero, y
	// el resultado de esa transformacion sera procesado (imprimirlo por ejemplo)
	public void Transformacion(List<String> cadenas, 
			Predicate<String> criterio,
			BiFunction<String, Integer, String> tx, // datos de entrada y salida
			Supplier<List<Integer>> valor, // valor pasado para procesar junto con el principal
			Consumer<String> proceso) { // Resultado de la transformacion y como queremos retornarlo(imprimir...)

		String resultado;
		List<Integer> val = valor.get();
		var i = 0;
		for (String cad : cadenas) {
			Integer v = val.get(i);
			if (criterio.test(cad)) {
				// Para transformar el valor de la lista y añadirle el valor adicional que
				// queremos
				// hay que aplicar el BiFunction a cada numero de la lista junto con el valor
				// del Supplier

				resultado = tx.apply(cad, v);
				proceso.accept(resultado);
				i++;
				// Lo que devuelve lo pasamos al consumer que sera lo que retornemos

			}
			// BiFunction es coger dos valores y transformarlos dando el tipo de valor
			// resultado
		}
	}

	// Metodo que dada una lista de numeros, procese los numeros que
	// Cumplan con el criterio del predicado
	public void NumerosProcesados(List<Integer> numeros, Predicate<Integer> criterio, Consumer<Integer> proceso) {
		for (Integer num : numeros) {
			if (criterio.test(num)) {
				proceso.accept(num);
			}
		}
	}
}

