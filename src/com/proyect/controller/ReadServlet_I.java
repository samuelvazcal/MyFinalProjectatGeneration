package com.proyect.controller;

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

import com.proyect.model.Producto;

@WebServlet("/ReadServlet_I")
public class ReadServlet_I extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		//response.setContentType("application/json");
		//salida.append("abnb");
		
		String idProductoBuscado = request.getParameter("txtIdProducto");
		
		String codigo="";
		String nombre="";
		double mtscaja=0.0;
		int pzscaja=0;
		double pesocaja=0.0;
		int cajaspallet=0;
		double preciometro=0.0;
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
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
		String sentenciaSql = props.getProperty("sentenciaSQL");
		String s2 = sentenciaSql+"'"+idProductoBuscado+"'";
		System.out.println("!!!!!"+s2);
		Producto miProducto = new Producto();
		miProducto.setIdProducto(request.getParameter("txtCodigo"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(urlServidor,usuario,password);
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(s2);
			
			rs.next();

			codigo = rs.getString(1);
			nombre = rs.getString(2);
			mtscaja = rs.getDouble(3);
			pzscaja = rs.getInt(4);
			pesocaja = rs.getDouble(5);
			cajaspallet = rs.getInt(6);
			preciometro = rs.getDouble(7);
			
			response.setContentType("text/html");
			//salida.append("{\"codigo\":\""+codigo+"\",\"nombre\":\""+nombre+"\",\"mtsxcajas\":"+mtscaja+",\"pzsxcajas\":"+pzscaja+",\"pesocaja\":"+pesocaja+",\"cajasxpallet\":"+cajaspallet+",\"precioxm\":"+preciometro+"}");
			salida.append("<table>");
			salida.append("<tr><th>ID PRODUCTO</th><th>NOMBRE</th><th>mts. x cajas</th><th>pzs. x cajas</th><th>peso x caja</th><th>cajas x pallet</th><th>precio x m</th></tr>");
			//salida.append("<tr><td>\""+codigo+"\"</td>"+"<td>\""+nombre+"\"</td></tr>");
			//salida.append("<tr><td>\""+codigo+"\"</td>"+"<td>\""+nombre+"\"</td>"+"<td>\""+mtscaja+"\"</td>"+"<td>\""+pzscaja+"\"</td>"+"<td>\""+pesocaja+"\"</td>"+"<td>\""+cajaspallet+"\"</td>"+"<td>\""+preciometro+"\"</td></tr>");
			salida.append("<tr><td>"+codigo+"</td>"+"<td>"+nombre+"</td>"+"<td>"+mtscaja+"</td>"+"<td>"+pzscaja+"</td>"+"<td>"+pesocaja+"</td>"+"<td>"+cajaspallet+"</td>"+"<td>"+preciometro+"</td></tr>");
			salida.append("</table>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
