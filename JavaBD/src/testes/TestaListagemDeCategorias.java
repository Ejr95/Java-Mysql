package testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CategoriaDao;
import moldes.Categoria;
import moldes.ConnectionFactory;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperaConexao()){
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> listagemDeCategorias = categoriaDao.listar(); 
			listagemDeCategorias.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
	}
}
