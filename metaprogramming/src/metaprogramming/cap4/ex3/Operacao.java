package metaprogramming.cap4.ex3;

public interface Operacao<E> {
	@InvalidaCache public void mudar(E obj);
	@Cache public E somar(E obj);
	@Cache public E multiplicar(E obj);

}
