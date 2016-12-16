package br.unb.poo.mh;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import Sources.ExpressaoLexer;
import Sources.ExpressaoParser;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;

public class Interpreter {
	
	//Scanner scanner = new Scanner(System.in); 
	
	 public static void main(String args[]) throws IOException{
	
		while(true){
			String input = getInput();
			evalInput(input);
		}
	 }
	 
	private static String getInput() throws IOException{
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		//scanner.close(); 
		return input;
	}
	
	public static void evalInput(String input) throws IOException{
		if(input.startsWith("eval(") == true){ //Caso seja digitado eval(...)
			
			 String exp = "";
			 int indice = input.indexOf("(");
			 
			 
			 //Passa a expressao a ser computada para a String exp
			 for(int i = indice + 1; i < input.length() - 1; i++){
				 
				 exp = exp + input.charAt(i);
			 }
			 
			 // eval() criado manualmente
			 //evaluate(exp);
			 
			 //eval() criado a partir da gramática
			 eval(exp);
		     
		    }

		 else if(input.startsWith("loadFile(")){ //Caso seja digitado loadFile(...)
			 
			 String nome_file = "";
			 int indice = input.indexOf("(");
			 
			 
			 //Passa o nome do arquivo para a String nome_file
			 for(int i = indice + 1; i < input.length() - 1; i++){
				 
				 nome_file = nome_file + input.charAt(i);
			 }
			
			 processaArquivo(nome_file);
		 }
		 else{
			 
			 System.out.println("Comando Incorreto!");
		 }
	}

	 
	private static void processaArquivo(String nome_file) throws IOException {
		
		
		File arq = new File(nome_file);
		if (arq.exists()){
			BufferedReader reader = new BufferedReader(new FileReader(nome_file));
			String line;
			 
			while ((line = reader.readLine()) != null){
			   
				System.out.println(line);
				eval(line);
			}
			
			reader.close();
		}
		else {
			System.out.println("Arquivo não existe!");
		}
	}


	private static void eval(String exp) {
		
		ExpressaoLexer lexer = new ExpressaoLexer(new ANTLRInputStream(exp));
	    ExpressaoParser parser = new ExpressaoParser(new CommonTokenStream(lexer));
	    ParseTree tree = parser.start();
	    Double answer = new ExprVisitor().visit(tree);
	    System.out.printf("Resultado = %s\n", answer);
	}
	
	
}
