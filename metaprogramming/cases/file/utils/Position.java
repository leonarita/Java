package file.utils;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RUNTIME)
@Target({ElementType.METHOD})
public @interface Position {
	
	int start();
	int end();
	int length();
	
}
