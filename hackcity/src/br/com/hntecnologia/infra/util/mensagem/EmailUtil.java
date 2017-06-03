package br.com.hntecnologia.infra.util.mensagem;

import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EmailUtil
{

	private static EmailUtil instancia;

	public static EmailUtil getInstancia ()
	{
		if (instancia == null)
		{
			instancia = new EmailUtil();
		}
		return instancia;
	}

	private static final String HOSTNAME = "smtp.gmail.com";

	private static final String USERNAME = "tonrenk@gmail.com";

	private static final String PASSWORD = "garrafa87";

	private static final String EMAILORIGEM = "tonrenk@gmail.com";

	@SuppressWarnings("deprecation")
	public static Email conectaEmail () throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName(HOSTNAME);
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME , PASSWORD));
		email.setTLS(true);
		email.setFrom(EMAILORIGEM);
		return email;
	}

	/*public void enviarChamado ( Chamado chamado ) throws EmailException
	{

		MensagemEmail mensagem = new MensagemEmail();
		mensagem.setNome("Suporte");
		mensagem.setAssunto("Nova Solicita��o no sistema de Chamados");
		mensagem.setEmail(EMAILORIGEM);
		StringBuilder txt = new StringBuilder();

		txt.append("T�tulo  : " + chamado.getTituloChamado());
		txt.append("\nDescri��o  : " + chamado.getDescricao());
		txt.append("\nData Abertura  : " + DateUtil.getDateFormat(new Date()));
		txt.append("\nData para Resolu��o : "
				+ DateUtil.getDateFormat(chamado.getDataPrazoChamado()));

		mensagem.setMensagem(txt.toString());

		EmailUtil.enviaEmail(mensagem);

	}*/

	public static void enviaEmail ( MensagemEmail mensagem )
			throws EmailException
	{
		Email email = new SimpleEmail();
		email = conectaEmail();
		email.setCharset("UTF-8");
		email.setFrom(mensagem.getEmail() , mensagem.getNome());
		email.setSubject(mensagem.getAssunto());
		email.setMsg(mensagem.getMensagem());
		email.addTo("henriqueamorim83@gmail.com");
		email.send();

	}
}
