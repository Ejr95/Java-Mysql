package aluraJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperaConexao();
		
		Statement stm = connection.createStatement();
		
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES('MOUSE', 'MOUSE COM FIO')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);		
			System.out.println("ID = "+id);
		}
		
		
	}

}
