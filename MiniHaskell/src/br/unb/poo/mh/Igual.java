package br.unb.poo.mh;

public class Igual extends ExpressaoBinaria {

	public Igual(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		
		if(expEsquerda.tipo() == Tipo.Booleano){
			
				ValorBooleano v1 = (ValorBooleano) expEsquerda.avaliar();
				ValorBooleano v2 = (ValorBooleano) expDireita.avaliar();
				
				if(v2.getValor() == v1.getValor()){
					
					return new ValorBooleano(true);
				}
		}
		else if(expEsquerda.tipo() == Tipo.Inteiro){
			
				ValorInteiro v1 = (ValorInteiro) expEsquerda.avaliar();
				ValorInteiro v2 = (ValorInteiro) expDireita.avaliar();
				
				if(v2.getValor() == v1.getValor()){
					
					return new ValorBooleano(true);
				}
		}
		
		return new ValorBooleano(false);
	}

	@Override
	public Tipo tipo() {
		return ((expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro) ||
				(expEsquerda.tipo() == Tipo.Booleano && expDireita.tipo() == Tipo.Booleano))
				? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}

}
