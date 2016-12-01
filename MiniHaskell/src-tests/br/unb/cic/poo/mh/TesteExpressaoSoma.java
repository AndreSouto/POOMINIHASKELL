package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoSoma;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorFloat;


public class TesteExpressaoSoma {

	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v10 = new ValorInteiro(10);
	private Expressao soma = new ExpressaoSoma(v5, v10);
	
	@Test
	public void testeSomaSimplesInteiro() {
		ValorInteiro v15 = new ValorInteiro(15);
		Assert.assertEquals(v15, soma.avaliar());
	}
	
	@Test
	public void testeSomaComplexaInteiro() {
		ValorInteiro v25 = new ValorInteiro(25);
		Expressao soma2 = new ExpressaoSoma(v10, soma);
		Assert.assertEquals(v25, soma2.avaliar());
	}
	
	
	/*@Test
	public void testeSomaSimplesFloat() {
		ValorFloat v3 = new ValorFloat((float) 3.5);
		ValorFloat v4 = new ValorFloat((float) 4.3);
		Expressao soma4 = new ExpressaoSoma(v3,v4);
		Assert.assertEquals(new ValorFloat((float)7.8), soma4.avaliar());
	}
	
	@Test
	public void testeSomaComplexaFloat() {
		ValorFloat v3 = new ValorFloat((float) 3.5);
		ValorFloat v4 = new ValorFloat((float) 4.3);
		Expressao soma4 = new ExpressaoSoma(v3,v4);
		Expressao soma5 = new ExpressaoSoma(v3, soma4.avaliar());
		Assert.assertEquals(new ValorFloat((float)11.3), soma5.avaliar());
	}*/
	
	@Test
	public void testeSomaTipoInteiroOk() {
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(v3, v5);
		
		Assert.assertEquals(Tipo.Inteiro, soma3.tipo());
	}
	
	@Test
	public void testeSomaTipoFloatEmUmOk() {
		ValorFloat v3 = new ValorFloat((float)3.5);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(v3, v5);
		
		Assert.assertEquals(Tipo.Float, soma3.tipo());
	}
	
	@Test
	public void testeSomaTipoFloatEmDoisOk() {
		ValorFloat v3 = new ValorFloat((float)3.5);
		ValorFloat v5 = new ValorFloat((float)5.4);
		Expressao soma3 = new ExpressaoSoma(v3, v5);
		
		Assert.assertEquals(Tipo.Float, soma3.tipo());
	}
	
	@Test
	public void testeSomaTipoNoOkBool() {
		ValorBooleano t = new ValorBooleano(true);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(t, v5);
		
		Assert.assertEquals(Tipo.Error, soma3.tipo());
	}
	
	/*@Test
	public void testeSomaTipoNoOkError() {
		ValorBooleano t = new ValorBooleano(true);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao soma3 = new ExpressaoSoma(t, v5);
		Expressao soma4 = new ExpressaoSoma(t, soma3.avaliar());
		Assert.assertEquals(Tipo.Error, soma4.tipo());
	}*/
	
	@Test
	public void testeSomaTamanho(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Expressao soma = new ExpressaoSoma(v20, v2);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		soma.aceitar(t);
		Assert.assertEquals( 3 ,t.getTamanho());
	}
}
