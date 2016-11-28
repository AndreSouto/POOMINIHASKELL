package br.unb.poo.mh;

public class MaiorIgual extends ExpressaoBinaria {

	public MaiorIgual(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
			
			ValorInteiro v1 = (ValorInteiro) expEsquerda.avaliar();
			ValorInteiro v2 = (ValorInteiro) expDireita.avaliar();
				
			if(v2.getValor() >= v1.getValor()){
					
				return new ValorBooleano(true);
			}
		
		return new ValorBooleano(false);
	}

	@Override
	public Tipo tipo() {
		return ((expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro))
				? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}