package ecommerce.model;

public class FormaDePagamento {
	private boolean debito;
	private boolean credito;
	private boolean pix;
	private boolean boleto;
	
	 public FormaDePagamento(boolean debito, boolean credito, boolean pix, boolean boleto) {
	        this.debito = debito;
	        this.credito = credito;
	        this.pix = pix;
	        this.boleto = boleto;
	    }

public boolean isDebito() {
	return debito;
}
public void setDebito(boolean debito) {
	this.debito = debito;
}
public boolean isCredito() {
	return credito;
}
public void setCredito(boolean credito) {
	this.credito = credito;
}
public boolean isPix() {
	return pix;
}
public void setPix(boolean pix) {
	this.pix = pix;
}
public boolean isBoleto() {
	return boleto;
}
public void setBoleto(boolean boleto) {
	this.boleto = boleto;
}
}



