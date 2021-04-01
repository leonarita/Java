package testes.annotations.v1;

import java.time.LocalDate;
import java.time.Month;

import testes.annotations.ValidatorsField;

public class Main {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Doriana", "421.982.848-83", LocalDate.of(1995, Month.MARCH, 14));
		
		System.out.println("Nome "  + (ValidatorsField.validadorName(usuario) ? "" : "in") + "válido");
		System.out.println("Idade " +     (ValidatorsField.validador(usuario) ? "" : "in") + "válida");
		System.out.println("CPF "   +   (ValidatorsField.validateCPF(usuario) ? "" : "in") + "válido");
	}
	
}
