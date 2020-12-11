package aula02.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import aula02.models.abstractclasses.Pessoa;

public class UsuarioComum extends Pessoa {
	
	private Date dataCadastro;
	private int idUsuario;
	private List<Emprestimo> emprestimos;
	private List<Reserva> reservas;
	
	public UsuarioComum() {
		this.reservas = new ArrayList<Reserva>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	public UsuarioComum(long cpf, String nome, String sobrenome, String login, String email, String senha, Date nascimento, Date dataCadastro, int idUsuario, List<Emprestimo> emprestimos, List<Reserva> reservas) {
		super(cpf, nome, sobrenome, login, email, senha, nascimento);
		this.dataCadastro = dataCadastro;
		this.idUsuario = idUsuario;
		
		if(Objects.nonNull(reservas)) {
			this.reservas = reservas;
		}
		else {
			this.reservas = new ArrayList<Reserva>();
		}

		if(Objects.nonNull(emprestimos)) {
			this.emprestimos = emprestimos;
		}
		else {
			this.emprestimos = new ArrayList<Emprestimo>();
		}

	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
