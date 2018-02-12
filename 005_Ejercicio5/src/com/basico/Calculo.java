package com.basico;

public class Calculo {

	private String nombre;
	private int unidades;
	private String lugar;
	private float precio = 15.95f;
	private float iva = 1.21f;
	private float total;
	
	public Calculo() {};
	
	public Calculo(String nombre, int unidades, String lugar) {
		super();
		this.nombre = nombre;
		this.unidades = unidades;
		this.lugar = lugar;
		}
	public float getTotal() {
		return (precio*unidades)*iva;
		}
	public void setTotal(float total) {
		this.total = total;
		}
	public String getNombre() {
		return nombre;
		}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		}
	public int getUnidades() {
		return unidades;
		}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
		}
	public String getLugar() {
		return lugar;
		}
	public void setLugar(String lugar) {
		this.lugar = lugar;
		}
	public float getPrecio() {
		return precio;
		}
	public void setPrecio(float precio) {
		this.precio = precio;
		}
	public float getIva() {
		return iva;
		}
	public void setIva(float iva) {
		this.iva = iva;
		}
	}
