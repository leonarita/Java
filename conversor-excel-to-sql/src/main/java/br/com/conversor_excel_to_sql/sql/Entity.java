package br.com.conversor_excel_to_sql.sql;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import br.com.conversor_excel_to_sql.utils.ParamsComposedInsert;

public class Entity {

	public static <T> String getField(T obj, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return Sql.formatField(invokeRequiringNonNull(obj, method), method.getReturnType());
	}
	
	public static <T> String getField(Class<T> clazz, T obj, ParamsComposedInsert params) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return formatField(obj, clazz.getMethod(GlobalParameters.getter(params.referencedField())));
	}
	
	private static <T> String formatField(T obj, Method methodComposed) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return Sql.formatField(invokeRequiringNonNull(obj, methodComposed), methodComposed.getReturnType());
	}
	
	private static <T> String invokeRequiringNonNull(T obj, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return Objects.requireNonNullElse(method.invoke(obj), Sql.empty(method.getReturnType())).toString();
	}
}
