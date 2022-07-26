package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConxeao = new ConnectionFactory();
		Connection connection = criaConxeao.recuperaConexao();

		System.out.println("Fechando Conexão");
		connection.close();
	}

}
