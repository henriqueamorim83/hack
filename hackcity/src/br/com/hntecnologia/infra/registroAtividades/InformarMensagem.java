package br.com.hntecnologia.infra.registroAtividades;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import br.com.hntecnologia.fachada.Fachada;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.negocio.usuario.Pojo;
import br.com.hntecnologia.infra.util.PropertiesUtil;
import br.com.hntecnologia.infra.util.mensagem.MensagemUtil;

public class InformarMensagem {

	public static InformarMensagem instancia;

	public static InformarMensagem getInstancia() {
		if (instancia == null) {
			instancia = new InformarMensagem();
		}
		return instancia;
	}

	
	
	public  String Mensagem(ErroMessage erroMessage) {

		return MensagemUtil.obterMensagem(erroMessage);

	}

	public  String Mensagem(ErroMessage erroMessage, String argumento) {

		return MensagemUtil.obterMensagem(erroMessage, argumento);

	}

	public  String Mensagem(ErroMessage erroMessage, Object argumento) {

		return MensagemUtil.obterMensagem(erroMessage, argumento);

	}

	public String Mensagem(ErroMessage erroMessage, Object[] argumentos) {

		return MensagemUtil.obterMensagem(erroMessage, argumentos);

	}

	public String Mensagem(ErroMessage erroMessage, String[] argumentos) {

		return MensagemUtil.obterMensagem(erroMessage, argumentos);

	}

	public  String Mensagem(Mensagem mensagem) {

		return MensagemUtil.obterMensagem(mensagem);

	}

	public  String Mensagem(Mensagem mensagem, String argumento) {

		return MensagemUtil.obterMensagem(mensagem, argumento);

	}

	public  String Mensagem(Mensagem mensagem, Object argumento) {

		return MensagemUtil.obterMensagem(mensagem, argumento);

	}

	public  String Mensagem(Mensagem mensagem, Object[] argumentos) {

		return MensagemUtil.obterMensagem(mensagem, argumentos);

	}

	public  String Mensagem(Mensagem mensagem, String[] argumentos) {

		return MensagemUtil.obterMensagem(mensagem, argumentos);

	}

	

}
