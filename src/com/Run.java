package com;

public class Run {
	public PruebaDOS pr2;
	
	static
	{
		System.out.println("soy un bloque estatico");
	}
	public static void main(String[] args){
		Run run = new Run();
		run.init();
	}
	
	public void init(){
	
		
		pr2 = new PruebaDOS("Soy un dato de una clase instanciadad...");
		
		System.out.println(pr2.dato);
	}
	
	{
		System.out.println(Prueba.dato);
	}
}
