package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoSoma;
import br.unb.poo.mh.IfThenElse;
import br.unb.poo.mh.Maior;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.Subtracao;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Tipo;


public class TesteIfThenElse {


	@Test
	public void testeThen(){
		ValorInteiro I1 = new ValorInteiro(5);
		ValorInteiro I2 = new ValorInteiro(2);
		Expressao condicao = new Maior(I1,I2);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		Assert.assertEquals(new ValorInteiro(10),ifThen.avaliar());
	}
	
	@Test
	public void testeElse(){
		ValorInteiro I1 = new ValorInteiro(5);
		ValorInteiro I2 = new ValorInteiro(2);
		Expressao condicao = new Maior(I2,I1);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		Assert.assertEquals(new ValorInteiro(0),ifThen.avaliar());
	}
	
	@Test
	public void testeTipoOk(){
		ValorInteiro I1 = new ValorInteiro(5);
		ValorInteiro I2 = new ValorInteiro(2);
		Expressao condicao = new Maior(I2,I1);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		Assert.assertEquals(Tipo.Booleano,ifThen.tipo());
	}
	
	@Test
	public void testeTipoNoOk(){
		ValorInteiro I1 = new ValorInteiro(5);
		Expressao condicao = new ExpressaoSoma(I1,I1);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		Assert.assertEquals(Tipo.Error,ifThen.tipo());
	}
	
	@Test
	public void testeIfPrint() {
		ValorInteiro I1 = new ValorInteiro(5);
		ValorInteiro I2 = new ValorInteiro(2);
		Expressao condicao = new Maior(I2,I1);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		PrettyPrinter pp = new PrettyPrinter();
		ifThen.aceitar(pp);
	}
	
	@Test
	public void testeIfTamanho() {
		ValorInteiro I1 = new ValorInteiro(5);
		ValorInteiro I2 = new ValorInteiro(2);
		Expressao condicao = new Maior(I2,I1);
		Expressao then = new ExpressaoSoma(I1,I1);
		Expressao other = new Subtracao(I1,I1);
		Expressao ifThen = new IfThenElse(condicao,then,other);
		TamanhoDasExpressoes t = new TamanhoDasExpressoes();
		ifThen.aceitar(t);
		Assert.assertEquals(10,t.getTamanho());
	}
}
