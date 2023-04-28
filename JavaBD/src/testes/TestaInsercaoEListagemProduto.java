package testes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mchange.v1.identicator.Identicator;

import Dao.ProdutoDao;
import moldes.ConnectionFactory;
import moldes.Produto;

public class TestaInsercaoEListagemProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("comoda","comoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			ProdutoDao produtoDao = new ProdutoDao(connection);
		    produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			
			
		
	}

}
}
