package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda" , "Comoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			
			List<Produto> listaDeProduto = produtoDao.listar();
			listaDeProduto.stream().forEach(lp -> System.out.println(lp));
		}
	}

}
