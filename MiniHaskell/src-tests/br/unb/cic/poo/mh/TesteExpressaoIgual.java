package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Igual;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Tipo;

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
	
	@Test
	public void testIgualdadeTipoBooleanoOk() {
		
		ValorBooleano v1 = new ValorBooleano(true);
		ValorBooleano v2 = new ValorBooleano(false);
		
		Expressao igualdade = new Igual(v1,v2);
		Assert.assertEquals(Tipo.Booleano, igualdade.tipo());
		
	}
	
	@Test
	public void testIgualdadeTipoInteiroOk(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorInteiro v2 = new ValorInteiro(10);
		
		Assert.assertEquals(Tipo.Booleano, new Igual(v1,v2).tipo());
		
	}

	@Test
	public void testIgualdadeTipoNok(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorBooleano v2 = new ValorBooleano(false);
		
		Assert.assertEquals(Tipo.Error, new Igual(v1,v2).tipo());
		
	}
	
	@Test
	public void testeIgualPrint(){
		ValorBooleano v2 = new ValorBooleano(false);
		ValorBooleano v3 = new ValorBooleano(true);
		Igual equals = new Igual(v2,v3);
		PrettyPrinter pp = new PrettyPrinter();
		equals.aceitar(pp);
	}

	@Test
	public void testeIgualTamanho(){
		ValorBooleano v2 = new ValorBooleano(false);
		ValorBooleano v3 = new ValorBooleano(true);
		Expressao igual = new Igual(v2,v3);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		igual.aceitar(t);
		Assert.assertEquals( 3 ,t.getTamanho());
	}
}
