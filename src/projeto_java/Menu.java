package projeto_java;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                E-COMMERCE SMC                       ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - COLOCAR PRODUTO NO CARRINHO          ");
			System.out.println("            2 - REMOVER PRODUTO DO CARRINHO          ");
			System.out.println("            3 - MOSTRAR CARRINHO ATUALIZADO          ");
			System.out.println("            4 - FORMA DE PAGAMENTO                   ");
			System.out.println("            5 - FINALIZAR COMPRA                     ");
			System.out.println("            6 - SAIR                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("            Entre com a opção desejada:              ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nE-COMMERCE SMC - PEQUENO ESTILO ");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("COLOCAR PRODUTO NO CARRINHO\n\n");

					break;
				case 2:
					System.out.println("REMOVER PRODUTO DO CARRINHO\n\n");

					break;
				case 3:
					System.out.println("MOSTRAR CARRINHO ATUALIZADO\n\n");

					break;
				case 4:
					System.out.println("FORMA DE PAGAMENTO\n\n");

					break;
				case 5:
					System.out.println("FINALIZAR COMPRA \n\n");

					break;
				
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
	}

}
		
		

		
		
		
		
		

