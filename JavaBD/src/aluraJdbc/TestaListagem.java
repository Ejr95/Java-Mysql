package aluraJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection conection = cf.recuperaConexao();

		PreparedStatement stm = conection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
		
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			System.out.println("============================");
			Integer id = rst.getInt("ID");
			System.out.println("ID = "+id);
			String nome = rst.getString("NOME");
			System.out.println("Nome = "+nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(" Descricao = "+descricao);
			System.out.println("============================");
		}
	
		conection.close();
		
	}

}
