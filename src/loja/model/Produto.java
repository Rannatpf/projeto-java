package loja.model;

public class Produto {
	
	    private String nome;
	    private String tamanho;
	    private float valor;

	    public Produto(String nome, String tamanho, float valor) {
	        this.nome = nome;
	        this.tamanho = tamanho;
	        this.valor = valor;
	    }

	    public String getNome() {https://chat.openai.com/c/3c0b387a-e83d-489a-bc3c-37b00ecef91b
	        return nome;
	    }

	    public String getTamanho() {
	        return tamanho;
	    }

	    public float getValor() {
	        return valor;
	    }
	}

