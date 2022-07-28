package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperaConexao()) {

			connection.setAutoCommit(false); // Controle da transacao ao inserir no banco de dados

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO(nome , descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionaVariavel("SmartTV", "45 Polegadas", stm);
				adicionaVariavel("Radio", "Radio de Baterias", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK Execultado");
				connection.rollback();
			}
		}
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {

		// mudar os parametros ?,?
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {

				Integer id = rst.getInt(1);
				System.out.println("O id criado foi= " + id);
			}
		}
	}
}
