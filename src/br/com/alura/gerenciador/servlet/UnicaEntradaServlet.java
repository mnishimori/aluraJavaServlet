package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			String paramAcao = request.getParameter("acao");
			
			String classe = "br.com.alura.gerenciador.acao." + paramAcao;
			
			Acao acao = (Acao) Class.forName(classe).newInstance();
			String nomeRecurso = acao.executa(request, response);
			
			String[] tipoEndereco = nomeRecurso.split(":");
			
			if (tipoEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEndereco[1]);
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
}