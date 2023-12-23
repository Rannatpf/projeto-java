package controller;
import java.util.ArrayList;
import ecommerce.model.Ecommerce;
import ecommerce.model.Produtos;
import ecommerce.repository.Repository;

public class EcommerceController implements Repository{
	
	private ArrayList<Ecommerce>listaProdutos = new ArrayList<>();
	
	

	@Override
	public void adicionar(Produtos produto) {
		Ecommerce ecommerce = new Ecommerce();
        listaProdutos.add(ecommerce);
        System.out.println("Produto adicionado ao carrinho!");
		
	}

	@Override
	public void remover(int id) {
		if (id >= 0 && id < listaProdutos.size()) {
            listaProdutos.remove(id);
            System.out.println("Produto removido do carrinho!");
        } else {
            System.out.println("Produto não encontrado no carrinho!");
        }
    }
		


	@Override
	public void atualizar(Produtos produto) {
		for (Ecommerce ecommerce : listaProdutos) {
            if (ecommerce.getPeca().equals(produto.getPeca())) {
                ecommerce.setQuantidade(produto.getQuantidade());
                ecommerce.setValor(produto.getValor());
                ecommerce.setTotal(produto.getTotal());
                System.out.println("Produto atualizado no carrinho!");
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho!");
    }
		
	




	public ArrayList<Ecommerce> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Ecommerce> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub
		
	}

}
