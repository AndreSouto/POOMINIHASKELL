package br.unb.poo.mh;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		//if(expEsquerda.tipo()==Tipo.Inteiro && expDireita.tipo()==Tipo.Inteiro){
			
			ValorInteiro ve = (ValorInteiro)expEsquerda.avaliar();
			ValorInteiro vd = (ValorInteiro)expDireita.avaliar();
			return new ValorInteiro(ve.getValor() + vd.getValor());
		/*}else{
			ValorFloat ve = (ValorFloat)expEsquerda.avaliar();
			ValorFloat vd = (ValorFloat)expDireita.avaliar();
			return new ValorFloat(ve.getValor() + vd.getValor());
		}*/
	}
	
	@Override
	public Tipo tipo() {
		if (expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro){
			return Tipo.Inteiro;
		}else if(expEsquerda.tipo() == Tipo.Booleano || expDireita.tipo() == Tipo.Booleano || expEsquerda.tipo() == Tipo.Error || expDireita.tipo() == Tipo.Error){
			return Tipo.Error;
		}else{
			return Tipo.Float;
		}
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
