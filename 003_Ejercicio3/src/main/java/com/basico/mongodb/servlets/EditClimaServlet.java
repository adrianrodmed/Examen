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

@WebServlet("/editClima")
public class EditClimaServlet extends HttpServlet {
	private static final long serialVersionUID = -6554920927964049383L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || "".equals(id)) {
			throw new ServletException("Falta id para editar");
		}
		System.out.println("Clima editado con id=" + id);
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		ClimaDAO climaDAO = new ClimaDAO(mongo);
		Clima c = new Clima();
		c.setId(id);
		c = climaDAO.readClima(c);
		request.setAttribute("clima", c);
		List<Clima> climas = climaDAO.readAllClima();
		request.setAttribute("climas", climas);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/climas.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // keep it non-editable in UI
		if (id == null || "".equals(id)) {
			throw new ServletException("Falta id para editar");
		}

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
			request.setAttribute("error", "Los datos no pueden estar vacíos");
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			ClimaDAO climaDAO = new ClimaDAO(mongo);
			Clima c = new Clima();
			c.setPoblacion(poblacion);
			c.setLitros(litros);
			c.setFecha(fecha);
			c.setTempmax(tempmax);
			c.setTempmin(tempmin);
			request.setAttribute("clima", c);
			List<Clima> climas = climaDAO.readAllClima();
			request.setAttribute("climas", climas);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/climas.jsp");
			rd.forward(request, response);
		} else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			ClimaDAO climaDAO = new ClimaDAO(mongo);
			Clima c = new Clima();
			c.setPoblacion(poblacion);
			c.setLitros(litros);
			c.setFecha(fecha);
			c.setTempmax(tempmax);
			c.setTempmin(tempmin);
			climaDAO.updateClima(c);
			System.out.println("Clima editado satisfactoriamente con id=" + id);
			request.setAttribute("correcto", "Clima editado satisfactoriamente");
			List<Clima> climas = climaDAO.readAllClima();
			request.setAttribute("climas", climas);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/climas.jsp");
			rd.forward(request, response);
		}
	}

}