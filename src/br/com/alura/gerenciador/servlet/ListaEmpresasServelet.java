package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServelet
 */
@WebServlet("/listaEmpresasServlet")
public class ListaEmpresasServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		PrintWriter writer = response.getWriter();
		writer.println("<html><body>Lista de empresas");
		for (Empresa empresa : empresas) {
			writer.println("<p>" + empresa.getNome() + "</p>");
		}
		writer.println("</body></html>");
	}

}
