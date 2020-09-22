package atividade.designPattern.facade;

import java.time.LocalDateTime;

import atividade.designPattern.iterator.MovimentoIterator;
import atividade.modelo.ContaComum;
import atividade.modelo.Movimento;
import atividade.modelo.repositorio.MovimentoDAO;

public class ContaComumFacade {
	
	public static boolean verificarSeMovimentoEstaEntreDatas(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim, Movimento mv) {
		return dateTimeInicio != null && dateTimeFim != null
				&& mv.getDataHoraMovimento().toLocalDate().isAfter(dateTimeInicio.toLocalDate())
				&& mv.getDataHoraMovimento().toLocalDate().isBefore(dateTimeFim.toLocalDate());
	}
	
	public static boolean verificarSeMovimentoFoiNoDia(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim, Movimento mv) {
		return dateTimeInicio != null && dateTimeFim == null && mv.getDataHoraMovimento().toLocalDate().equals(dateTimeInicio.toLocalDate());
	}
	
	public static boolean verificarSeMovimentoEstaNoPeriodo(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim, Movimento mv) {
		return verificarSeMovimentoEstaEntreDatas(dateTimeInicio, dateTimeFim, mv) || verificarSeMovimentoFoiNoDia(dateTimeInicio, dateTimeFim, mv);
	}

	public static void emitirExtrato(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim, ContaComum cc) {
		
		System.out.println("\n\nConta recuperada: numero = " + cc.getNumeroConta() + ", saldo = "
			+ cc.emitirSaldo());
			
		MovimentoDAO mvDao = new MovimentoDAO();
		cc.setMovimentosConta(mvDao.obterMovimentosPorNumeroConta(cc.getNumeroConta()));
		mvDao = null;
		
		MovimentoIterator iterator = new MovimentoIterator(cc.getMovimentosConta());
		
		if (dateTimeInicio == null && dateTimeFim == null) {
			while (iterator.hasNext()) {
				
				Movimento mv = (Movimento) iterator.next();
					
				System.out.println("MV ID " + mv.getIdMovimento() + ", tipo = " + 
					mv.getTipoMovimento() + ", valor = " + mv.getValorMovimento());
				
			}
		}
		
		else {
			while (iterator.hasNext()) {
				
				Movimento mv = (Movimento) iterator.next();
					
				if (verificarSeMovimentoEstaNoPeriodo(dateTimeInicio, dateTimeFim, mv))	{
					
					System.out.println("MV ID " + mv.getIdMovimento() + ", tipo = " + 
						mv.getTipoMovimento() + ", valor = " + mv.getValorMovimento());
				}
			}
		}
	}
}
