package br.com.alura.jdbc;

import java.sql.SQLException;
import java.util.Iterator;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 1; i < 20; i++) {
			connectionFactory.recuperaConexao();
			System.out.println("Conexão de numero " + i);
		}
		
	}

}
