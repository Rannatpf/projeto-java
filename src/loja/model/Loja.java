package loja.model;

public class Loja {
		
	private String peca;
	private String tamanho;
	private int quantidade;
	private float valor; 
	private float total;
	private String tipo;
	
	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
		
	}
	
	public void adicionar(float valor) {

		this.setTotal(this.getTotal() + valor);
		}
	
	
    public boolean remover(float valor) { 
		
		if(this.getTotal() < valor) {
			System.out.println("\n Nenhuma peça adicionada!");
			return false;
		}
			
		this.setTotal(this.getTotal() - valor);
		return true;
	}

	

	public Loja(String peca, String tamanho, int quantidade, float valor, float total) {
		this.peca = peca;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.valor = valor;
		this.total = total;
	}
	
		public Loja(String peca, String tamanho, int quantidade, float valor) {
			this(peca, tamanho, quantidade, valor, 0);
	}

		public void visualizar() {

			String pecaLabel = "";
			
			switch(this.peca) {
			case "Blusa":
				pecaLabel = "Blusa";
			break;
			case "Calça":
				pecaLabel = "Calça";
			break;
			case "Vestido":
				pecaLabel = "Vestido";
			break;
			case "Shorts":
				pecaLabel = "Shorts";
			break;
			}
			
			System.out.println("\n\n***********************************************************");
			System.out.println("Peça:" + pecaLabel);
			System.out.println("Tamanho: " + this.tamanho);
			System.out.println("Quantidade: " + this.quantidade);
			System.out.println("Valor: " + this.valor);
			
		
	}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		} 
}
