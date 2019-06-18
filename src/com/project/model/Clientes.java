package com.project.model;

public class Clientes {



		private int idCliente;
		private String nombre;
		private String domicilio;
		private String telefono;
		
		public Clientes() {
			
		}
		
		public Clientes(int idCliente, String nombre, String domicilio, String telefono) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
		
		
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDomicilio() {
			return domicilio;
		}
		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		
		
		
}
