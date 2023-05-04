package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Dao.CategoriaDao;
import moldes.Categoria;
import moldes.ConnectionFactory;

public class CategoriaController {
	private CategoriaDao categoriaDao;
	
	public CategoriaController() {
		Connection connection = 
				new ConnectionFactory().recuperaConexao();
		this.categoriaDao = new CategoriaDao(connection);
		
	}
	
	public List<Categoria> listar() {
		
		return this.categoriaDao.listar();
	}
}
