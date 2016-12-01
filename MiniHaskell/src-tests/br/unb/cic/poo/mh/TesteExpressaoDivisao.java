package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;

import br.unb.poo.mh.Divisao;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.ValorBooleano;

public class TesteExpressaoDivisao {

	@Test
	public void testDivisaoInt() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v2 = new ValorInteiro(2);
		
		Expressao div = new Divisao(v10,v5);
		Assert.assertEquals(v2,div.avaliar());
	}
	
	@Test
	public void testeDivisaoComplexa() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v2 = new ValorInteiro(2);
		Expressao div2 = new Divisao(v10,v5);
		Expressao div3 = new Divisao(v2, div2);
		
		Assert.assertEquals(new ValorInteiro(1), div3.avaliar());
	}
	
	@Test
	public void testeDivisaoTipoOk() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao div4 = new Divisao(v10, v5);
		
		Assert.assertEquals(Tipo.Inteiro, div4.tipo());
	}
	
	@Test
	public void testeDivisaoTipoNok() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorBooleano vtrue = new ValorBooleano(true);
		Expressao div6 = new Divisao(v10, vtrue);
		
		Assert.assertEquals(Tipo.Error, div6.tipo());
	}

	/*@Test
	public void testeDivisaoFloat() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v3 = new ValorInteiro(3);
		
		Expressao div = new Divisao(v10,v3);
		//TODO: AVALIAR A EXCESS�O/TIPO FLOAT
		
	}*/
	
	@Test
	public void testeDivisaoPrint(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Divisao Div = new Divisao(v20,v2);
		PrettyPrinter pp = new PrettyPrinter();
		Div.aceitar(pp);
	}
	
	@Test
	public void testeDivisaoTamanho(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Divisao Div = new Divisao(v20,v2);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		Div.aceitar(t);
		Assert.assertEquals( 3 ,t.getTamanho());
	}
}
