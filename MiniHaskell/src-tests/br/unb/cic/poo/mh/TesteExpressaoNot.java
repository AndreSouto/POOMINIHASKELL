package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Not;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Igual;
import br.unb.poo.mh.MaiorIgual;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoNot {

	private ValorBooleano v_verdadeiro = new ValorBooleano(true);
	private ValorBooleano v_falso = new ValorBooleano(false);
	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v10 = new ValorInteiro(10);
	
	@Test
	public void testNot(){
		
		Expressao maiorIgual = new MaiorIgual(v10,v5);
		Expressao igualdade = new Igual(v_falso, v_verdadeiro);
		Expressao maiorIgual2 = new MaiorIgual(v5,v10);
		Expressao igualdade2 = new Igual(v_verdadeiro,v_verdadeiro);
		
		Assert.assertEquals(v_falso, new Not(maiorIgual).avaliar());
		Assert.assertEquals(v_verdadeiro, new Not(igualdade).avaliar());
		Assert.assertEquals(v_verdadeiro, new Not(maiorIgual2).avaliar());
		Assert.assertEquals(v_falso, new Not(igualdade2).avaliar());
	}
	
	@Test
	public void testNotTipo(){
		
		ValorInteiro v1 = new ValorInteiro(10);
		ValorBooleano v2 = new ValorBooleano(false);
		
		Assert.assertEquals(Tipo.Booleano, new Not(v2).tipo());
		Assert.assertEquals(Tipo.Error, new Not(v1).tipo());
		
	}
	
	@Test
	public void testeNotPrint(){
		ValorBooleano B2 = new ValorBooleano(true);
		Expressao not = new Not(B2);
		PrettyPrinter pp = new PrettyPrinter();
		not.aceitar(pp);
	}
	
	@Test
	public void testeNotTamanho(){
		ValorBooleano B2 = new ValorBooleano(true);
		Expressao not = new Not(B2);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		not.aceitar(t);
		Assert.assertEquals( 2 ,t.getTamanho());
	}
}
