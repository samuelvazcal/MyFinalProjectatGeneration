package com.proyect.model;

public class Producto {
	
	private String idProducto;
	private String nombre;
	private double mtsCaja;
	private int pzsCaja;
	private double pesoCaja;
	private int cajasPallet;
	private double precioMetro;
	
	public Producto() {
		
	}
	
	public Producto(String idProducto, String nombre, double mtsCaja, int pzsCaja, double pesoCaja, int cajasPallet,
			double precioMetro) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.mtsCaja = mtsCaja;
		this.pzsCaja = pzsCaja;
		this.pesoCaja = pesoCaja;
		this.cajasPallet = cajasPallet;
		this.precioMetro = precioMetro;
	}
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getMtsCaja() {
		return mtsCaja;
	}
	public void setMtsCaja(double mtsCaja) {
		this.mtsCaja = mtsCaja;
	}
	public int getPzsCaja() {
		return pzsCaja;
	}
	public void setPzsCaja(int pzsCaja) {
		this.pzsCaja = pzsCaja;
	}
	public double getPesoCaja() {
		return pesoCaja;
	}
	public void setPesoCaja(double pesoCaja) {
		this.pesoCaja = pesoCaja;
	}
	public int getCajasPallet() {
		return cajasPallet;
	}
	public void setCajasPallet(int cajasPallet) {
		this.cajasPallet = cajasPallet;
	}
	public double getPrecioMetro() {
		return precioMetro;
	}
	public void setPrecioMetro(double precioMetro) {
		this.precioMetro = precioMetro;
	}
	
	
	
}
