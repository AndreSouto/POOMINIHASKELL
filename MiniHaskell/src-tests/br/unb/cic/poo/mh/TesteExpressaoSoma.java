package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoSoma;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;


public class TesteExpressaoSoma {

	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v10 = new ValorInteiro(10);
	private Expressao soma = new ExpressaoSoma(v5, v10);
	
	@Test
	public void testeSomaSimples() {
		ValorInteiro v15 = new ValorInteiro(15);
		Assert.assertEquals(v15, soma.avaliar());
	}
	
	@Test
	public void testeSomaComplexa() {
		ValorInteiro v25 = new ValorInteiro(25);
		Expressao soma2 = new ExpressaoSoma(v10, soma);
		Assert.assertEquals(v25, soma2.avaliar());
	}
	
	@Test
	public void testeSomaTipoOk() {
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(v3, v5);
		
		Assert.assertEquals(Tipo.Inteiro, soma3.tipo());
	}
	
	@Test
	public void testeSomaTipoNok() {
		ValorBooleano t = new ValorBooleano(true);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(t, v5);
		
		Assert.assertEquals(Tipo.Error, soma3.tipo());
	}
	
}
