package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Eletronicos;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Roupa;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);

	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {
		int opcao;

		criarProdutosTeste();
		

		while (true)

		{

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                SHOP3,14(Pi)                         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Deletar Produto                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("          Entre com a opção desejada:                ");
			System.out.println("                                                    ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 5");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nVem pra SHOP3,14 - Produtos que não quebram fácil é só aqui!!!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto\n");
				cadastrarProduto();
				keyPress();
				break;

			case 2:
				System.out.println("Listar todos os Produtos\n");
				listarProdutos();
				keyPress();
				break;

			case 3:
				System.out.println("Consultar dados do Produto pelo ID\n");
				procurarProdutoPorId();
				keyPress();
				break;

			case 4:
				System.out.println("Atualizar dados do Produto\n");
				atualizarProduto();
				keyPress();
				break;

			case 5:
				System.out.println("Apagar o Produto\n");
				deletarProduto();
				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: Joel");
			System.out.println("Joel Ramalho Filho - joelramalho.negociosonline@gmail.com");
			System.out.println("https://github.com/JoelRamalhoF");
			System.out.println("*********************************************************");
		
	}

	private static void criarProdutosTeste() {
		produtoController.cadastrar(new Eletronicos(produtoController.gerarId(), "Playstation 10", 1, 11500.00f, "Video Game"));
		produtoController.cadastrar(new Eletronicos(produtoController.gerarId(), "XBOX BOX DA NASA", 1, 25500.00f, "Video Game"));
		produtoController.cadastrar(new Roupa(produtoController.gerarId(), "Jaqueta Couro Marrom", 2, 359.00f, "Roupa de Inverno"));
		produtoController.cadastrar(new Roupa(produtoController.gerarId(), "Croped de Couro Preto", 2, 399.00f, "Roupa de Verão"));
	}

	private static void procurarProdutoPorId() {
		System.out.print("Digite o Id do produto desejado: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);
	}

	private static void atualizarProduto() {
		System.out.print("Digite o Id do produto desejado: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			String nome = produto.getNome();
			int categoria = produto.getCategoria();
			float preco = produto.getPreco();

			System.out.printf(
					"Nome atual: %s\nDigite o novo nome do Produto (Pressione ENTER para manter o valor atual): ", nome);
			String entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			System.out.printf("Preço atual: %.2f\nDigite o novo Preço (Pressione ENTER para manter o valor atual): ",
					preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

			switch (categoria) {
			case 1 -> {
				String game = ((Eletronicos) produto).getGame();
				
				System.out.printf(
						"O tipo do Eletronico atual é: %s\nDigite o novo Tipo do Eletrônico (Pressione ENTER para manter o valor atual): ",
						game);
				entrada = leia.nextLine();
				game = entrada.isEmpty() ? game : entrada;
				produtoController.atualizar(new Eletronicos(id, nome, categoria, preco, game));

			}

			case 2 -> {
				String tipoDeRoupa = ((Roupa) produto).gettipoDeRoupa();

				System.out.printf(
						"O tipo de Roupa Atual é: %s\nDigite o novo tipo de Roupa Verão ou Inverno (Pressione ENTER para manter o valor atual): ",
						tipoDeRoupa);
				entrada = leia.nextLine();
				tipoDeRoupa = entrada.isEmpty() ? tipoDeRoupa : entrada;
				produtoController.atualizar(new Roupa(id, nome, categoria, preco, tipoDeRoupa));
			}
			default -> System.out.println("A Categoria de produto digitada não é valida!");
			}

		} else {
			System.out.printf("\nA produto com id %d não foi encontrado!", id);
		}
		
	}

	private static void deletarProduto() {
		System.out.print("Digite o Id do produto desejado: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			System.out.print("\nVocê tem certeza que deseja excluir o produto? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nCancelado com sucesso!");
			}

		} else {
			System.out.printf("\nO produto com o Id %d não foi encontrado!", id);
		}
	}

	private static void keyPress() {
		System.out.println("\nPressione Enter para continuar...");
		leia.nextLine();
	}

	private static void listarProdutos() {
		produtoController.listarTodos();
	}

	private static void cadastrarProduto() {
		System.out.print("Digite o nome do Novo produto: ");
		String nome = leia.nextLine();

		System.out.print("Digite o Categoria do produto (1 - Eletrônicos || 2 - Roupas): ");
		int categoria = leia.nextInt();

		System.out.print("Digite o Preço do novo produto: ");
		float preco = leia.nextFloat();
		leia.nextLine();

		switch (categoria) {
		case 1 -> {
			System.out.print("Digite o tipo do Eletronico: ");
			
			String game = leia.nextLine();
			
			produtoController.cadastrar(new Eletronicos(produtoController.gerarId(), nome, categoria, preco, game));
		}
		case 2 -> {
			System.out.print("Digite o tipo de Roupa ( Roupa de Verão ou de Inverno): ");
			
			String tipoDeRoupa = leia.nextLine();
			
			produtoController.cadastrar(new Roupa(produtoController.gerarId(), nome, categoria, preco, tipoDeRoupa));
		}
		default -> System.out.println("Categoria de produto inválido!");
		}
	}

	
}
