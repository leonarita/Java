package br.com.conversor_excel_to_sql.sql;

import java.util.Objects;

public class Sql {
	
	public static String formatInsert(String table, String fields, String values) {
		return SqlConstants.INSERT
				.replace("table", table)
				.replace("fields", fields)
				.replace("values", values);
	}

	public static String formatField(String value, Class<?> returnType) {
		if(returnType.getSimpleName().equals("String")) {
			if(Objects.isNull(value))
				return "";
			return "'" + value + "'";			
		}
		return value;
	}
	
	public static String empty(Class<?> returnType) {
		if(returnType.getSimpleName().equals("String"))
			return "";
		return "null";
	}
	
	public static String toVariable(String value) {
		if(Objects.isNull(value))
			return "";
		return ":" + value;
	}
	
	public static String isolateQuery(String value) {
		if(Objects.isNull(value))
			return "";
		return "(" + value + ")";
	}

}
