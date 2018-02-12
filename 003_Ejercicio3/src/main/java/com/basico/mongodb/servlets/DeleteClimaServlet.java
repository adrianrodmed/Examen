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

@WebServlet("/deleteClima")
public class DeleteClimaServlet extends HttpServlet {
	private static final long serialVersionUID = 6798036766148281767L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || "".equals(id)) {
			throw new ServletException("Falta id para eliminar");
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		ClimaDAO climaDAO = new ClimaDAO(mongo);
		Clima c = new Clima();
		c.setId(id);
		climaDAO.deleteClima(c);
		System.out.println("Clima eliminado satisfactoriamente con id=" + id);
		request.setAttribute("correcto", "Clima eliminado satisfactoriamente");
		List<Clima> climas = climaDAO.readAllClima();
		request.setAttribute("climas", climas);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/climas.jsp");
		rd.forward(request, response);
	}

}