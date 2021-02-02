package testes.annotations.v1;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target(FIELD)
public @interface Length {
	
	int min();
	int max();
	
	String[] rules() default {""};
	
	Class<?> returnVoid() default void.class;

}
