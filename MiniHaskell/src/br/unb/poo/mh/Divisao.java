package br.unb.poo.mh;

public class Divisao extends ExpressaoBinaria {

	public Divisao(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v2 = (ValorInteiro) expEsquerda.avaliar();
		ValorInteiro v1 = (ValorInteiro) expDireita.avaliar();
		
		if((v1.getValor() > v2.getValor() || v1.getValor() == v2.getValor())
			&& (v1.getValor()%v2.getValor() == 0)){
			
			return new ValorInteiro(v1.getValor() / v2.getValor());
		}
		else{
			throw new ArithmeticException();
		}
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
