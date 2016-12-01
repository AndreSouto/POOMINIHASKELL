package br.unb.poo.mh;

public class IfThenElse implements Expressao {
	Expressao condicao;
	Expressao clausulaThen;
	Expressao clausulaElse;
	
	public IfThenElse(Expressao condicao, Expressao clausulaThen, Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	} 
	
	public Valor avaliar() {
		ValorBooleano valor = (ValorBooleano)condicao.avaliar();
		if(valor.getValor()) {
			return clausulaThen.avaliar();
		}
		return 			clausulaElse.avaliar();
	}

	@Override
	public Tipo tipo() {
		return (condicao.tipo() == Tipo.Booleano) ? Tipo.Booleano : Tipo.Error;
		
		//TODO: Melhorar/confirmar defini��o do tipo da IfThenElse
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
