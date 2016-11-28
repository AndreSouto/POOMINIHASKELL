package br.unb.poo.mh;

//TODO: Do everything !
public class And extends ExpressaoBinaria {

	public And(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v2 = (ValorInteiro) expEsquerda.avaliar();
		ValorInteiro v1 = (ValorInteiro) expDireita.avaliar();
		
		
		return new ValorInteiro(v1.getValor() / v2.getValor());
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
