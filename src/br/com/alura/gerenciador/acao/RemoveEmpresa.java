package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		System.out.println("removendo empresa");
		
		String paramAcao = request.getParameter("acao");
		String idString = paramAcao.substring(paramAcao.indexOf("id=")+3);
		Integer id = Integer.parseInt(idString);
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
