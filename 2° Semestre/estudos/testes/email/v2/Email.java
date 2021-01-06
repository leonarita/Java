package testes.email.v2;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class Email {
	
	//o tratamento de excessoes foi simplificado (throws MessagingException) para facilitar o entendimento do exemplo
	
	public static void main(String[] args) throws MessagingException {
  
		//objeto para definicao das propriedades de configuracao do provider
		Properties props = new Properties();
  
		//o valor "smtp.host.com.br" deve ser alterado para o seu servidor SMTP
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		SmtpAuthenticator auth = new SmtpAuthenticator();
  
		//obtendo um Session com a configuração do servidor SMTP definida em props
		Session session = Session.getDefaultInstance(props, auth);
  
		//criando a mensagem
		MimeMessage message = new MimeMessage(session);

		//substituir pelos e-mails desejados
		Address from = new InternetAddress("");
		Address to = new InternetAddress("a@gmail.com");
		
		//configurando o remetente e o destinatario
		message.setFrom(from);
		message.addRecipient(RecipientType.TO, to);
		
		//configurando a data de envio,  o assunto e o texto da mensagem
		message.setSentDate(new Date());
		message.setSubject("EMAIL");
		  
		// conteudo html que sera atribuido a mensagem
		String htmlMessage = "<b>Mensagem Sigilosa</b><br><br>Caro usuário, seja bem-vindo à plataforma. \n\n\tUsuário: TESTE \n\tSenha: 123456";
		
		//criando a Multipart
		Multipart multipart = new MimeMultipart();
		
		//criando a primeira parte da mensagem
		MimeBodyPart attachment0 = new MimeBodyPart();
		
		//configurando o htmlMessage com o mime type
		attachment0.setContent(htmlMessage,"text/html; charset=UTF-8");
		
		//adicionando na multipart
		multipart.addBodyPart(attachment0);
		  
		//arquivo que será anexado
		String pathname = "";
		File file = new File(pathname);
		
		String pathname2 = "";
		File file2 = new File(pathname2);
		
		//criando a segunda parte da mensagem
		MimeBodyPart attachment1 = new MimeBodyPart();  
		MimeBodyPart attachment2 = new MimeBodyPart();  
		
		//configurando o DataHandler para o arquivo desejado a leitura dos bytes, descoberta e configuracao do tipo do arquivo serão resolvidos pelo JAF (DataHandler e FileDataSource)
		attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
		attachment2.setDataHandler(new DataHandler(new FileDataSource(file2)));

		//configurando o nome do arquivo que pode ser diferente do arquivo original Ex: setFileName("outroNome.png")
		attachment1.setFileName(file.getName());
		attachment2.setFileName(file2.getName());
		
		//adicionando o anexo na multipart
		multipart.addBodyPart(attachment1);
		multipart.addBodyPart(attachment2);
		
		//adicionando a multipart como conteudo da mensagem 
		message.setContent(multipart);
		  
		while(true) {
			//enviando
			Transport.send(message);
			  
			System.out.println("E-mail enviado com sucesso!");
		}
	}
}