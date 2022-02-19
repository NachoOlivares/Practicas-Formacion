package locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import model.Data;

public class CasosLocator {
	static final String RUTA = "https://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/download/covid19_tia_muni_y_distritos_s.json";

	public static Data getCasos() {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(RUTA)).GET().build();
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
		try {
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String cuerpoRespuesta = response.body();
			Gson gson = new Gson();
			return gson.fromJson(cuerpoRespuesta, Data.class);
			
		} catch (IOException | InterruptedException e) {
			return null;
		}

	}
}
