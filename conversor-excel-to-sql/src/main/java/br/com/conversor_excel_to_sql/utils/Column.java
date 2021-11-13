package br.com.conversor_excel_to_sql.utils;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import br.com.conversor_excel_to_sql.enumeration.CustomField;

@Documented
@Inherited
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD,})
public @interface Column {
	
	String name();
	
	boolean insertable() default false;
		
	int columnExcel() default 0;
	
	String composedInsert() default "";
	
	ParamsComposedInsert[] paramsComposedInsert() default {};
	
	CustomField customField() default CustomField.NONE;
	
	Class<?> returnType() default String.class;

}
