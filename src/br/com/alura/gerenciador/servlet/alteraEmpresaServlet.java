package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class alteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class alteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
        String nomeEmpresa = request.getParameter("nome");
        String paramDataAbertura = request.getParameter("data");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAbertura = null;
        try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new IOException(e); 
		}
        
        System.out.println("Alterando empresa " + id);
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPorId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        response.sendRedirect("listaEmpresas");
	}
}
