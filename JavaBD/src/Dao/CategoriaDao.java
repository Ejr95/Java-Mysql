package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import moldes.Categoria;

public class CategoriaDao {
	private Connection connection;
	
	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}
	
	public  List<Categoria> listar() throws SQLException{
		List<Categoria>categorias = new ArrayList<>();
		String sql = "SELECT ID,NOME FROM CATEGORIA";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getNString(2),rst.getInt(1));
					
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}
	
}
