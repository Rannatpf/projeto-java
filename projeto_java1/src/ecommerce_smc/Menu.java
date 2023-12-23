package ecommerce_smc;
import controller.EcommerceController;
import ecommerce.model.Produtos;

import ecommerce.model.CatalogoProdutos;
import ecommerce.model.Ecommerce;
import ecommerce.model.FormaDePagamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Menu {


	public static void main(String[] args) {
		
		List<Ecommerce> carrinho = new ArrayList<>();

		Scanner leia = new Scanner(System.in);
		CatalogoProdutos catalogo = new CatalogoProdutos();
		 EcommerceController Ecommerce = new EcommerceController();
		  
		
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
			try {
			opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nE-COMMERCE SMC - PEQUENO ESTILO ");
				leia.close();
				System.exit(0);
			}
			
	            FormaDePagamento formaDePagamento = null;
	            switch (opcao) {
	                case 1:
	                    System.out.println("COLOCAR PRODUTO NO CARRINHO\n\n");
	                    exibirCatalogo(catalogo);
	                    int opcaoProduto = leia.nextInt();
	                    adicionarProdutoAoCarrinho(catalogo, carrinho, opcaoProduto);
	                    keyPress();
	                    break;
	                case 2:
	                    System.out.println("REMOVER PRODUTO DO CARRINHO\n\n");
	                    exibirCarrinho(carrinho);
	                    int opcaoRemover = leia.nextInt();
	                    removerProdutoDoCarrinho(carrinho, opcaoRemover);
	                    keyPress();
	                    break;
	                case 3:
	                    System.out.println("MOSTRAR CARRINHO ATUALIZADO\n\n");
	                    for (Ecommerce item : carrinho) {
	                        item.visualizar();
	                    }
	                    keyPress();
	                    break;
	                case 4:
	                    System.out.println("FORMA DE PAGAMENTO\n\n");
	                    formaDePagamento = escolherFormaDePagamento();
	                    keyPress();
	                    break;
	                case 5:
	                    System.out.println("FINALIZAR COMPRA \n\n");
	                    finalizarCompra(carrinho, formaDePagamento);
	                    keyPress();
	                    break;

	                default:
	                    System.out.println("\nOPÇÃO INVÁLIDA!\n");
	                    keyPress();
	                    break;
	            }
	        }
	    }

	    private static void finalizarCompra(List<Ecommerce> carrinho, FormaDePagamento formaDePagamento) {
	        if (carrinho == null || carrinho.isEmpty()) {
	            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar a compra.");
	       
	        } else {
	            System.out.println("Compra finalizada com sucesso!");
	        }
	    }

	    private static FormaDePagamento escolherFormaDePagamento() {
	        Scanner leia = new Scanner(System.in);

	        System.out.println("Escolha uma forma de pagamento:");
	        System.out.println("1. Débito");
	        System.out.println("2. Crédito");
	        System.out.println("3. PIX");
	        System.out.println("4. Boleto");

	        int opcao = leia.nextInt();

	        switch (opcao) {
	            case 1:
	                return new FormaDePagamento(true, false, false, false);
	            case 2:
	                return new FormaDePagamento(false, true, false, false);
	            case 3:
	                return new FormaDePagamento(false, false, true, false);
	            case 4:
	                return new FormaDePagamento(false, false, false, true);
	            default:
	                System.out.println("Opção inválida. Forma de pagamento não selecionada.");
	                return null;
	        }
	    }

	    private static void exibirCarrinho(List<Ecommerce> carrinho) {
	        if (carrinho == null || carrinho.isEmpty()) {
	            System.out.println("Carrinho vazio.");
	            return;
	        }

	        System.out.println("CARRINHO DE COMPRAS\n");

	        for (int i = 0; i < carrinho.size(); i++) {
	            Ecommerce itemCarrinho = carrinho.get(i);
	            System.out.println((i + 1) + ". " + itemCarrinho.getPeca() + " - Tamanho: " +
	                    itemCarrinho.getTamanho() + " - Quantidade: " + itemCarrinho.getQuantidade() +
	                    " - Valor: " + itemCarrinho.getValor());
	        }
	    }

	    private static void removerProdutoDoCarrinho(List<Ecommerce> carrinho, int opcaoRemover) {
	        if (carrinho == null || carrinho.isEmpty()) {
	            System.out.println("Carrinho vazio. Nenhum produto para remover.");
	            return;
	        }

	        if (opcaoRemover > 0 && opcaoRemover <= carrinho.size()) {
	            carrinho.remove(opcaoRemover - 1);
	            System.out.println("Produto removido do carrinho!");
	        } else {
	            System.out.println("Opção inválida!");
	        }
	    }

	    private static void exibirCatalogo(CatalogoProdutos catalogo) {
	        List<Produtos> produtos = catalogo.getProdutos();

	        if (produtos == null || produtos.isEmpty()) {
	            System.out.println("Catálogo vazio. Nenhum produto disponível.");
	            return;
	        }

	        System.out.println("CATÁLOGO DE PRODUTOS DISPONÍVEIS\n");

	        for (int i = 0; i < produtos.size(); i++) {
	            Produtos produto = produtos.get(i);
	            System.out.println((i + 1) + ". " + produto.getTipo() + " - Tamanho: " + produto.getTamanho()
	                    + " - Valor: " + produto.getValor());
	        }
	    }

	    private static void adicionarProdutoAoCarrinho(CatalogoProdutos catalogo, List<Ecommerce> carrinho, int opcaoProduto) {
	        List<Produtos> produtos = catalogo.getProdutos();

	        if (produtos == null || produtos.isEmpty()) {
	            System.out.println("Catálogo vazio. Nenhum produto disponível para adicionar ao carrinho.");
	            return;
	        }

	        if (opcaoProduto > 0 && opcaoProduto <= produtos.size()) {
	            Produtos produtoSelecionado = produtos.get(opcaoProduto - 1);

	           
	            Ecommerce itemCarrinho = new Ecommerce(
	                    produtoSelecionado.getTipo(),
	                    produtoSelecionado.getTamanho(),
	                    1,
	                    produtoSelecionado.getValor(),
	                    0,  ""); 
	            
	            carrinho.add(itemCarrinho);
	            System.out.println("Produto adicionado ao carrinho!");
	        } else {
	            System.out.println("Opção inválida!");
	        }
	    }
	    public static void keyPress() {
	        try {
	            System.out.println("\n\nPressione Enter para Continuar...");
	            System.in.read();
	        } catch (IOException e) {
	            System.out.println("Você pressionou uma tecla diferente de enter!");
	        }
	    }
	}

				