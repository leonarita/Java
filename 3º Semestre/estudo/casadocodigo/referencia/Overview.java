package casadocodigo.referencia;

public class Overview {
	
	// MEM�RIA = PILHA + HEAP
		// Pilha: Armazena vari�veis locais e par�metros de um m�todo
		// Heap : Armazena objetos
	
	// classes internas definidas dentro de m�todos n�o podem acessar as vari�veis locais desses m�todos,
	// a menos que estas sejam especificadas como final, visto que o tempo de vida da inst�ncia da classe interna pode 
	// exceder ao tempo de execu��o do m�todo da classe externa
	
	// Garbage Collector (GC)
	// -> Executado ao tentar criar um objeto e n�o existe espa�o suficiente no heap
	// -> Quando isso ocorre, a thread corrente � bloqueada e � realizada uma coleta de lixo
	// -> Se n�o liberar mem�ria suficiente, cria-se o objeto falha com o lan�amento de um OutOfMemoryError, terminando a thread corrente
	
}
