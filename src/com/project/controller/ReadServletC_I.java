package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Clientes;

@WebServlet("/ReadServletC_I")
public class ReadServletC_I extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		
		salida.append("abnb");

		int idClienteBuscado = Integer.parseInt(request.getParameter("txtcustomer"));
		
		System.out.println("idClienteBuscado es: "+idClienteBuscado);
		
		int idcliente=0;
		String nombre="";
		String domicilio="";
		String telefono="";
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
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
		String sentenciaSql = props.getProperty("sentenciaSQL");
		String s2 = sentenciaSql+idClienteBuscado;
		System.out.println("!!!!!"+s2);
		Clientes miCliente = new Clientes();
		miCliente.setIdCliente(Integer.parseInt(request.getParameter("txtcustomer")));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(urlServidor,usuario,password);
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(s2);
			
			rs.next();

			idcliente = rs.getInt(1);
			nombre = rs.getString(2);
			domicilio = rs.getString(3);
			telefono = rs.getString(4);
			
			response.setContentType("text/html");
			salida.append("<table>");
			salida.append("<tr><td>ID PRODUCTO</td><td>NOMBRE</td><td>DOMICILIO</td><td>TELEFONO</td></tr>");
			salida.append("<tr><td>"+idcliente+"</td>"+"<td>"+nombre+"</td>"+"<td>"+domicilio+"</td>"+"<td>"+telefono+"</td></tr>");
			salida.append("</table>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
