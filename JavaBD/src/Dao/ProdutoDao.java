package Dao;
import moldes.*;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import moldes.Categoria;
import moldes.ConnectionFactory;
import moldes.Produto;

public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
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
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.execute();
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1),rst.getString(2),rst.getString(3));
					
					produtos.add(produto);
					
				}
			}
			
			
		}
		return produtos;
		
	
	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
	List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setInt(1, ct.getId());
			stm.execute();
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1),rst.getString(2),rst.getString(3));
					
					produtos.add(produto);
					
				}
			}
			
			
		}
		return produtos;
	}
	
	}
	
	
	

