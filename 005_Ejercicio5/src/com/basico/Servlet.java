package com.basico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int unidades = Integer.parseInt(request.getParameter("unidades"));
		String lugar = request.getParameter("lugar");
		Calculo c = new Calculo(nombre,unidades,lugar);
		request.setAttribute("calculo",c);
		request.getRequestDispatcher("/final.jsp").forward(request, response);
		}
	}
