package aula17.exercicio2;

public class Caso4 {
	
	// SUBSTITUIR VETOR POR OBJETO
	
	public String armazenarDadosLogin(String login, String senha) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		String result = usuario.getLogin() + " " + usuario.getSenha();
		return result;
	}
	
	public static class Usuario {
		private String login;
		private String senha;
		
		public String getLogin() {
			return login;
		}
		
		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
	}

}
