package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test; 

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.Subtracao;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;

public class TesteExpressaoSubtracao {
	
	private ValorInteiro v10 = new ValorInteiro(10);
	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v30 = new ValorInteiro(30);
	private Expressao sub = new Subtracao(v10,v30);

	
	@Test
	public void testeSubtracaoComplexa(){
		ValorInteiro v25 = new ValorInteiro(25);
		Expressao sub2 = new Subtracao(v10,v5);
		Expressao sub3 = new Subtracao(sub2,sub);
		
		Assert.assertEquals(v25, sub3.avaliar());
	}
	
	@Test
	public void testeSubtracaoSimples(){
		ValorInteiro v20 = new ValorInteiro(20);
		
		Assert.assertEquals(v20, sub.avaliar());
	}

	@Test
	public void testeSubtracaoTipoOk() {
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao sub4 = new Subtracao(v5, v3);
		
		Assert.assertEquals(Tipo.Inteiro, sub4.tipo());
	}
	
	@Test
	public void testeSomaTipoNok() {
		ValorBooleano t = new ValorBooleano(true);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao sub5 = new Subtracao(t, v5);
		
		Assert.assertEquals(Tipo.Error, sub5.tipo());
	}
	
	@Test
	public void testeSubtracaoPrint(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Subtracao sub = new Subtracao(v20,v2);
		PrettyPrinter pp = new PrettyPrinter();
		sub.aceitar(pp);
	}

	@Test
	public void testeSubtracaoTamanho(){
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v2 = new ValorInteiro(2);
		Expressao sub = new Subtracao(v20, v2);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		sub.aceitar(t);
		Assert.assertEquals( 3 ,t.getTamanho());
	}
}
