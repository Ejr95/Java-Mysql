package aluraJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >2 ");
		stm.execute();
		
		int linhasModificadas =  stm.getUpdateCount();
		System.out.println("linhas modificadas : "+ linhasModificadas);
	}
}
