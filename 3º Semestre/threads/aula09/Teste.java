package aula09;

import aula05.ThreadSemafaro;

public class Teste {
	
	public static void main(String[] args) {
		
		ThreadSemafaro semafaro = new ThreadSemafaro();
		
		for (int i=0; i<10; i++){
			System.out.println(semafaro.getCor());
			semafaro.esperaCorMudar();
		}
		
		semafaro.desligarSemafaro();
	}

}
