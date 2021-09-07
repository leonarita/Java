package metaprogramming.cap1.ex4;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface NomePropriedade {

	String value();
}
