package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConxeao = new ConnectionFactory();
		Connection connection = criaConxeao.recuperaConexao();

		System.out.println("Fechando Conexão");
		connection.close();
	}

}
