package br.unb.poo.mh;

public class Not extends ExpressaoBinaria{

	public Not(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
	
		return null;
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro) ? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
