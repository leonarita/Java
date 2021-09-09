package file;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CsvFormatProxy implements InvocationHandler {
	
	private Object[] data;
	
	public CsvFormatProxy(Object[] data) {
		this.data = data;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		switch(method.getName()) {
			case "getName": 
				return data[0];
			case "getNota":
				return Double.valueOf(data[1].toString().trim());
			default:
				return method.invoke(proxy, args);
		}
	}

}
