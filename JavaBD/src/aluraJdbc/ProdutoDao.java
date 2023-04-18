package aluraJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarProdutor(Produto produto) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			String sql = ("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES(?,?)");
			
			try(PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS )  ){
			
				pstm.setString(1,produto.getNome());
				pstm.setString(2,produto.getDescricao());
				pstm.execute();
				
				try(ResultSet rts = pstm.getGeneratedKeys()  ){
					while(rts.next()) {
						produto.setId(rts.getInt(1));
						System.out.println("ID Gerado = "+produto.getId());
					}
				}
			}
		}
		
	}
	}
	
	
	

