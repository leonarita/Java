package br.com.conversor_excel_to_sql.utils;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface Table {
	
	String name();
	
	boolean skipFirstLine() default false;

}
