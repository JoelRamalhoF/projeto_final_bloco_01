package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	

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
                    System.out.println("Consultar dados do Produto - por ID\n");
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

    private static void criarProdutosTeste() {
        // TODO Auto-generated method stub
    }

    private static void procurarProdutoPorId() {
        // TODO Auto-generated method stub
    }

    private static void atualizarProduto() {
        // TODO Auto-generated method stub
    }

    private static void deletarProduto() {
        // TODO Auto-generated method stub
    }

    private static void keyPress() {
        System.out.println("\nPressione Enter para continuar...");
        leia.nextLine();
    }

    private static void listarProdutos() {
        // TODO Auto-generated method stub
    }

    private static void cadastrarProduto() {
        // TODO Auto-generated method stub
    }

  

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Joel");
		System.out.println("Joel Ramalho Filho - joelramalho.negociosonline@gmail.com");
		System.out.println("https://github.com/JoelRamalhoF");
		System.out.println("*********************************************************");
	}
}
