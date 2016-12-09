package br.unb.poo.mh;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

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
			 
			 evaluate(exp);
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
		
		//ArrayList que contera todas as linhas do arquivo
		//ArrayList<String> codigo = new ArrayList<String>();
		 
		File arq = new File(nome_file);
		if (arq.exists()){
			BufferedReader reader = new BufferedReader(new FileReader(nome_file));
			String line;
			 
			while ((line = reader.readLine()) != null){
			   
				System.out.println(line);
				evaluate(line);
				//codigo.add(line);
			}
			
			reader.close();
		}
		else {
			System.out.println("Arquivo n�o existe!");
		}
	}


	/*Metodo abaixo corresponde ao comando eval(...)
	 *
	 *Comando eval() funciona apenas com valores inteiros,ou seja, nao funciona 
	 * com float e nem com boolan. O comando segue a sintaxe eval(2+2+2) por 
	 * exemplo, que efetua a soma 2+2+2. Tal comando aceita todas as operacoes 
	 * feitas(ExpressaoSoma, Subtracao, Divisao ...) desde que respeitadas as suas 
	 * limitacoes. Por enquanto, so sao aceitos valores de 1 digito.
	 * 
	 * Obs.: eval() aceita parentesis dentro de sua declaracao, por exemplo:
	 * eval(2+2+(8*8)) seria uma operacao aceita pelo comando.
	 */
	private static void evaluate(String exp) { 
		
		try {
			Stack<Character> pilha = new Stack<Character>();
			
			char elementos[] = exp.toCharArray();
		
			/******************Validacao da expressao inserida*******************/
			
			
				for(int i = 0; i < exp.length(); i++){
					
					if(elementos[i] == '('){
						
						pilha.push(elementos[i]);
						
					}
					else if(elementos[i] == ')'){
						
						if(pilha.empty() == true){
							//System.out.println("entrou");
							System.out.println("Expressão inválida");
							break;
						}
						else{
							
							pilha.pop();
						}
					}
					else{} 
				}
			

			/*****************************FIM*************************************/
			
			
			if(pilha.empty() == false){	//Caso a expressao seja invalida
			
				System.out.println("Expressão inválida");
			}
			else{	//Caso a expressao seja valida
				
				ArrayList<Character> exp_saida = new ArrayList<Character>();
				Stack<Character> infixPosfix = new Stack<Character>();
				
				
			/******************Forma Infixa Para Posfixa**************************/	
				
				for(int i = 0; i < exp.length(); i++){
					
					if(elementos[i] != '+' && elementos[i] != '-' && 
					   elementos[i] != '/' && elementos[i] != '*' &&
					   elementos[i] != '(' && elementos[i] != ')'){
						
						exp_saida.add(elementos[i]);
					}
					else{	//Ao encontrar um operador
						
						char topo = ' '; //topo da pilha
						
						if(elementos[i] == '+'){
							
							if(infixPosfix.isEmpty() == false){
								
								topo = infixPosfix.pop();
							}
							while(infixPosfix.isEmpty() == false && 
								 (topo == '+' || topo == '-' ||
								  topo == '*' || topo == '/')){
								
								exp_saida.add(topo);
								topo = infixPosfix.pop();
							}
							
							infixPosfix.push(topo);
							infixPosfix.push(elementos[i]);
							
						}
						else if(elementos[i] == '-'){
							
							if(infixPosfix.isEmpty() == false){
								
								topo = infixPosfix.pop();
							}
							while(infixPosfix.isEmpty() == false && 
								 (topo == '+' || topo == '-' ||
								  topo == '*' || topo == '/')){
								
								exp_saida.add(topo);
								topo = infixPosfix.pop();
							}
							
							infixPosfix.push(topo);
							infixPosfix.push(elementos[i]);
							
						}
						else if(elementos[i] == '/'){
							
							if(infixPosfix.isEmpty() == false){
								
								topo = infixPosfix.pop();
							}
							while(infixPosfix.isEmpty() == false &&
								 (topo == '*' || topo == '/')){
								
								exp_saida.add(topo);
								topo = infixPosfix.pop();
							}
							
							infixPosfix.push(topo);
							infixPosfix.push(elementos[i]);
							
						}
						else if(elementos[i] == '*'){
							
							if(infixPosfix.isEmpty() == false){
								
								topo = infixPosfix.pop();
							}
							while(infixPosfix.isEmpty() == false &&
								 (topo == '*' || topo == '/')){
								
								exp_saida.add(topo);
								topo = infixPosfix.pop();
							}
							
							infixPosfix.push(topo);
							infixPosfix.push(elementos[i]);
							
						}
						else if(elementos[i] == '('){
							
							infixPosfix.push(elementos[i]);
						}
						else if(elementos[i] == ')'){
							
							topo = infixPosfix.pop();
							while(topo != '('){
								
								exp_saida.add(topo);
								topo = infixPosfix.pop();
							}
						}
						
						
					}
					
				}
				
				while(infixPosfix.isEmpty() == false){ //Esvaziando o restando da pilha
					
					exp_saida.add(infixPosfix.pop());
				}
				
			/**********************FIM********************************************/	
				
				
			/***********************Avaliacao da expressao************************/	
			
				Stack<ValorInteiro> avaliacao = new Stack<ValorInteiro>();
				
				for(int i = 0; i < exp_saida.size(); i++){

					if(exp_saida.get(i) != '+' && exp_saida.get(i) != '-' &&
					   exp_saida.get(i) != '*' && exp_saida.get(i) != '/'){
						
						avaliacao.push(new ValorInteiro((int)exp_saida.get(i) - 48));
					}
					else{ //Caso seja operador 
						
						ValorInteiro v1 = avaliacao.pop();
						ValorInteiro v2 = avaliacao.pop();
						
						if(exp_saida.get(i) == '+'){ 
							
							ExpressaoSoma soma = new ExpressaoSoma(v1,v2);
							avaliacao.push((ValorInteiro)soma.avaliar());
						}
						else if(exp_saida.get(i) == '-'){
							
							Subtracao sub = new Subtracao(v1,v2);
							avaliacao.push((ValorInteiro)sub.avaliar());
						}
						else if(exp_saida.get(i) == '*'){
							
							Multiplicacao mul = new Multiplicacao(v1,v2);
							avaliacao.push((ValorInteiro)mul.avaliar());
						}
						else if(exp_saida.get(i) == '/'){
							
							Divisao div = new Divisao(v2,v1);
							avaliacao.push((ValorInteiro)div.avaliar());
						}
						
					} 
					
				}
				
				
				avaliacao.pop();
				System.out.println("Resultado: "+avaliacao.pop().getValor());
				
			/*******************************FIM***********************************/
			
			}  
		} catch (Exception e) {
			System.out.println("Expressão inválida");
		}
		
	}
}
