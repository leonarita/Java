package modelo.enumeration;

import javax.persistence.AttributeConverter;

public class AbstractEnumConverter implements AttributeConverter<TipoMovimentoEnum, Integer> {
	
	
	public AbstractEnumConverter() {
	}

	@Override
	public Integer convertToDatabaseColumn(TipoMovimentoEnum arg0) {
		return arg0.getTipoMovimento();
	}

	@Override
	public TipoMovimentoEnum convertToEntityAttribute(Integer arg0) {
		if(arg0 == 1)
			return TipoMovimentoEnum.DEPOSITO;
		else
			return TipoMovimentoEnum.SAQUE;
	}

	
	


}
