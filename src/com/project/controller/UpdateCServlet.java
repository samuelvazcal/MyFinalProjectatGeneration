package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Clientes;

@WebServlet("/UpdateCServlet")
public class UpdateCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		//salida.append("Z");
		Properties props = new Properties();
		String nombreArchivo = "configC.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo);
		if(inputStream!=null)//si encontro el archivo, carga el archivo en el props
		{
			props.load(inputStream);
		}
		else
		{
			throw new FileNotFoundException("Property file'"+nombreArchivo+"'no se encontro el classpath");
		}
		String urlServidor = props.getProperty("urlServidor");
		String usuario = props.getProperty("usuario");
		String password = props.getProperty("password");
		String sentenciaSql = props.getProperty("sentenciaSQL4");
		
		int nRegistros = 0;
		
		Clientes miCliente = new Clientes();
		miCliente.setIdCliente(Integer.parseInt(request.getParameter("txtCliente")));
		miCliente.setNombre(request.getParameter("txtNombre"));
		miCliente.setDomicilio(request.getParameter("txtDomicilio"));
		miCliente.setTelefono(request.getParameter("txtTelefono"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection miConexion = DriverManager.getConnection(urlServidor, usuario, password);
			PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaSql);
			//sentenciaSQL4=UPDATE productos SET nombre=?, mts_Caja=?, pzs_Caja=?, peso_Caja=?, cajas_Pallet=?, precio_metro=? WHERE id_Producto=?
			
			miPreparedStatement.setString(1, miCliente.getNombre());
			miPreparedStatement.setString(2, miCliente.getDomicilio());
			miPreparedStatement.setString(3, miCliente.getTelefono());
			miPreparedStatement.setInt(4, miCliente.getIdCliente());
	
			nRegistros=miPreparedStatement.executeUpdate();
			
			if(nRegistros>0) {
				salida.append("REGISTRO EXITOSO");
				salida.append("<table>");
				salida.append("<tr>");
				salida.append("<th>Id_Producto</th>");
				salida.append("<th>Nombre</th>");
				salida.append("<th>Domicilio</th>");
				salida.append("<th>Telefono</th>");
				salida.append("</tr>");
				salida.append("<tr><td>"+miCliente.getIdCliente()+"</td><td>"+miCliente.getNombre()+"</td><td>"+miCliente.getDomicilio()+"</td><td>"+miCliente.getTelefono()+"</td></tr>");
				salida.append("</table>");
			}else {
				salida.append("NO SE HA REALIZADO LA MODIFICACION");
			}
		}catch(Exception e) {
			System.out.println(":(");
			e.printStackTrace();
		}
	}

}
