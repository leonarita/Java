package br.com.conversor_excel_to_sql.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import br.com.conversor_excel_to_sql.utils.Column;

public class EntityProxy implements InvocationHandler {

	private Object[] data;
	private List<Method> methods;
	private Long minus;
	
	public EntityProxy(Class<?> clazz, Object[] data) {
		this.data = data;
		
		methods = Arrays.asList(clazz.getMethods());
		methods.sort((e1, e2) -> e1.getAnnotation(Column.class).columnExcel() - e2.getAnnotation(Column.class).columnExcel());
		minus = methods.stream().filter(e -> e.getAnnotation(Column.class).columnExcel() == 0).count();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		for(int i=0; i<methods.size(); i++) {
			if(method.equals(methods.get(i))) {
				return convertData(method.getReturnType(), data[i - minus.intValue()]);
			}
		}
		
		return method.invoke(proxy, args);
	}
	
	private Object convertData(Class<?> returnType, Object value) {
		if(Objects.isNull(value))
			return null;

		if(returnType.isAssignableFrom(Long.class))
			return Long.parseLong(value.toString());
		if(returnType.isAssignableFrom(Float.class))
			return Float.parseFloat(value.toString());
		if(returnType.isAssignableFrom(Integer.class))
			return Integer.parseInt(value.toString());
		if(returnType.isAssignableFrom(Double.class))
			return Double.parseDouble(value.toString());
		if(returnType.isAssignableFrom(Boolean.class))
			return Boolean.parseBoolean(value.toString());
		if(returnType.isAssignableFrom(BigDecimal.class))
			return BigDecimal.valueOf(Double.valueOf(value.toString()));
		
		return value;
	}
}
