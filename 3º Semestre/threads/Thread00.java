

public class Thread00 {
	
	/*
	 * 
	 * I) COMO CRIAR THREAD
	 *   1) extends Thread
	 *   2) implements Runnable
	 * 
	 * 
	 * II) M�TODOS THREAD
	 *   1) start       : inicia m�todo run
	 *   2) run         : executa tarefa da thread
	 *   3) sleep       : thread dorme por milisegundos
	 *   4) isAlive     : verifica se thread est� viva
	 *   5) join        : espera thread morrer ou determinado per�odo de tempo para executar outra thread
	 *   6) setPriority : coloca prioridade de execu��o de threads
	 * 
	 * 
	 * 
	 * III) M�TODOS EXTRAS DE THREADS (REMOVIDOS NO JAVA 2 POR DEADLOCKS E EXCE��ES)
	 *   1) resume  : suspende temporarimente a execu��o da thread
	 *   2) suspend : despausa a execu��o da thread
	 *   3) stop    : termina execu��o da thread
	 *   
	 *   
	 * IV) SYNCRONIZED
	 *   1) Definic�o : Recurso acessado uma thread de cada vez
	 *   2) M�todos:
	 *     - wait        : bloqueia temporariamente a execu��o de uma thread, ficando em modo de espera at� que seja notificada
	 *     - notify      : notifica thread que estava esperando a voltar a executar
	 *     - notifyAll   : notifica todas as thread, e a com maior prioridade ganha acesso ao objeto
	 *   
	 *   
	 * III) OBSERVA��ES
	 * 	 1) Runnable n�o possui m�todo start
	 *   2) syncronized
	 *   3) Deadlocks
	 * 
	 */

}
