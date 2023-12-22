package projeto_java;
import loja.model.Loja;
import loja.model.Produto;
import loja.model.CatalogoProdutos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import loja.model.FormaDePagamento;

public class Menu {

	public static void main(String[] args) {
		
		
		Scanner leia = new Scanner(System.in);
		CatalogoProdutos catalogo = new CatalogoProdutos();
			
		int opcao;
		
		List<Loja> carrinho = new ArrayList<>();
		FormaDePagamento formaDePagamento = null;

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
					exibirCatalogo(catalogo);
					int opcaoProduto = leia.nextInt();
					adicionarProdutoAoCarrinho(catalogo, carrinho, opcaoProduto);
					break;
				case 2:
					System.out.println("REMOVER PRODUTO DO CARRINHO\n\n");
					exibirCarrinho(carrinho);
                    int opcaoRemover = leia.nextInt();
                    removerProdutoDoCarrinho(carrinho, opcaoRemover);
					break;
				case 3:
					System.out.println("MOSTRAR CARRINHO ATUALIZADO\n\n");
					for(Loja item : carrinho) {
						item.visualizar();
					}
					break;
				case 4:
					System.out.println("FORMA DE PAGAMENTO\n\n");
					formaDePagamento = escolherFormaDePagamento();
					break;
				case 5:
					System.out.println("FINALIZAR COMPRA \n\n");
					 finalizarCompra(carrinho, formaDePagamento);
					break;
				
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		
}
	
	 private static void finalizarCompra(List<Loja> carrinho, FormaDePagamento formaDePagamento) {
	        if (carrinho.isEmpty()) {
	            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar a compra.");
	        } else if (formaDePagamento == null) {
	            System.out.println("Escolha uma forma de pagamento antes de finalizar a compra.");
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
	private static void exibirCarrinho(List<Loja> carrinho) {
        System.out.println("CARRINHO DE COMPRAS\n");

        for (int i = 0; i < carrinho.size(); i++) {
            Loja itemCarrinho = carrinho.get(i);
            System.out.println((i + 1) + ". " + itemCarrinho.getPeca() + " - Tamanho: " +
                    itemCarrinho.getTamanho() + " - Quantidade: " + itemCarrinho.getQuantidade() +
                    " - Valor: " + itemCarrinho.getValor());
        }
    }

    private static void removerProdutoDoCarrinho(List<Loja> carrinho, int opcaoRemover) {
        if (opcaoRemover > 0 && opcaoRemover <= carrinho.size()) {
            carrinho.remove(opcaoRemover - 1);
            System.out.println("Produto removido do carrinho!");
        } else {
            System.out.println("Opção inválida!");
        }
    }
	private static void exibirCatalogo(CatalogoProdutos catalogo) {
        System.out.println("CATÁLOGO DE PRODUTOS DISPONÍVEIS\n");

        List<Produto> produtos = catalogo.getProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println((i + 1) + ". " + produto.getNome() + " - Tamanho: " + produto.getTamanho()
                    + " - Valor: " + produto.getValor());
        }
    }

    private static void adicionarProdutoAoCarrinho(CatalogoProdutos catalogo, List<Loja> carrinho, int opcaoProduto) {
        List<Produto> produtos = catalogo.getProdutos();

        if (opcaoProduto > 0 && opcaoProduto <= produtos.size()) {
            Produto produtoSelecionado = produtos.get(opcaoProduto - 1);
           
            Loja itemCarrinho = new Loja(produtoSelecionado.getNome(),
                    produtoSelecionado.getTamanho(), 1, produtoSelecionado.getValor());
            carrinho.add(itemCarrinho);
            System.out.println("Produto adicionado ao carrinho!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

 }		
		

		
		
		
		
		

