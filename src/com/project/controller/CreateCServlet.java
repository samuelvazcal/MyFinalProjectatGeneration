package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.model.Clientes;

@WebServlet("/CreateCServlet")
public class CreateCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		//salida.append("^^/");
		
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
		
		Clientes miCliente = new Clientes();
		miCliente.setIdCliente(Integer.parseInt(request.getParameter("txtCliente")));
		miCliente.setNombre(request.getParameter("txtNombre"));
		miCliente.setDomicilio(request.getParameter("txtDomicilio"));
		miCliente.setTelefono(request.getParameter("txtTelefono"));
		
		String urlServidor = props.getProperty("urlServidor");
		String usuario = props.getProperty("usuario");
		String password = props.getProperty("password");
		String sentenciaSql = props.getProperty("sentenciaSQL3");
		//sentenciaSQL3=INSERT INTO productos values (0,?,?,?,?,?,?)
		Connection conn=null;
		PreparedStatement pstmnt = null;
		int nRegistros = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(urlServidor,usuario,password);
			pstmnt = conn.prepareStatement(sentenciaSql);
			//pstmnt.executeUpdate(sentenciaSql);
			
			pstmnt.setInt(1, miCliente.getIdCliente());
			pstmnt.setString(2, miCliente.getNombre());
			pstmnt.setString(3, miCliente.getDomicilio());
			pstmnt.setString(4, miCliente.getTelefono());
			
			nRegistros=pstmnt.executeUpdate();
			if(nRegistros>0)
			{
				response.getWriter().append("Registro creado satisfactoriamente");
				salida.append("<br>");
				salida.append("El JSON generado para el registro es: ");
			}
			else
			{
				response.getWriter().append("No se creo registro");
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				pstmnt.close();
				conn.close();
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			response.setContentType("application/json");
			Gson objGson = new Gson();
			String miJson;
			miJson = objGson.toJson(miCliente);
			response.getWriter().append(miJson);
	}

}
