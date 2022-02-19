package view;

import service.CasosService;

public class CasosView {

	public static void main(String[] args) {

		var app = new CasosService();
		
		java.util.List<String> municipios = app.Municipios();
		for (String m : municipios) {
			System.out.println(m);
		}
		
		long casosAcumulados = app.CasosAcumulados("Tielmes");
			System.out.println(casosAcumulados);
		
		double IncidenciaMedia = app.IncidenciaMedia();
		System.out.println("\nMedia de incidencia: "+IncidenciaMedia);
		
		long CasosTotales = app.CasosTotales();
		System.out.println("\nNumero de casos en total: "+CasosTotales);
		
	}

}
