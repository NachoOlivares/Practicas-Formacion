package model;
import com.google.gson.annotations.SerializedName;

public class Casos {

		@SerializedName("municipio_distrito")
		private String municipio;

		@SerializedName("tasa_incidencia_acumulada_ultimos_14dias")
		private double incidencia;

		@SerializedName("casos_confirmados_totales")
		private long casostotales;
		
		@SerializedName ("fecha_informe")
		private String fecha;

		public Casos(String municipio, double incidencia, long casostotales, String fecha) {
			super();
			this.municipio = municipio;
			this.incidencia = incidencia;
			this.casostotales = casostotales;
			this.fecha = fecha;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public double getIncidencia() {
			return incidencia;
		}

		public void setIncidencia(double incidencia) {
			this.incidencia = incidencia;
		}

		public long getCasostotales() {
			return casostotales;
		}

		public void setCasostotales(long casostotales) {
			this.casostotales = casostotales;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		
		

		
		
		// @SerializedName(value="data", alternate="fecha_informe")
		// private String fecha;
		
	}

	// @SerializedName(value="data", alternate="fecha_informe")
	// private String fecha;
	
