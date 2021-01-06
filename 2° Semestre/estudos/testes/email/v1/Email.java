package testes.email.v1;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Classe respons�vel por enviar E-mail.
 * @author Denner Dias
 */
public class Email implements Runnable {
    static final String REMETENTE_NOME = "";
    static final String REMETENTE_SENHA = "";
    private String assunto ;
    private String mensagem;
    private String destinatario;
    
    /**
     * 
     * @param assunto  Assunto para envio do E-mail.
     * @param mensagem  Mensagem qual vai ser enviado ao destinat�rio.
     * @param destinatario  E-mail do destinat�rio.
     */
    public Email(String assunto, String mensagem, String destinatario) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }
   
    /**
     * Fun��o para enviar o e-mail ao destinat�rio.
     */
    public void enviar (){
        SimpleEmail email = new SimpleEmail();
            email.setSSLOnConnect(true);
            email.setHostName("smtp.gmail.com");
            email.setSslSmtpPort("465");
       email.setAuthenticator(new DefaultAuthenticator(REMETENTE_NOME, REMETENTE_SENHA));
       try {
           email.setFrom(REMETENTE_NOME);

           email.setDebug(true);

           email.setSubject(this.assunto);
           email.setMsg(this.mensagem);
           email.addTo(this.destinatario);

           email.send();

       } catch (EmailException e) {
           e.printStackTrace();
       }
    }

	@Override
	public void run() {
		enviar();
	}
}