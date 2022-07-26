package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");

		stm.setInt(1, 2);

		stm.execute();

		int linhasModificadas = stm.getUpdateCount();

		System.out.println("Quantidades de linhas que foram modificadas " + linhasModificadas);
	}

}
