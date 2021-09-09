package aula17.exercicio2;

public class Caso3 {
	
	// EXTRAIR CLASSE
	
	public class Aluno {
		private String _nome;
		private String _matricula;
		private String _CPF;
		
		public String nomeAluno() {
			return _nome;
		}

		public String get_nome() {
			return _nome;
		}

		public String get_matricula() {
			return _matricula;
		}

		public String get_CPF() {
			return _CPF;
		}
		
	}
	
	public class Telefone {
		
		private String _DDD;
		private String _Celular;
		
		public String lerNumeroCelular() {
			return "(" + _DDD + ") " + _Celular;
		}
	}
}
