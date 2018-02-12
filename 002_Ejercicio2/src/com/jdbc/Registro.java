package com.jdbc;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/users")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Registro() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ejercicio2");
            
            
            /*Insertar*/
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO ejercicio2 (correo, fechareg, producto, unidades) VALUES (?,?,?,?)");
			ps1.setString(1, "websol018@gmail.com");
			ps1.setString(2, "2018-01-17");
			ps1.setString(3, "Camisas");
			ps1.setInt(4, 5);
			ps1.executeUpdate();
			System.out.println("Fila Insertada");
			
			
			/*Leer*/
            out.println("<table border=\"1\">");
            out.println("<th>Correo</th>" + "<th>Fecha de registro</th>" + "<th>Producto</th>" + "<th>Unidades</th>");
            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("correo") + "</td>");
                out.println("<td>" + rs.getString("fechareg") + "</td>");
                out.println("<td>" + rs.getString("producto") + "</td>");
                out.println("<td>" + rs.getInt("unidades") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            /*ACTUALIZAR*/
//            String prod = "Marisco";
//            PreparedStatement ps2 = con.prepareStatement("UPDATE ejercicio2 SET mail=?, fechareg=?, producto=?, unidades=? WHERE producto=" + prod + ";");
//            ps2.setString(1, "juanito@gmail.com");
//			ps2.setString(2, "2018-01-03");
//			ps2.setString(3, "pantalones");
//			ps2.setInt(4, 8);
//			ps2.executeUpdate();
//            System.out.println("ACTUALIZADO");
            
            /*ELIMINAR*/
//          int uni = 20;
//        	int del = st.executeUpdate("DELETE FROM ejercicio2 WHERE unidades=" + uni + ";");
//            System.out.println("ELIMINADO");
        }
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
        	}
        catch (SQLException e) {
            e.printStackTrace();
            }
        finally {
            if(out != null)
                out.close();
            }
       
        }
	}
