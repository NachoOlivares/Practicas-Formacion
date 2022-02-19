package locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisLocator {
	static final String RUTA = "https://restcountries.com/v2/all";

	public static Stream<Pais> getPais() {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(RUTA)).GET().build();
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String cuerpoRespuesta = response.body();
			Gson gson = new Gson();
					//Este return devuelve la lista ya adaptada al modelo pais.
					//En el modelo hay que adaptar el nombre de las propiedades del json a las nuestras
			return Arrays.stream(gson.fromJson(cuerpoRespuesta, Pais[].class)).parallel();
		} catch (IOException | InterruptedException e) {
			return Stream.empty();
		}

	}

}
