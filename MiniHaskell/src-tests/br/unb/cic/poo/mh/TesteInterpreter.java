package br.unb.cic.poo.mh;

import java.io.IOException;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import br.unb.poo.mh.Interpreter;

public class TesteInterpreter {
	
	@Test
	public void testeInterpreterArquivoExiste() throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("TestFile.txt"));
		buffWrite.append("eval(2+2)");
		buffWrite.close();
		String arg = "loadFile(TestFile.txt)";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterArquivoNExiste() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "loadFile(notTestFile.txt)";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterIvalido() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "NotACommand";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterSoma() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(2+2)";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterSubtracao() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(2-2)";
			Interpreter.evalInput(arg);
		
	}
	
	@Test
	public void testeInterpreterDivisao() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(8/2)";
			Interpreter.evalInput(arg);
		
	}
	
	@Test
	public void testeInterpreterMultiplicacao() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(2*3)";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterVazio() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval()";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterComplexo() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(2+(9/3)-(3*2))";
			Interpreter.evalInput(arg);
	}
	
	@Test
	public void testeInterpreterExpressaoInvalida() throws IOException{
		//Interpreter interpretador = new Interpreter();
		String arg = "eval(df-es)";
			Interpreter.evalInput(arg);
		arg = "eval(2+2)";
			Interpreter.evalInput(arg);
			
	}
	
}
