package atividade.modelo;

import java.time.LocalDateTime;

import atividade.modelo.designPattern.facade.MovimentoFacade;

public class Movimento {
	
	private int idMovimento;
	private int tipoMovimento;
	private LocalDateTime dataHoraMovimento;
	private double valorMovimento;
	private ContaComum contaMovimento;
	
	public int getIdMovimento() {
		return idMovimento;
	}
	
	public void setIdMovimento(int id) {
		this.idMovimento = id;
	}
	
	public int getTipoMovimento() {
		return tipoMovimento;
	}
	
	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}
	
	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public double getValorMovimento() {
		return valorMovimento;
	}
	
	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}
	
	public ContaComum getContaMovimento() {
		return contaMovimento;
	}
	
	public void setContaMovimento(ContaComum contaMovimento) {
		this.contaMovimento = contaMovimento;
	}
	
	public int registrarMovimento(int tipoMovimento, double valorMovimento) {
		
		return MovimentoFacade.registrarMovimento(this, tipoMovimento, valorMovimento);
	}
}