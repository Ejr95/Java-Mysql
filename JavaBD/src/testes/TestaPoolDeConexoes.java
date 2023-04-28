package testes;

import java.sql.SQLException;
import java.util.Iterator;

import moldes.ConnectionFactory;

public class TestaPoolDeConexoes {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i=0; i<20; i++) {
			
			connectionFactory.recuperaConexao();
		}
	}
}
