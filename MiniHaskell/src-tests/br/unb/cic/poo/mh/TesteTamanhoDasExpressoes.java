package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorFloat;

public class TesteTamanhoDasExpressoes {
	
	@Test
	public void testeTamanhoBool(){
		ValorBooleano bt = new ValorBooleano(true);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		bt.aceitar(t);
		Assert.assertEquals( 1 ,t.getTamanho());
	}
	
	@Test
	public void testeTamanhoFloat(){
		ValorFloat bt = new ValorFloat((float)3.5);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		bt.aceitar(t);
		Assert.assertEquals( 1 ,t.getTamanho());
	}
	
	@Test
	public void testeIdentificadorTamanho(){
		Identificador id = new Identificador("y");
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		id.aceitar(t);
		Assert.assertEquals( 1 ,t.getTamanho());
	}

}
