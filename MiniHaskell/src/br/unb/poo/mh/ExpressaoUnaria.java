package br.unb.poo.mh;

public abstract class ExpressaoUnaria implements Expressao {

	protected Expressao expEsquerda; 
	
	public ExpressaoUnaria(Expressao expEsquerda) {
		this.expEsquerda = expEsquerda;
	}

}
