package br.unb.cic.poo.mh;

import org.junit.Test;

import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorFloat;
import br.unb.poo.mh.ValorInteiro;

public class TestePrettyPrinter {
	@Test
	public void testeBoolPrint(){
		ValorBooleano bt = new ValorBooleano(true);
		PrettyPrinter pp = new PrettyPrinter();
		bt.aceitar(pp);
	}
	
	@Test
	public void testeIntPrint(){
		ValorInteiro bt = new ValorInteiro(1);
		PrettyPrinter pp = new PrettyPrinter();
		bt.aceitar(pp);
	}
	
	@Test
	public void testeFloatPrint(){
		ValorFloat bt = new ValorFloat((float)3.5);
		PrettyPrinter pp = new PrettyPrinter();
		bt.aceitar(pp);
	}
	
	@Test
	public void testeIdentificadorPrint(){
		Identificador id = new Identificador("y");
		PrettyPrinter pp = new PrettyPrinter();
		id.aceitar(pp);
	}
	
}
