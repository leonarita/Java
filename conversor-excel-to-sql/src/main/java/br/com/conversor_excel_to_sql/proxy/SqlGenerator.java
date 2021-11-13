package br.com.conversor_excel_to_sql.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import br.com.conversor_excel_to_sql.sql.Entity;
import br.com.conversor_excel_to_sql.sql.Sql;
import br.com.conversor_excel_to_sql.utils.Column;
import br.com.conversor_excel_to_sql.utils.ParamsComposedInsert;

public class SqlGenerator {
	
	public static <T> String values(Class<T> clazz, T obj) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String resp = "";
	
		for(Method method : clazz.getMethods()) {
			String value = factoryValueQuery(clazz, obj, method);
			
			if(Objects.nonNull(value))
				resp = resp.concat(value).concat(", ");
		}
		return resp.substring(0, resp.length() - 2);
	}
	
	public static <T> String fields(Class<T> clazz) {
		String resp = "";
		
		for(Method method : clazz.getMethods()) {
			Column column = method.getAnnotation(Column.class);
			if(column.insertable())
				resp = resp.concat(column.name()).concat(", ");
		}
		
		return resp.substring(0, resp.length() - 2);
	}

	private static <T> String factoryValueQuery(Class<T> clazz, T obj, Method method) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Column column = method.getAnnotation(Column.class);
		
		if(!column.insertable())
			return null;
		
		if(method.getAnnotation(Column.class).columnExcel() != 0) 
			return Entity.getField(obj, method);
		return buildSelect(clazz, obj, method);
	}
	
	private static <T> String buildSelect(Class<T> clazz, T obj, Method method) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Column column = method.getAnnotation(Column.class);
		String select = column.composedInsert();
		
		for(ParamsComposedInsert params : column.paramsComposedInsert()) {
			select = select.replace(Sql.toVariable(params.id()), Entity.getField(clazz, obj, params));
		}

		return Sql.isolateQuery(select);
	}
}
