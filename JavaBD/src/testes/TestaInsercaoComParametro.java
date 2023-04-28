package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import moldes.ConnectionFactory;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		
		try(Connection connection = cf.recuperaConexao()){
		connection.setAutoCommit(false);
		
		try {
	
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?, ?)",
			Statement.RETURN_GENERATED_KEYS);
			
			adicionarVariavel("SmartWatch", "mi band pro 7", stm);
			adicionarVariavel("SmartWatch", "huwawei lite sport 3", stm);
			
			connection.commit();
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		
		}
		
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1,nome);
		stm.setString(2,descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);		
			System.out.println("ID = "+id);
		}
	}
}
