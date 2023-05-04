package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Dao.ProdutoDao;
import moldes.ConnectionFactory;
import moldes.Produto;

public class ProdutoController {
	ProdutoDao produtoDao;
	
	public ProdutoController() {
		Connection connection =
				new ConnectionFactory().recuperaConexao();
		this.produtoDao = new ProdutoDao(connection);
	}
	
	public void deletar(Integer id) {
		this.produtoDao.deletar(id);
	}

	public void salvar(Produto produto) {
		this.produtoDao.salvar(produto);
	}

	public List<Produto> listar() {
		return this.produtoDao.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		this.produtoDao.alterar(nome,descricao,id);
	}
}
