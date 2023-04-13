package aluraJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection recuperaConexao()  throws SQLException  {
		return DriverManager.
				getConnection("jdbc:mysql://localhost/javajdbc?useTimezone=true&serverTimezone=UTC" , "root" , "1234");
	}
}
