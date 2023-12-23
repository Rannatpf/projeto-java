package ecommerce.repository;

import ecommerce.model.Produtos;  // Importe a classe Produto, se necessário

public interface Repository {
    void adicionar(Produtos produto); 
    void remover(int id); 
    void atualizar(Produtos produto);
    void deletar(int id);
}
