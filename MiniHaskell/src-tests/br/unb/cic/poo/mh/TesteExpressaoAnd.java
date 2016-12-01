package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.And;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Igual;
import br.unb.poo.mh.MaiorIgual;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoAnd {

	private ValorBooleano v_verdadeiro = new ValorBooleano(true);
	private ValorBooleano v_falso = new ValorBooleano(false);
	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v10 = new ValorInteiro(10);
	
	@Test
	public void testAnd(){
		
		Expressao maiorIgual = new MaiorIgual(v10,v5);
		Expressao igualdade = new Igual(v_falso, v_verdadeiro);
		
		ValorBooleano v1 = new ValorBooleano(true);
		
		Expressao igualdade2 = new Igual(v1,v_verdadeiro);
		Expressao maiorIgual2 = new MaiorIgual(v5,v10);
	
		Assert.assertEquals(v_falso, new And(igualdade,maiorIgual).avaliar());
		Assert.assertEquals(v_falso, new And(maiorIgual,igualdade).avaliar());
		Assert.assertEquals(v_verdadeiro, new And(igualdade2,maiorIgual).avaliar());
		Assert.assertEquals(v_falso, new And(igualdade2,maiorIgual2).avaliar());
	}
	
	@Test
	public void testAndTipo(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorBooleano v2 = new ValorBooleano(false);
		ValorBooleano v3 = new ValorBooleano(true);
		
		Assert.assertEquals(Tipo.Booleano, new And(v3,v2).tipo());
		Assert.assertEquals(Tipo.Error, new And(v1,v2).tipo());
		
	}
}
