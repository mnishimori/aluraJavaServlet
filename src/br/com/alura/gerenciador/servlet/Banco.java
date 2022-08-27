package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();	

	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return lista;
	}
	
	static {
	  Empresa empresa = new Empresa();
	  empresa.setNome("Alura");
	  Empresa empresa2 = new Empresa();
	  empresa2.setNome("Caelum");
	  Banco.lista.add(empresa);
	  Banco.lista.add(empresa2);
	}

}
