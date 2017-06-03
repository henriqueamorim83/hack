package br.com.hntecnologia.infra.exception;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.util.mensagem.MensagemUtil;

public class NegocioException {
	

	
	public static String mensagem(ErroMessage erroMessage){
		return MensagemUtil.obterMensagem(erroMessage);
	}
	public static String mensagem(ErroMessage erroMessage,Object[] object){
		return MensagemUtil.obterMensagem(erroMessage,object);
	}
	
	private  String[] retorno = new String[Integer.MAX_VALUE];
	
	public   String[] getRetorno() {
		
		return retorno;
	}
	public  void setRetorno(String[] retornos) {
		this.retorno = retornos;
	}

	
	

}
