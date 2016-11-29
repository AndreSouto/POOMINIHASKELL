package br.unb.poo.mh;

//TODO: Do everything !
public class And extends ExpressaoBinaria {

	public And(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		
		ValorBooleano ed = (ValorBooleano) expDireita.avaliar();
		ValorBooleano ee = (ValorBooleano) expEsquerda.avaliar();
		
		if(ed.getValor() == true && ee.getValor() == true){
			
			return new ValorBooleano(true);
		}
		else{
			
			return new ValorBooleano(false);
		}
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Booleano && expDireita.tipo() == Tipo.Booleano)
				? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
