package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Igual;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoIgual { 
	
	private ValorBooleano v_verdadeiro = new ValorBooleano(true);
	private ValorBooleano v_falso = new ValorBooleano(false);
	
	@Test
	public void testIgualdadeBooleano() {
		
		ValorBooleano v1 = new ValorBooleano(true);
		ValorBooleano v2 = new ValorBooleano(false);
		ValorBooleano v3 = new ValorBooleano(false);
		
		Expressao igualdade = new Igual(v1,v2);
		Assert.assertEquals(v_falso, igualdade.avaliar());
		Assert.assertEquals(v_verdadeiro, new Igual(v2,v3).avaliar());
		
	}
	
	@Test
	public void testIgualdadeInteiro(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorInteiro v2 = new ValorInteiro(10);
		ValorInteiro v3 = new ValorInteiro(20);
		
		Assert.assertEquals(v_falso, new Igual(v3,v1).avaliar());
		Assert.assertEquals(v_verdadeiro, new Igual(v1,v2).avaliar());
		
	}
	

}
