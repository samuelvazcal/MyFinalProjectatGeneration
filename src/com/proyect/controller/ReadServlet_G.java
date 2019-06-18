package com.proyect.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet_G")
public class ReadServlet_G extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		//salida.append("txp");
		
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
		String sentenciaSql = props.getProperty("sentenciaSQL2");
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;//
		
		try {
			//Se instancia el driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//Se abre la conexion a la base de datos
			conn = DriverManager.getConnection(urlServidor,usuario,password);
			//Crea la consola para la conexion a MySQL (sE CREA LA CONSOLA DE COMANDOS QUE 
			//APUNTA A ESA CONEXION)
			stmnt = conn.createStatement(); 
			//rs es mi terminal
			rs = stmnt.executeQuery(sentenciaSql);
			//salida.append("<table><tr><th>ID PRODUCTO</th><th>NOMBRE</th><th>mts. x cajas</th><th>pzs. x cajas</th><th>peso x caja</th><th>cajas x pallet</th><th>precio x m</th></tr></table>");
			while(rs.next())//la flechita puntero de la tabla en mysql
			{
				salida.append("<table>");
				salida.append("<tr>");
				salida.append("<th>Id_Producto</th>");
				salida.append("<th>Nombre</th>");
				salida.append("<th>mts x caja</th>");
				salida.append("<th>pzs x caja</th>");
				salida.append("<th>peso(kg.) x caja</th>");
				salida.append("<th>cajas x pallet</th>");
				salida.append("<th>precio x metro</th>");
				salida.append("</tr>");
				salida.append("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getDouble(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getDouble(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getDouble(7)+"</td></tr>");
				salida.append("</table>");
				
//				response.setContentType("text/html");
//				salida.append("<table>");
//				//>*salida.append("<tr><th>ID PRODUCTO</th><th>NOMBRE</th><th>mts. x cajas</th><th>pzs. x cajas</th><th>peso x caja</th><th>cajas x pallet</th><th>precio x m</th></tr>");
//				salida.append("<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td></tr>");
//				salida.append("</table>");			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			//cerrramos la conexion y colocamos los objetos a disposicion del garbage collector
			try {
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		salida.close();
			
		
	}

}
