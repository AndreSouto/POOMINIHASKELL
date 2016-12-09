package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;

import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.ValorLista;

public class TesteValorLista {

	@Test
	public void testValorLista() {
		
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro indice = new ValorInteiro(2);
		
		ValorLista<Integer> lista = new ValorLista<Integer>(v1.getValor());
		lista.adicionar(v2.getValor());
		lista.adicionar(v10.getValor());
		
		ValorInteiro tamanho = lista.tam();
		
		Assert.assertEquals(v10.getValor(),lista.recuperar(indice));
		Assert.assertEquals(new ValorInteiro(3), tamanho);
		
		lista.retirar(indice);
		tamanho = lista.tam();
		Assert.assertEquals(new ValorInteiro(2), tamanho);
		
		indice = new ValorInteiro(0);
		Assert.assertEquals(v1.getValor(), lista.recuperar(indice));
		
		
	}

	@Test
	public void testeListaPrint(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorLista<Integer> lista = new ValorLista<Integer>(v1.getValor());
		lista.adicionar(v2.getValor());
		lista.adicionar(v10.getValor());
		PrettyPrinter pp = new PrettyPrinter();
		lista.aceitar(pp);
	}
	
	@Test
	public void testeListaTamanho(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorLista<Integer> lista = new ValorLista<Integer>(v1.getValor());
		lista.adicionar(v2.getValor());
		lista.adicionar(v10.getValor());
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		lista.aceitar(t);
		Assert.assertEquals( 3,t.getTamanho());
		//Assert.assertEquals( 4,t.getTamanho());
	}
	
	@Test
	public void testeListaTipoOk(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorLista<Integer> lista = new ValorLista<Integer>(v1.getValor());
		lista.adicionar(v2.getValor());
		lista.adicionar(v10.getValor());
		Assert.assertEquals( Tipo.Lista,lista.tipo());
	}
	
	@Test
	public void testeListaAcessoErrado(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorLista<Integer> lista = new ValorLista<Integer>(v1.getValor());
		lista.adicionar(v2.getValor());
		lista.adicionar(v10.getValor());
		Assert.assertEquals(Tipo.Error, lista.recuperar(new ValorInteiro(3)) );
	}
}
