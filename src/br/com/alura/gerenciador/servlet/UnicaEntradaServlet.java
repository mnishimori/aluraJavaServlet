package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");

		String nomeRecurso = "";
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			nomeRecurso = listaEmpresas.executa(request, response);
			
		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			nomeRecurso = removeEmpresa.executa(request, response);
			
		} if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			nomeRecurso = mostraEmpresa.executa(request, response);
			
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			nomeRecurso = alteraEmpresa.executa(request, response);
			
		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa alteraEmpresa = new NovaEmpresa();
			nomeRecurso = alteraEmpresa.executa(request, response);
			
		}
		
		String[] tipoEndereco = nomeRecurso.split(":");
		
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}

}
