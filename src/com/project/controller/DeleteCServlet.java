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

@WebServlet("/DeleteCServlet")
public class DeleteCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		//salida.append("something");
		
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
		String sentenciaSql = props.getProperty("sentenciaSQL5");
		//sentenciaSQL5=DELETE FROM productos WHERE id_Producto=?
		int nRegistro = 0;
		
		Clientes miCliente = new Clientes();
		miCliente.setIdCliente(Integer.parseInt(request.getParameter("txtIdCliente")));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection miConexion = DriverManager.getConnection(urlServidor, usuario, password);
			PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaSql);
			miPreparedStatement.setInt(1, miCliente.getIdCliente());
			nRegistro = miPreparedStatement.executeUpdate();
			if(nRegistro>0) {
				salida.append("Registro "+miCliente.getIdCliente()+" borrado exitosamente");
			}else {
				salida.append("No se pudo eliminar el registro");
			}
		}catch(Exception e) {
			System.out.println("It's not working! :(");
			e.printStackTrace();
		}
	}

}
