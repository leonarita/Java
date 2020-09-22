package atividade.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import atividade.designPattern.facade.MovimentoFacade;
import atividade.modelo.enumeration.TipoMovimentoEnum;

public class Movimento {
	
	private int idMovimento;
	private TipoMovimentoEnum tipoMovimento;
	private LocalDateTime dataHoraMovimento;
	private BigDecimal valorMovimento;
	private ContaComum contaMovimento;
	
	public int getIdMovimento() {
		return idMovimento;
	}
	
	public void setIdMovimento(int id) {
		this.idMovimento = id;
	}
	
	public int getTipoMovimento() {
		return tipoMovimento.getTipoMovimento();
	}
	
	public void setTipoMovimento(int tipoMovimento) {
		// Adicionar através do 'Construtor' para não dar NullPointer
		if(tipoMovimento == 1)
			this.tipoMovimento = TipoMovimentoEnum.DEPOSITO;
		else if(tipoMovimento == 2)
			this.tipoMovimento = TipoMovimentoEnum.SAQUE;
	}
	
	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}
	
	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public BigDecimal getValorMovimento() {
		return valorMovimento;
	}
	
	public void setValorMovimento(BigDecimal valorMovimento) {
		this.valorMovimento = valorMovimento;
	}
	
	public ContaComum getContaMovimento() {
		return contaMovimento;
	}
	
	public void setContaMovimento(ContaComum contaMovimento) {
		this.contaMovimento = contaMovimento;
	}
	
	
	@Override
	public String toString() {
		return "Movimento [idMovimento=" + idMovimento + ", tipoMovimento=" + tipoMovimento + ", dataHoraMovimento="
				+ dataHoraMovimento + ", valorMovimento=" + valorMovimento + ", contaMovimento=" + contaMovimento + "]";
	}

	public int registrarMovimento(int tipoMovimento, BigDecimal valorMovimento) {
		
		return MovimentoFacade.registrarMovimento(this, tipoMovimento, valorMovimento);
	}
}