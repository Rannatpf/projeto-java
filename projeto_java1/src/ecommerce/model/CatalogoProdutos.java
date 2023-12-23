package ecommerce.model;

import java.util.ArrayList;
import java.util.List;


public class CatalogoProdutos {
	private List<Produtos> produtos;

	public CatalogoProdutos() {
	    this.produtos = new ArrayList<>();
        inicializarCatalogo();
    }

	
	private void inicializarCatalogo() {
        adicionarProduto("Blusa", "P", 30.00f);
        adicionarProduto("Blusa", "M", 30.00f);
        adicionarProduto("Blusa", "G", 30.00f);
        adicionarProduto("Calça", "P", 40.00f);
        adicionarProduto("Calça", "M", 40.00f);
        adicionarProduto("Calça", "G", 40.00f);
        adicionarProduto("Vestido", "P", 50.00f);
        adicionarProduto("Vestido", "M", 50.00f);
        adicionarProduto("Vestido", "G", 50.00f);
        adicionarProduto("Shorts", "P", 25.00f);
        adicionarProduto("Shorts", "M", 25.00f);
        adicionarProduto("Shorts", "G", 25.00f);
    }
	
    private void adicionarProduto(String nome, String tamanho, float valor) {
        Produtos produto = new Produtos(nome, tamanho,0, valor);
        produtos.add(produto);
    }

    public List<Produtos> getProdutos() {
    	 return new ArrayList<>(produtos);
    }
    public void adicionarProdutoAoCatalogo(String nome, String tamanho, float valor) {
    	adicionarProduto(nome, tamanho, valor);
    }
}

