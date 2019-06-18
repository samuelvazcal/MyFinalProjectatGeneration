package com.proyect.controller;

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

import com.proyect.model.Producto;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		//salida.append("!");
		
		Properties props = new Properties();
		String nombreArchivo = "configP.properties";
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
		
		Producto miProducto = new Producto();
		miProducto.setIdProducto(request.getParameter("txtIdProducto"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection miConexion = DriverManager.getConnection(urlServidor, usuario, password);
			PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaSql);
			miPreparedStatement.setString(1, miProducto.getIdProducto());
			nRegistro = miPreparedStatement.executeUpdate();
			if(nRegistro>0) {
				salida.append("Registro "+miProducto.getIdProducto()+" borrado exitosamente");
			}else {
				salida.append("No se pudo eliminar el registro");
			}
		}catch(Exception e) {
			System.out.println("It's not working! :(");
			e.printStackTrace();
		}
	}
}
