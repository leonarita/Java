package Thread;

class ThreadQueDecrementaValorDaVariavel extends Thread {

    private TesteComThread teste;

    public ThreadQueDecrementaValorDaVariavel(TesteComThread teste) {
        this.teste = teste;
    }

    @Override
    public void run() {
        while(true) {
            teste.variavelCompartilhada--;
            System.out.println("Vari�vel vale: " + teste.variavelCompartilhada);
            teste.dormir(1000);
        }
    }
}