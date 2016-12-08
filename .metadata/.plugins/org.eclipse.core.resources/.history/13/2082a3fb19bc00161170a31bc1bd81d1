package br.unb.poo.mh;
 
import java.util.ArrayList;

public class ValorLista<T> extends ValorParametrizado<T>{

	ArrayList<T> background = new ArrayList<T>();
	
	public ValorLista(T valor) {
		super(valor);
		
		background.add(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Lista;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	public void adicionar(T valor){ 
		
		background.add(valor);
	}
	
	public void retirar(ValorInteiro indice){
		
		background.remove(indice.getValor());
	}
	
	public T recuperar(ValorInteiro indice){ 
		
		if(background.size() <= indice.getValor()){
			
			return null;
			//return (T) Tipo.Error;
		}
		else{
			
			return background.get(indice.getValor());
		}
	}
	
	public ValorInteiro tam(){
		
		return new ValorInteiro(background.size());
	}

}
