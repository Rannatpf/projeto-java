package ecommerce.model;

import java.util.ArrayList;

public class Produtos extends Ecommerce{
	
	 private ArrayList<Produtos> produtos;

	    public Produtos(String peca, String tamanho, int quantidade, float valor) {
	        super(peca, tamanho, quantidade, valor, 0, ""); 
	        this.produtos = new ArrayList<>();
	    }

	    public ArrayList<Produtos> getProdutos() {
	        return produtos;
	    }

	    public void setProdutos(ArrayList<Produtos> produtos) {
	        this.produtos = produtos;
	    }

	    public boolean remover(float valor) {
	        if (this.getTotal() < valor) {
	            System.out.println("\nNenhum produto adicionado!");
	            return false;
	        }

	        this.setTotal(this.getTotal() - valor);
	        return true;
	    }
	}
