package br.com.hntecnologia.infra.util.mensagem;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Constantes;

import java.util.Map.Entry;

public class MensagemUtil {

	private static final Locale LOCALE = new Locale("pt", "BR");
	private static final String STRING_NOVA_LINHA = "\r\n";

	public static String obterMensagem(ResourceBundle resourceBundle, String chave, Object argumentos[]) {
		String mensagem = obterMensagem(resourceBundle, chave);
		for (int i = 0; i < argumentos.length; i++) {
			mensagem = Util.substituirArgumentosDoTexto(mensagem, i, argumentos[i]);
		}
		return mensagem;
	}

	public static String obterMensagem(ResourceBundle resourceBundle, String chave, Object argumento) {
		return obterMensagem(resourceBundle, chave, new Object[] { argumento });
	}

	public static String obterMensagem(ResourceBundle resourceBundle, String chave) {
		return resourceBundle.getString(chave);
	}

	public static String obterMensagemClasses(String classe) {

		return ResourceBundle.getBundle(Constantes.CLASSES_PROPERTIES, new Locale("pt_BR")).getString(classe);
	}

	public static String getStackTrace(final Throwable erro) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		erro.printStackTrace(printWriter);
		return result.toString();
	}

	/*
	 * public static String gerarMensagemErro(Throwable throwable) {
	 * 
	 * String chaveErro = null; Object[] parametrosErro = null; StringBuilder
	 * mensagemErro = new StringBuilder(); Map<String, Object> errosDeNegocio =
	 * null; Entry<?, ?> erro = null;
	 * 
	 * if(throwable instanceof Exception) {
	 * 
	 * chaveErro = ((Exception)throwable).getChaveErro(); parametrosErro =
	 * ((Exception)throwable).getParametrosErro();
	 * 
	 * errosDeNegocio = ((Exception)throwable).getErros();
	 * 
	 * if (errosDeNegocio != null && errosDeNegocio.size() > 0) {
	 * 
	 * for (Iterator<?> it=errosDeNegocio.entrySet().iterator(); it.hasNext(); )
	 * { erro = (Entry<?, ?>) it.next();
	 * mensagemErro.append(obterMensagemErro((String) erro.getValue(), LOCALE));
	 * mensagemErro.append(STRING_NOVA_LINHA); }
	 * 
	 * } else {
	 * 
	 * chaveErro = ((Object)throwable).getChaveErro();
	 * 
	 * if (chaveErro != null && chaveErro.length() > 0) {
	 * 
	 * if (parametrosErro != null && parametrosErro.length > 0) { Object[]
	 * parametrosErroLocalizado = new String[parametrosErro.length]; for (int i
	 * = 0; i < parametrosErro.length; i++) { parametrosErroLocalizado[i] =
	 * obterMensagemErro(String.valueOf(parametrosErro[i]), LOCALE); }
	 * 
	 * mensagemErro.append(MensagemUtil.obterMensagem(ResourceBundle.getBundle(
	 * Constantes.MENSAGENS_PROPERTIES,LOCALE),chaveErro,
	 * parametrosErroLocalizado) ); mensagemErro.append(STRING_NOVA_LINHA);
	 * 
	 * } else {
	 * 
	 * mensagemErro.append(chaveErro); mensagemErro.append(STRING_NOVA_LINHA);
	 * 
	 * }
	 * 
	 * } else { mensagemErro.append(chaveErro);
	 * mensagemErro.append(STRING_NOVA_LINHA); } }
	 * 
	 * } else if (throwable instanceof MixException) {
	 * 
	 * chaveErro = ((MixException)throwable).getChaveErro();
	 * 
	 * if (chaveErro != null) {
	 * mensagemErro.append(MensagemUtil.obterMensagem(ResourceBundle.getBundle(
	 * Constantes.MENSAGENS_PROPERTIES, LOCALE),chaveErro));
	 * mensagemErro.append(STRING_NOVA_LINHA); }
	 * 
	 * }
	 * 
	 * mensagemErro.append(getStackTrace(throwable)); return
	 * mensagemErro.toString();
	 * 
	 * }
	 */
	private static String obterMensagem(String chave, Locale locale) {

		String mensagem = null;
		String chaveAux = null;
		StringBuilder stringBuilder = new StringBuilder();
		String[] arrChaves = chave.split(Constantes.STRING_VIRGULA_ESPACO);
		int countTokens = arrChaves.length;

		if (countTokens > 0) {

			for (int i = 0; i < arrChaves.length; i++) {
				chaveAux = arrChaves[i];

				try {
					if (locale != null) {
						mensagem = MensagemUtil.obterMensagem(
								ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chaveAux);
					} else {
						mensagem = chaveAux;
					}
				} catch (MissingResourceException e) {
					mensagem = chaveAux;
				}

				stringBuilder.append(mensagem);

				if (countTokens > 1) {
					stringBuilder.append(Constantes.STRING_VIRGULA_ESPACO);
				}

				countTokens--;
			}

		} else {

			if (locale != null) {

				try {
					mensagem = MensagemUtil
							.obterMensagem(ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chave);
				} catch (MissingResourceException e) {
					mensagem = chave;
				}

				stringBuilder.append(mensagem);

			} else {
				stringBuilder.append(chave);
			}

		}

		return stringBuilder.toString();
	}

	public static String obterMensagem(ErroMessage erroMessage) {
		String chave = erroMessage.getKey();
		Locale locale = Constantes.LOCALE_PADRAO;
		String mensagem = null;
		String chaveAux = null;
		StringBuilder stringBuilder = new StringBuilder();
		String[] arrChaves = chave.split(Constantes.STRING_VIRGULA_ESPACO);
		int countTokens = arrChaves.length;

		if (countTokens > 0) {

			for (int i = 0; i < arrChaves.length; i++) {
				chaveAux = arrChaves[i];

				try {
					if (locale != null) {
						mensagem = MensagemUtil.obterMensagem(
								ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chaveAux);
					} else {
						mensagem = chaveAux;
					}
				} catch (MissingResourceException e) {
					mensagem = chaveAux;
				}

				stringBuilder.append(mensagem);

				if (countTokens > 1) {
					stringBuilder.append(Constantes.STRING_VIRGULA_ESPACO);
				}

				countTokens--;
			}

		} else {

			if (locale != null) {

				try {
					mensagem = MensagemUtil
							.obterMensagem(ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chave);
				} catch (MissingResourceException e) {
					mensagem = chave;
				}

				stringBuilder.append(mensagem);

			} else {
				stringBuilder.append(chave);
			}

		}

		return stringBuilder.toString();
	}

	public static String obterMensagem(ErroMessage erroMessage, Object[] argumentos) {
		String mensagem = obterMensagem(erroMessage);
		for (int i = 0; i < argumentos.length; i++) {
			mensagem = Util.substituirArgumentosDoTexto(mensagem, i, argumentos[i]);
		}

		return mensagem;
	}

	public static String obterMensagem(ErroMessage erroMessage, Object argumento) {
		String mensagem = obterMensagem(erroMessage);
		mensagem = Util.substituirArgumentosDoTexto(mensagem, 0, argumento);

		return mensagem;
	}

	public static String obterMensagem(ErroMessage erroMessage, String argumento) {
		String mensagem = obterMensagem(erroMessage);
		mensagem = Util.substituirArgumentosDoTexto(mensagem, 0, argumento);

		return mensagem;
	}

	public static String obterMensagem(ErroMessage erroMessage, String[] argumentos) {
		String mensagem = obterMensagem(erroMessage);
		for (int i = 0; i < argumentos.length; i++) {
			mensagem = Util.substituirArgumentosDoTexto(mensagem, i, argumentos[i]);
		}

		return mensagem;
	}

	public static boolean existeChave(String chave) {

		boolean retorno = true;

		try {

			MensagemUtil.obterMensagem(ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, LOCALE), chave);

		} catch (MissingResourceException e) {

			retorno = false;

		}

		return retorno;

	}

	public static String obterMensagem(Mensagem mensagem) {
		String chave = mensagem.getKey();
		Locale locale = Constantes.LOCALE_PADRAO;
		String retorno = null;
		String chaveAux = null;
		StringBuilder stringBuilder = new StringBuilder();
		String[] arrChaves = chave.split(Constantes.STRING_VIRGULA_ESPACO);
		int countTokens = arrChaves.length;

		if (countTokens > 0) {

			for (int i = 0; i < arrChaves.length; i++) {
				chaveAux = arrChaves[i];

				try {
					if (locale != null) {
						retorno = MensagemUtil.obterMensagem(
								ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chaveAux);
					} else {
						retorno = chaveAux;
					}
				} catch (MissingResourceException e) {
					retorno = chaveAux;
				}

				stringBuilder.append(retorno);

				if (countTokens > 1) {
					stringBuilder.append(Constantes.STRING_VIRGULA_ESPACO);
				}

				countTokens--;
			}

		} else {

			if (locale != null) {

				try {
					retorno = MensagemUtil
							.obterMensagem(ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES, locale), chave);
				} catch (MissingResourceException e) {
					retorno = chave;
				}

				stringBuilder.append(retorno);

			} else {
				stringBuilder.append(chave);
			}

		}

		return stringBuilder.toString();
	}

	public static String obterMensagem(Mensagem mensagem, Object[] argumentos) {
		String retorno = obterMensagem(mensagem);
		for (int i = 0; i < argumentos.length; i++) {
			retorno = Util.substituirArgumentosDoTexto(retorno, i, argumentos[i]);
		}

		return retorno;
	}

	public static String obterMensagem(Mensagem mensagem, Object argumento) {
		String retorno = obterMensagem(mensagem);
		retorno = Util.substituirArgumentosDoTexto(retorno, 0, argumento);

		return retorno;
	}

	public static String obterMensagem(Mensagem mensagem, String argumento) {
		String retorno = obterMensagem(mensagem);
		retorno = Util.substituirArgumentosDoTexto(retorno, 0, argumento);

		return retorno;
	}

	public static String obterMensagem(Mensagem mensagem, String[] argumentos) {
		String retorno = obterMensagem(mensagem);
		for (int i = 0; i < argumentos.length; i++) {
			retorno = Util.substituirArgumentosDoTexto(retorno, i, argumentos[i]);
		}

		return retorno;
	}

}
