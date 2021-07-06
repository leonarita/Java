package casadocodigo.referencia;

public class Overview {
	
	// MEMÓRIA = PILHA + HEAP
		// Pilha: Armazena variáveis locais e parâmetros de um método
		// Heap : Armazena objetos
	
	// classes internas definidas dentro de métodos não podem acessar as variáveis locais desses métodos,
	// a menos que estas sejam especificadas como final, visto que o tempo de vida da instância da classe interna pode 
	// exceder ao tempo de execução do método da classe externa
	
	// Garbage Collector (GC)
	// -> Executado ao tentar criar um objeto e não existe espaço suficiente no heap
	// -> Quando isso ocorre, a thread corrente é bloqueada e é realizada uma coleta de lixo
	// -> Se não liberar memória suficiente, cria-se o objeto falha com o lançamento de um OutOfMemoryError, terminando a thread corrente
	
}
