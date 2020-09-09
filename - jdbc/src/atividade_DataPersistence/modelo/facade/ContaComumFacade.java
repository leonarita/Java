package atividade_DataPersistence.modelo.facade;

import java.time.LocalDateTime;

import atividade_DataPersistence.modelo.ContaComum;
import atividade_DataPersistence.modelo.Movimento;
import atividade_DataPersistence.modelo.iterator.MovimentoIterator;
import atividade_DataPersistence.modelo.repositorio.MovimentoDAO;

public class ContaComumFacade {

	public static void emitirExtrato(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim, ContaComum cc) {
		
		System.out.println("\n\nConta recuperada: numero = " + cc.getNumeroConta() + ", saldo = "
			+ cc.emitirSaldo());
			
		MovimentoDAO mvDao = new MovimentoDAO();
		cc.setMovimentosConta(mvDao.obterMovimentosPorNumeroConta(cc.getNumeroConta()));
		mvDao = null;
		
		MovimentoIterator iterator = new MovimentoIterator(cc.getMovimentosConta());
						
		while (iterator.hasNext()) {
			
			Movimento mv = (Movimento) iterator.next();
				
			if (
				(dateTimeInicio != null && dateTimeFim != null
				&& mv.getDataHoraMovimento().toLocalDate().isAfter(dateTimeInicio.toLocalDate())
				&& mv.getDataHoraMovimento().toLocalDate().isBefore(dateTimeFim.toLocalDate())) 
						
				|| 

				(dateTimeInicio != null && dateTimeFim == null && 
				mv.getDataHoraMovimento().toLocalDate().equals(dateTimeInicio.toLocalDate()))
						
				||
				
				(dateTimeInicio == null && dateTimeFim == null)
			)
				
			System.out.println("MV ID " + mv.getIdMovimento() + ", tipo = " + 
				mv.getTipoMovimento() + ", valor = " + mv.getValorMovimento());
			
		}
	}
}
