package metaprogramming.cap3.ex1;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Metadado {
	
	String nome();
	
	int numero();

}
