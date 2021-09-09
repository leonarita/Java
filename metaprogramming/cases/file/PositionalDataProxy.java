package file;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import file.utils.Position;

public class PositionalDataProxy implements InvocationHandler {
	
	private Object[] data;
	private List<Method> methods;
	
	public PositionalDataProxy(Object[] data) {
		this.data = data;
		
		methods = Arrays.asList(PositionalData.class.getMethods());
		methods.sort((e1, e2) -> e1.getAnnotation(Position.class).start() - e2.getAnnotation(Position.class).start());
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		for(int i=0; i<methods.size(); i++) {
			if(method.equals(methods.get(i))) {
				return convertData(method.getReturnType(), data[i]);
			}
		}
		
		return method.invoke(proxy, args);
	}
	
	private Object convertData(Class<?> returnType, Object value) {
		
		if(returnType.isAssignableFrom(BigDecimal.class))
			return BigDecimal.valueOf(Double.valueOf(value.toString()));
		if(returnType.isAssignableFrom(Double.class))
			return Double.parseDouble(value.toString());
		
		return value;
	}

}
