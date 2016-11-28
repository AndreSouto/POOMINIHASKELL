package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test; 

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Subtracao;
import br.unb.poo.mh.ValorInteiro;

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

}
