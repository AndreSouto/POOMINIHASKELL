package br.unb.poo.mh;

public class ValorFloat extends ValorParametrizado<Float> {
	
	public ValorFloat(float valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Float;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	

}
