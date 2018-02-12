package com.basico.mongodb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basico.mongodb.dao.ClimaDAO;
import com.basico.mongodb.model.Clima;
import com.mongodb.MongoClient;

@WebServlet("/addClima")
public class AddClimaServlet extends HttpServlet {
	private static final long serialVersionUID = -7060758261496829905L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String poblacion = request.getParameter("poblacion");
		String litros = request.getParameter("litros");
		String fecha = request.getParameter("fecha");
		String tempmax = request.getParameter("tempmax");
		String tempmin = request.getParameter("tempmin");
		if (((poblacion == null)||(poblacion.equals("")))
				|| ((litros == null)||(litros.equals("")))
				|| (fecha == null||(fecha.equals("")))
				|| ((tempmax == null)||(tempmax.equals("")))
				|| ((tempmin == null)||(tempmin.equals("")))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/climas.jsp");
			rd.forward(request, response);
			}
		else {
			Clima c = new Clima();
			c.setPoblacion(poblacion);
			c.setLitros(litros);
			c.setFecha(fecha);
			c.setTempmax(tempmax);
			c.setTempmin(tempmin);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			ClimaDAO climaDAO = new ClimaDAO(mongo);
			climaDAO.createClima(c);
			System.out.println("Clima añadido satisfacotriamente con id="+c.getId());
			request.setAttribute("correcto", "Clima Añadido Satisfactoriamente");
			List<Clima> climas = climaDAO.readAllClima();
			request.setAttribute("climas", climas);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/climas.jsp");
			rd.forward(request, response);
		}
	}

}