package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nNovo Produto Cadastrado com sucesso");
	}

	@Override
	public void atualizar(Produto produto) {
		var buscarProduto = buscarNaCollection(produto.getId());

		if (buscarProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscarProduto), produto);
			System.out.printf("\nO Produto  de id:: %d foi atualizado com sucesso!%n", produto.getId());
		} else {
			System.out.printf("\nO Produto  de id:: %d não foi encontradoa no sistema!%n", produto.getId());
		}

	}

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.visualizar();

		} else {
			System.out.printf("\nO Produto  de id: %d não foi encontrado no sistema", id);
		}

	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.printf("\nO Produto  de id: %d foi deletado do sistema com sucesso!%n", id);
			}
		} else {
			System.out.printf("\nO Produto  de id: %d não foi encontrado no sistema!%n", id);
		}
	}

	public int gerarId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}

		return null;
	}
}
