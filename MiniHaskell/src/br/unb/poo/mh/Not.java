package br.unb.poo.mh;

public class Not extends ExpressaoUnaria{

	public Not(Expressao expEsquerda) {
		super(expEsquerda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
		
		ValorBooleano ee = (ValorBooleano) expEsquerda.avaliar();
		
		if(ee.getValor() == true){
			
			return new ValorBooleano(false);
		}
		else{
			
			return new ValorBooleano(true);
		}
		
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Booleano) ? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
