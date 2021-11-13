package br.com.conversor_excel_to_sql.engine;

import java.lang.reflect.Proxy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import br.com.conversor_excel_to_sql.proxy.EntityProxy;

public class ExtractorExcelData<T> {
	
	private Class<T> clazz;
	private final DataFormatter dataFormatter = new DataFormatter();
	
	private ExtractorExcelData(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> ExtractorExcelData<T> of(Class<T> clazz) {
		return new ExtractorExcelData<T>(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public T extract(Row row) {
		return (T) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), 
				new Class[]{clazz}, 
				new EntityProxy(clazz, toArray(row))
		);
	}
	
	private Object[] toArray(Row row) {
		Object[] data = new Object[clazz.getMethods().length];

		for(Cell cell: row)
			data[(cell.getColumnIndex())] = dataFormatter.formatCellValue(cell);
		return data;
	}

}
