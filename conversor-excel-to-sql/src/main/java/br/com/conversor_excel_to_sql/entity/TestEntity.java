package br.com.conversor_excel_to_sql.entity;

import br.com.conversor_excel_to_sql.utils.Column;
import br.com.conversor_excel_to_sql.utils.ParamsComposedInsert;
import br.com.conversor_excel_to_sql.utils.Table;

@Table(name = "tb_teste")
public interface TestEntity {
	
	@Column(name = "name", insertable = true, columnExcel = 1)
	String getName();
	
	@Column(name = "nameAny", columnExcel = 2)
	String getNameAny();
	
	@Column(name = "surnameAny", columnExcel = 3)
	String getSurnameAny();
	
	@Column(name = "any_id", insertable = true, composedInsert = "select id from tb_any where name = :nameAny and surname = :surnameAny", paramsComposedInsert = {
			@ParamsComposedInsert(id = "nameAny", referencedField = "nameAny"),
			@ParamsComposedInsert(id = "surnameAny", referencedField = "surnameAny")
	})
	Long getAnyId();
	
	@Column(name = "age", insertable = true, columnExcel = 5)
	Integer getAge();
	
	@Column(name = "cpf", insertable = true, columnExcel = 4)
	String getCpf();

}
