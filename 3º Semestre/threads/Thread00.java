

public class Thread00 {
	
	/*
	 * 
	 * I) COMO CRIAR THREAD
	 *   1) extends Thread
	 *   2) implements Runnable
	 * 
	 * 
	 * II) MÉTODOS THREAD
	 *   1) start       : inicia método run
	 *   2) run         : executa tarefa da thread
	 *   3) sleep       : thread dorme por milisegundos
	 *   4) isAlive     : verifica se thread está viva
	 *   5) join        : espera thread morrer ou determinado período de tempo para executar outra thread
	 *   6) setPriority : coloca prioridade de execução de threads
	 * 
	 * 
	 * 
	 * III) MÉTODOS EXTRAS DE THREADS (REMOVIDOS NO JAVA 2 POR DEADLOCKS E EXCEÇÕES)
	 *   1) resume  : suspende temporarimente a execução da thread
	 *   2) suspend : despausa a execução da thread
	 *   3) stop    : termina execução da thread
	 *   
	 *   
	 * IV) SYNCRONIZED
	 *   1) Definicão : Recurso acessado uma thread de cada vez
	 *   2) Métodos:
	 *     - wait        : bloqueia temporariamente a execução de uma thread, ficando em modo de espera até que seja notificada
	 *     - notify      : notifica thread que estava esperando a voltar a executar
	 *     - notifyAll   : notifica todas as thread, e a com maior prioridade ganha acesso ao objeto
	 *   
	 *   
	 * III) OBSERVAÇÕES
	 * 	 1) Runnable não possui método start
	 *   2) syncronized
	 *   3) Deadlocks
	 * 
	 */

}
