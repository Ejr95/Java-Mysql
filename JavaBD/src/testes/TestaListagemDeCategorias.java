package testes;
import Dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CategoriaDao;
import Dao.ProdutoDao;
import moldes.Categoria;
import moldes.ConnectionFactory;
import moldes.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperaConexao()){
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> listagemDeCategorias = categoriaDao.listar(); 
			listagemDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				try {
					for (Produto produto : new ProdutoDao(connection).buscar(ct)) {
						System.out.println(ct.getNome() + "---"+ produto.getNome() );
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}
}
