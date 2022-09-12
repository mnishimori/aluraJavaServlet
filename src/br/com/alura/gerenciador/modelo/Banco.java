package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();	
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return lista;
	}
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void removerEmpresa(Integer id) {
		
		Empresa empresa2 = lista.stream()
				.filter(e -> Integer.valueOf(e.getId()).equals(id))
				.findFirst().get();
		
		lista.remove(empresa2);
		
		/*
		 * Iterator<Empresa> it = lista.iterator(); while (it.hasNext()) { Empresa
		 * empresa = it.next();
		 * 
		 * if (empresa.getId() == id) { it.remove(); } }
		 */
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		
		return lista.stream()
				.filter(e -> Integer.valueOf(e.getId()).equals(id))
				.findFirst()
				.orElse(null);
	}

	public Usuario existeUsuario(String login, String senha) {
		
		return listaUsuarios.stream()
				.filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
				.findFirst()
				.orElse(null);
	}

}
