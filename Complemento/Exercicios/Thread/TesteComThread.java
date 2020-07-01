package Thread;

public class TesteComThread {

    public int variavelCompartilhada = 0;

    public static void main(String [] args) {

        new TesteComThread().executar();

    }

    public void executar() {
    	
        Thread segundoThread = new ThreadQueDecrementaValorDaVariavel(this);
        segundoThread.start();

        while(true) {
            variavelCompartilhada++;
            System.out.println("Variável vale: " + variavelCompartilhada);
            dormir(1500);
        }
    }

    public void dormir(int milissegundos) {
    	
        try {
            // System.out.println(Thread.currentThread().getName() + " irá dormir por " + milissegundos + " milissegundos.");
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            // Não precisa fazer nada
        }
    }
}