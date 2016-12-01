package br.unb.cic.poo.mh;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.MenorIgual;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoMenorIgual {

	private ValorBooleano v_verdadeiro = new ValorBooleano(true);
	private ValorBooleano v_falso = new ValorBooleano(false);
	
	@Test
	public void testComparacaoInteiro(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorInteiro v2 = new ValorInteiro(10);
		ValorInteiro v3 = new ValorInteiro(20);
		
		Assert.assertEquals(v_falso, new MenorIgual(v3,v1).avaliar());
		Assert.assertEquals(v_falso, new MenorIgual(v3,v2).avaliar());
		Assert.assertEquals(v_verdadeiro, new MenorIgual(v1,v3).avaliar());
		Assert.assertEquals(v_verdadeiro, new MenorIgual(v1,v2).avaliar());
	}
	
	@Test
	public void testeComparacaoTipo() {
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorInteiro v2 = new ValorInteiro(10);
		ValorBooleano v3 = new ValorBooleano(true);
		
		Assert.assertEquals(Tipo.Booleano, new MenorIgual(v1,v2).tipo());
		Assert.assertEquals(Tipo.Error, new MenorIgual(v1,v3).tipo());
		Assert.assertEquals(Tipo.Error, new MenorIgual(v3,v1).tipo());
		
	}
}
