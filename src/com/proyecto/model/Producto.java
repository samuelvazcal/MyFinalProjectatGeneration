package com.proyecto.model;

public class Producto {

	private String codigo;
	private String nombre;
	private int nocajas;
	private int cajaxtarima;
	private double peso;
	
	public Producto() {
		
	}
	
	public Producto(String codigo, String nombre, int nocajas, int cajaxtarima, double peso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nocajas = nocajas;
		this.cajaxtarima = cajaxtarima;
		this.peso = peso;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNocajas() {
		return nocajas;
	}
	public void setNocajas(int nocajas) {
		this.nocajas = nocajas;
	}
	public int getCajaxtarima() {
		return cajaxtarima;
	}
	public void setCajaxtarima(int cajaxtarima) {
		this.cajaxtarima = cajaxtarima;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
