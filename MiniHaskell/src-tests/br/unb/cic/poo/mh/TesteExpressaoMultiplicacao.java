package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Multiplicacao;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoMultiplicacao {

	@Test
	public void testeMultiplicacao() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao m1 = new Multiplicacao(v10, v5);
		
		Assert.assertEquals(new ValorInteiro(50), m1.avaliar());
	}
	
	@Test
	public void testeMultiplicacaoTipoOk() {
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao m3 = new Multiplicacao(v3, v5);
		
		Assert.assertEquals(Tipo.Inteiro, m3.tipo());
	}
	
	@Test
	public void testeMultiplicacaoTipoNok() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorBooleano vtrue = new ValorBooleano(true);
		
		Expressao m2 = new Multiplicacao(v10, vtrue);
		
		Assert.assertEquals(Tipo.Error, m2.tipo());
	}
	
	@Test
	public void testeMultiplicacaoComplexa() {
		ValorInteiro v25 = new ValorInteiro(25);
		ValorInteiro v10 = new ValorInteiro(10);
		Expressao m5 = new Multiplicacao(v25, v10);
		Expressao m6 = new Multiplicacao(v10, m5);
		
		Assert.assertEquals(new ValorInteiro(2500), m6.avaliar());
	}
	
	@Test
	public void testeMultiplicacaoPrint(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Multiplicacao multi = new Multiplicacao(v20,v2);
		PrettyPrinter pp = new PrettyPrinter();
		multi.aceitar(pp);
	}
	
	@Test
	public void testeMultiplicacaoTamanho(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Multiplicacao multi = new Multiplicacao(v20,v2);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		multi.aceitar(t);
		Assert.assertEquals( 3 ,t.getTamanho());
	}
	
}
