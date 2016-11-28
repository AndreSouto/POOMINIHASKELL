package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;

import br.unb.poo.mh.Divisao;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoDivisao {

	@Test
	public void testDivisao() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v2 = new ValorInteiro(2);
		
		Expressao div = new Divisao(v10,v5);
		Assert.assertEquals(v2,div.avaliar());
		
	}

}
