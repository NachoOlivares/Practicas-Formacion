package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PruebaCasos {
	

	private List<PruebaCasos> data;

	public PruebaCasos(List<PruebaCasos> data) {
		super();
		this.data = data;
	}

	public List<PruebaCasos> getData() {
		return data;
	}

	public void setData(List<PruebaCasos> data) {
		this.data = data;
	}
	
	


}
