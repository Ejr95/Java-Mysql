package aluraJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf= new ConnectionFactory();
		Connection conection = cf.recuperaConexao();
		
		
		System.out.println("Fechando conexão");
		conection.close();
		
	}

}
