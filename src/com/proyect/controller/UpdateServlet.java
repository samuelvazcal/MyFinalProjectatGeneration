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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		//salida.append("OK!");
		
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
		String sentenciaSql = props.getProperty("sentenciaSQL4");
		
		int nRegistros = 0;
		
		Producto miProducto = new Producto();
		miProducto.setIdProducto(request.getParameter("txtIdProducto"));
		miProducto.setNombre(request.getParameter("txtNombre"));
		miProducto.setMtsCaja(Double.parseDouble(request.getParameter("txtMtsxCaja")));
		miProducto.setPzsCaja(Integer.parseInt(request.getParameter("txtPzsxCaja")));
		miProducto.setPesoCaja(Double.parseDouble(request.getParameter("txtPesoxCaja")));
		miProducto.setCajasPallet(Integer.parseInt(request.getParameter("txtCajasxPallet")));
		miProducto.setPrecioMetro(Double.parseDouble(request.getParameter("txtPrecioxMetro")));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection miConexion = DriverManager.getConnection(urlServidor, usuario, password);
			PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaSql);
			//sentenciaSQL4=UPDATE productos SET nombre=?, mts_Caja=?, pzs_Caja=?, peso_Caja=?, cajas_Pallet=?, precio_metro=? WHERE id_Producto=?
			
			miPreparedStatement.setString(1, miProducto.getNombre());
			miPreparedStatement.setDouble(2, miProducto.getMtsCaja());
			miPreparedStatement.setInt(3, miProducto.getPzsCaja());
			miPreparedStatement.setDouble(4, miProducto.getPesoCaja());
			miPreparedStatement.setInt(5, miProducto.getCajasPallet());
			miPreparedStatement.setDouble(6, miProducto.getPrecioMetro());
			miPreparedStatement.setString(7, miProducto.getIdProducto());
			
			nRegistros=miPreparedStatement.executeUpdate();
			
			if(nRegistros>0) {
				salida.append("REGISTRO EXITOSO");
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
				salida.append("<tr><td>"+miProducto.getIdProducto()+"</td><td>"+miProducto.getNombre()+"</td><td>"+miProducto.getMtsCaja()+"</td><td>"+miProducto.getPzsCaja()+"</td><td>"+miProducto.getPesoCaja()+"</td><td>"+miProducto.getCajasPallet()+"</td><td>"+miProducto.getPrecioMetro()+"</td></tr>");
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
