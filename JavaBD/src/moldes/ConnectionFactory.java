package moldes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource ;
	
	public ConnectionFactory () {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/javajdbc?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("1234");
		comboPooledDataSource.setMaxPoolSize(15);
		this.dataSource = comboPooledDataSource;
		
		
	}
	
	
	
	public Connection recuperaConexao()  throws SQLException  {
		return this.dataSource.getConnection();
	}
}
