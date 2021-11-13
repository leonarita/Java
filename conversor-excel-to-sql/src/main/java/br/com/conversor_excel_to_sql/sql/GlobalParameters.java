package br.com.conversor_excel_to_sql.sql;

import java.util.Objects;

public class GlobalParameters {
	
	public static String getter(String value) {
		if(Objects.isNull(value))
			return "";
		if(value.startsWith("get"))
			return value;
		return "get" + value.substring(0, 1).toUpperCase() + value.substring(1);
	}

}
