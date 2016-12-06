package br.unb.cic.poo.mh;

import org.junit.Assert;

import org.junit.Test;
 
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

}