package com.basico.mongodb.model;

public class Clima {
	private String id;
	private String poblacion;
	private String litros;
	private String fecha;
	private String tempmax;
	private String tempmin;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getLitros() {
		return litros;
	}
	public void setLitros(String litros) {
		this.litros = litros;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTempmax() {
		return tempmax;
	}
	public void setTempmax(String tempmax) {
		this.tempmax = tempmax;
	}
	public String getTempmin() {
		return tempmin;
	}
	public void setTempmin(String tempmin) {
		this.tempmin = tempmin;
	}
	
	
}