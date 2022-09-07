package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("mostrando empresa");
		
		String param = request.getParameter("acao");
		String idString = param.substring(param.indexOf("id")+3);
		Integer id = Integer.parseInt(idString);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
