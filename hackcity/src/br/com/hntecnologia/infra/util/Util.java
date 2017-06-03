package br.com.hntecnologia.infra.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.swing.text.MaskFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.hntecnologia.infra.run.Webservicecep;
import br.com.hntecnologia.infra.util.constantes.Constantes;
 
import br.com.hntecnologia.negocio.usuario.Usuario;

public class Util {
	public static final Integer VERSAO_INICIAL = 0;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final String MASCARA_DATA_VAZIA = "__/__/____";
	private static List<String> CPFS_INVALIDOS;
	public static final String FORMATO_EMAIL = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
	private static NumberFormat currencyFormat;
	private static String REGEX = "\\d+";
	private static String INPUT = "askjdsadAÇSJD=544333sad|TESTE~çç-(*&¨%$#%@";
	private static final long VALOR_INICIAL_NOSSO_NUMERO = 60000;

	public static String getRandomImageName() {
		int i = (int) (Math.random() * 100000);

		return String.valueOf(i);
	}

	public static String formataCpf(String cpf) throws ParseException {
		MaskFormatter mf = new MaskFormatter("###.###.###-##");
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(cpf);
	}

	public static String formataCnpj(String cnpj) throws ParseException {
		MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(cnpj);
	}

	public static String formataTelefone(String telefone) throws ParseException {
		MaskFormatter mf = new MaskFormatter("(##) ####-####");
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(telefone);
	}

	public static String formataCep(String cep) throws ParseException {
		MaskFormatter mf = new MaskFormatter("#####-###");
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(cep);
	}

	public static String normalize(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[^\\p{ASCII}]", "");

		return s;
	}

	public static boolean estaDentroDoPeriodo(Date hoje, Date inicio, Date fim) {
		return (hoje.compareTo(inicio) >= 0 && hoje.compareTo(fim) <= 0);
	}

	public static String formataMoeda(Double valor) {
		return NumberFormat.getCurrencyInstance().format(valor);
	}

	public static Integer getIdade(Date data) {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		Calendar dataAtual = Calendar.getInstance();

		Integer diferencaMes = dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
		Integer diferencaDia = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);
		Integer idade = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));

		if (diferencaMes < 0 || (diferencaMes == 0 && diferencaDia < 0)) {
			idade--;
		}

		return idade;
	}

	public static String setMD5Password(String password) {
		String senhaCriptografada = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
		senhaCriptografada = hash.toString(16);
		return senhaCriptografada;
	}

	/**
	 * Remover a formatacao da string de Data, que verifica se contem apenas a
	 * mascara vazia.
	 * 
	 * @param stringData
	 *            String da data
	 * @return A String da Data sem a mascara vazia
	 */
	public static String removerFormatacaoDataVazia(final String stringData) {
		String stringSemFormatacao = "";
		if ((stringData != null) && !MASCARA_DATA_VAZIA.equals(stringData)) {
			stringSemFormatacao = StringUtils.remove(stringData, "_");
		}
		return stringSemFormatacao;
	}

	/**
	 * Verifica se a Lista passada nao e nula e nem vazia
	 * 
	 * @param lista
	 *            Lista a ser verificada
	 * @return TRUE se a Lsita nao e nula e nem vazia
	 */
	public static boolean isListNaoNulaNaoVazia(final Collection<?> lista) {
		return (lista != null) && !lista.isEmpty();
	}

	/**
	 * Verifica se a string passada nao e nula nem vazia
	 * 
	 * @param string
	 *            String a ser verificada
	 * @return true se a string nao e nula nem vazia
	 */
	public static boolean isStringNaoNulaNaoVazia(final String string) {
		return StringUtils.isNotBlank(string);
	}

	private static List<String> getCpfsInvalidos() {
		if (CPFS_INVALIDOS == null) {
			CPFS_INVALIDOS = Arrays.asList(new String[] { "00000000000", "11111111111", "22222222222", "33333333333",
					"44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999" });
		}
		return CPFS_INVALIDOS;
	}

	/**
	 * Metodo que adiciona a formatacao do CNPJ (Coloca os pontos e traço). O
	 * cnpj passado devera ter 14 caracteres (cnpj sem formatacao), pois so
	 * assim tera a formatacao adicionada. Caso nao possua, sera retornada a
	 * mesma string.
	 * 
	 * @param cnpj
	 *            CNPJ a ter a formatacao ajustada
	 * @return CNPJ com a formatacao
	 */
	public static String adicionarFormatacaoCNPJ(final String cnpj) {
		if (cnpj == null) {
			return null;
		}
		String cnpjFormatado = cnpj;
		if (cnpj.length() == 14) {
			StringBuilder cnpjBuilder = new StringBuilder();
			cnpjBuilder.append(cnpj.substring(0, 2)).append(".");
			cnpjBuilder.append(cnpj.substring(2, 5)).append(".");
			cnpjBuilder.append(cnpj.substring(5, 8)).append("/");
			cnpjBuilder.append(cnpj.substring(8, 12)).append("-");
			cnpjBuilder.append(cnpj.substring(12));
			cnpjFormatado = cnpjBuilder.toString();
		}
		return cnpjFormatado;
	}

	/**
	 * Metodo que adiciona a formatacao do cpf (Coloca os pontos e traço). O cpf
	 * passado devera ter 11 caracteres (cpf sem formatacao), pois so assim tera
	 * a formatacao adicionada. Caso nao possua, sera retornada a mesma string.
	 * 
	 * @param cpf
	 *            CPF a ter a formatacao ajustada
	 * @return CPF com a formatacao
	 */
	public static String adicionarFormatacaoCPF(final String cpf) {
		if (cpf == null) {
			return null;
		}
		String cpfFormatado = cpf;
		if (cpf.length() == 11) {
			StringBuilder cpfBuilder = new StringBuilder();
			cpfBuilder.append(cpf.substring(0, 3)).append(".");
			cpfBuilder.append(cpf.substring(3, 6)).append(".");
			cpfBuilder.append(cpf.substring(6, 9)).append("-");
			cpfBuilder.append(cpf.substring(9));
			cpfFormatado = cpfBuilder.toString();
		}
		return cpfFormatado;
	}

	/**
	 * Metodo que adiciona a formatacao do telefone (Coloca o traco e os
	 * parenteses). O telefone passado devera ter 11 ou 12 caracteres, pois so
	 * assim tera a formatacao adicionada. Caso nao possua, sera retornada a
	 * mesma string.
	 * 
	 * @param telefone
	 *            Telefone a ter a formatacao ajustada
	 * @return Telefone com a formatacao
	 */
	public static String adicionarFormatacaoTelefone(final String telefone) {
		if (telefone == null) {
			return null;
		}
		String telefoneFormatado = telefone;
		if ((telefone.length() == 10) || (telefone.length() == 11)) {
			StringBuilder builder = new StringBuilder();
			builder.append("(").append(telefone.substring(0, 2)).append(")");
			int pontoHifen = telefone.length() - 4;
			builder.append(telefone.substring(2, pontoHifen)).append("-");
			builder.append(telefone.substring(pontoHifen));
			telefoneFormatado = builder.toString();
		}
		return telefoneFormatado;
	}

	/**
	 * Retira a mascara do CNPJ passado por parametro
	 * 
	 * @param cnpj
	 *            com a mascara
	 * @return cnpj sem mascara
	 */
	public static String removerFormatacaoCNPJ(final String cnpj) {
		String cnpjSemMascara = "";
		if (cnpj != null) {
			cnpjSemMascara = StringUtils.remove(cnpj.toUpperCase(), "_");
			cnpjSemMascara = cnpjSemMascara.replaceAll("\\.|\\-|/", "");
		}
		return cnpjSemMascara;
	}

	/**
	 * Metodo que remove a formatacao do cpf (Retira os pontos e traco)
	 * 
	 * @param cpf
	 *            CPF a ter a formatacao retirada
	 * @return CPF sem a formatacao
	 */
	public static String removerFormatacaoCPF(final String cpf) {
		if (cpf == null) {
			return null;
		}
		String cpfFormatado = StringUtils.remove(cpf.toUpperCase(), "_");
		cpfFormatado = StringUtils.remove(cpfFormatado.toUpperCase(), '.');
		cpfFormatado = StringUtils.remove(cpfFormatado, '-');
		return cpfFormatado;
	}

	/**
	 * Metodo que remove a formatacao do telefone (Retira os tracos e
	 * parenteses)
	 * 
	 * @param telefone
	 *            Telefone a ter a formatacao retirada
	 * @return Telefone sem a formatacao
	 */
	public static String removerFormatacaoTelefone(final String telefone) {
		String telefoneSemMascara = "";
		if (telefone != null) {
			telefoneSemMascara = StringUtils.remove(telefone, "_");
			telefoneSemMascara = telefoneSemMascara.replaceAll("\\D|\\s", "");
		}
		return telefoneSemMascara;
	}

	/**
	 * Converte a string passada para um valor decimal que utiliza o ponto (.)
	 * como separador.
	 * 
	 * @param valor
	 *            String que deseja-se converter
	 * @return String de valor convertida
	 */
	public static String retirarFormatacaoNumeroDecimal(String valor) {
		String retorno = null;
		if ((valor != null) && !valor.isEmpty()) {
			retorno = retirarSomenteNumeros(valor);

			if (Double.valueOf(retorno) > 1) {

				retorno = retorno.substring(0, retorno.length() - 2) + "."
						+ retorno.substring(retorno.length() - 2, retorno.length());

			}

		}
		return retorno;
	}

	/**
	 * Metodo que valida se o CNPJ passado e valido
	 * 
	 * @param cnpj
	 *            CNPJ a ser validade
	 * @return <code>true</code> se o CNPJ for valido <code>false</code> se for
	 *         invalido
	 */
	public static boolean validacaoCNPJ(final String cnpj) {
		return validarCNPJ(removerFormatacaoCNPJ(cnpj));
	}

	/**
	 * Metodo que realiza a validacao do CNPJ.
	 * 
	 * @param cnpjStr
	 *            String representando o CNPJ
	 * @return <code>true</code> se o CNPJ for valido <code>false</code> caso
	 *         contrario
	 */
	private static boolean validarCNPJ(final String cnpjStr) {
		int soma = 0;
		int digito = -1;

		if (cnpjStr.length() != 14) {
			return false;
		}

		String cnpj_calc = cnpjStr.substring(0, 12);

		char[] chr_cnpj = cnpjStr.toCharArray();

		/* Primeira parte */
		for (int i = 0; i < 4; i++) {
			if (((chr_cnpj[i] - 48) >= 0) && ((chr_cnpj[i] - 48) <= 9)) {
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++) {
			if (((chr_cnpj[i + 4] - 48) >= 0) && ((chr_cnpj[i + 4] - 48) <= 9)) {
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
			}
		}
		digito = 11 - (soma % 11);

		cnpj_calc += ((digito == 10) || (digito == 11)) ? "0" : Integer.toString(digito);

		/* Segunda parte */
		soma = 0;
		for (int i = 0; i < 5; i++) {
			if (((chr_cnpj[i] - 48) >= 0) && ((chr_cnpj[i] - 48) <= 9)) {
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++) {
			if (((chr_cnpj[i + 5] - 48) >= 0) && ((chr_cnpj[i + 5] - 48) <= 9)) {
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
			}
		}
		digito = 11 - (soma % 11);
		cnpj_calc += ((digito == 10) || (digito == 11)) ? "0" : Integer.toString(digito);

		return cnpjStr.equals(cnpj_calc);
	}

	/**
	 * Metodo para validar um CPF.
	 * 
	 * @param cpf
	 *            - String representando o CPF a ser validado
	 * @return <code>true</code> se o CPF for valido; <code>false</code> caso
	 *         contrario.
	 */
	public static boolean validacaoCPF(final String cpf) {
		return validacaoCPF(cpf, false);
	}

	/**
	 * Metodo para validar um CPF.
	 * 
	 * @param cpf
	 *            - String representando o CPF a ser validado
	 * @param desconsiderarCpfIguais
	 *            - Informa se os numeros de CPFs com digitos iguais devem ser
	 *            desconsiderados ou nao
	 * @return <code>true</code> se o CPF for valido; <code>false</code> caso
	 *         contrario.
	 */
	public static boolean validacaoCPF(final String cpf, final boolean desconsiderarCpfIguais) {
		String cpfValidado = cpf;
		if (cpf.length() == 14) {
			cpfValidado = removerFormatacaoCPF(cpf);
		}
		if (cpfValidado.length() != 11) {
			return false;
		}
		if (desconsiderarCpfIguais) {
			if (getCpfsInvalidos().contains(cpfValidado)) {
				return false;
			}
		}
		final String numDig = cpfValidado.substring(0, 9);
		return calculoDigitoVerificador(numDig).equals(cpfValidado.substring(9, 11));
	}

	/**
	 * Metodo que valida o digito verificador da string, assumindo que a mesma
	 * seja um CPF, e retorna o digito verificador do numero passado
	 * 
	 * @param numero
	 *            Numero a ser validado
	 * @return
	 */
	private static String calculoDigitoVerificador(final String numero) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < numero.length(); i++) {
			soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;
		}
		if (((soma % 11) == 0) | ((soma % 11) == 1)) {
			primDig = new Integer(0);
		} else {
			primDig = new Integer(11 - (soma % 11));
		}
		soma = 0;
		peso = 11;
		for (int i = 0; i < numero.length(); i++) {
			soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;
		}
		soma += primDig.intValue() * 2;
		if (((soma % 11) == 0) | ((soma % 11) == 1)) {
			segDig = new Integer(0);
		} else {
			segDig = new Integer(11 - (soma % 11));
		}
		return primDig.toString() + segDig.toString();
	}

	// Método de Validação do Formato de Email
	public static void validarFormatoEmail(String email) throws Exception {

		// Setar a Pattern da String
		Pattern p = Pattern.compile(FORMATO_EMAIL);

		// Procura na String se a Pattern existe
		if (email != null && email.length() > 0) {
			Matcher m = p.matcher(email.toLowerCase());

			boolean matchFound = m.matches();

			if (!matchFound) {
				throw new Exception();
			}

		}

	}

	public static NumberFormat getCurrencyFormat() {
		if (currencyFormat == null) {
			currencyFormat = NumberFormat.getInstance();
			currencyFormat.setGroupingUsed(true);
			currencyFormat.setMinimumFractionDigits(2);
			currencyFormat.setMaximumFractionDigits(2);
		}
		return currencyFormat;
	}

	/**
	 * Converte formato percentual
	 * 
	 * *
	 * 
	 */

	public static Double formatoPercentualDouble(Double valor) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setMinimumIntegerDigits(2);
		return new Double(nf.format(valor).replace(",", "."));
	}

	/**
	 * Converte um double para string com mascara de valor
	 * 
	 * @param valor
	 *            Double que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static String formatarDoubleParaMascaraValor(Double valor) {
		String valorMascara = "";
		if (valor != null) {
			valorMascara = getCurrencyFormat().format(valor);
		}
		return valorMascara;
	}

	/**
	 * Converte um bigdecimal para string com mascara de valor
	 * 
	 * @param valor
	 *            bigdecimal que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static String formatarBigDecimalParaMascaraValor(BigDecimal valor) {
		String valorMascara = "";
		if (valor != null) {
			valorMascara = getCurrencyFormat().format(valor);
		}
		return valorMascara;
	}

	/**
	 * Converte um valor com mascara de numero decimal para um double
	 * 
	 * @param mascaraValor
	 *            Valor decimal com mascara
	 * @return Valor convertido em double. Null se valor for invalido ou null.
	 */
	public static Double converteMascaraValorParaDouble(String mascaraValor) {
		Double valor = null;
		String valorStr = retirarFormatacaoNumeroDecimal(mascaraValor);
		if (valorStr != null) {
			try {
				valor = Double.parseDouble(valorStr);
			} catch (Exception e) {
			}
		}
		return valor;
	}

	/**
	 * Converte um valor com mascara de numero decimal para um bigdecimal
	 * 
	 * @param mascaraValor
	 *            Valor decimal com mascara
	 * @return Valor convertido em bigdecimal. Null se valor for invalido ou
	 *         null.
	 */
	public static BigDecimal converteMascaraValorParaBigDecimal(String mascaraValor) {
		Double valor = null;
		String valorStr = retirarFormatacaoNumeroDecimal(mascaraValor);
		if (valorStr != null) {
			try {
				valor = Double.parseDouble(valorStr);
			} catch (Exception e) {
			}
		} else {
			return new BigDecimal(mascaraValor.replaceAll(",", "."));
		}
		return new BigDecimal(valor);
	}

	public static boolean verificarValor(double valor) {
		if (valor > Math.floor(valor)) {
			return true;
		} else {
			return false;
		}
	}

	public static String converterDoublePercentual(Double valor) {
		String valorMascara = "";
		if (valor != null) {
			valor = valor * 100;
			if (valor < 10) {
				valorMascara = "";
			}
			valorMascara = valorMascara + getCurrencyFormat().format(valor);
			if (!valorMascara.contains(",")) {
				valorMascara = valorMascara + ",";
			}
			if (valorMascara.charAt(valorMascara.length() - 1) == ',') {
				valorMascara += "00";
			}
			if (valorMascara.charAt(valorMascara.length() - 2) == ',') {
				valorMascara += "0";
			}
			valorMascara = valorMascara.replace(",00", "") + "%";
		}
		return valorMascara;

	}

	/**
	 * Método que formata o valor Dado um 100.00 transforma em 100,00 Dado um
	 * 100 transforma em 100,00 Dado um 100.0 transforma em 100,00 Dado um
	 * 100.000 transforma em 100,00
	 * 
	 * @param boleto
	 * @return
	 */
	public static String formatarValorParaString(Double valor) {
		String retorno = valor.toString();
		String centavos = "00";
		int posicao = retorno.indexOf(".");
		if (posicao != -1) {
			centavos = retorno.substring(posicao + 1, retorno.length());
			retorno = retorno.substring(0, posicao);
			if (centavos.length() == 0) {
				centavos = "00";
			} else if (centavos.length() == 1) {
				centavos = centavos + "0";
			}
			if (centavos.length() > 2) {
				centavos = centavos.substring(0, 2);
			}
		}
		return retorno + "," + centavos;
		// return "37,50";
	}

	/**
	 * formato = "yyyyMMdd" ou "ddMMyyyy"
	 * 
	 * @param data
	 * @param formato
	 * @return
	 */
	public static String converterDateToString(Date data, String formato) {

		SimpleDateFormat dateformat = new SimpleDateFormat(formato);

		StringBuilder dataConvertida = new StringBuilder(dateformat.format(data));

		return dataConvertida.toString();
	}

	public static String retornoTipoCliente(Integer tipoCliente) {
		String retorno = null;
		switch (tipoCliente) {
		case 1:
			retorno = "RESIDÊNCIA";
			break;
		case 2:
			retorno = "EMPRESARIAL";
			break;
		case 3:
			retorno = "VIDA";
			break;
		case 4:
			retorno = "AUTOMOTIVO";
			break;
		case 5:
			retorno = "CONDOMINIO RESIDENCIAL";
			break;
		case 6:
			retorno = "COMERCIAL";
			break;
		case 7:
			retorno = "MISTO";
			break;

		default:
			break;
		}
		return retorno;
	}

	public static String retornoTipoProposta(Integer tipoProposta) {
		String retorno = "";
		switch (tipoProposta) {
		case 1:
			retorno = "Novo";
			break;
		case 2:
			retorno = "Cancelado";
			break;
		case 3:
			retorno = "Renovado";
			break;

		default:
			break;
		}
		return retorno;
	}

	/**
	 * Método responsável por fazer a converção de um campo string para um valor
	 * BigDecimal
	 * 
	 * @param strValor
	 * @param formato
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static BigDecimal converterCampoStringParaValorBigDecimal(String strValor, String formato) {

		BigDecimal valor = null;

		try {

			DecimalFormat decimalFormat = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
			decimalFormat.setParseBigDecimal(true);
			valor = (BigDecimal) decimalFormat.parse(strValor);

			return valor;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return valor;

	}

	/**
	 * Método responsável por converter um valor BigDecimal para um campo String
	 * 
	 * @param valor
	 * @param formato
	 * @param locale
	 * @return
	 */
	public static String converterCampoValorParaString(BigDecimal valor, String formato) {

		DecimalFormat decimalFormat = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
		decimalFormat.setParseBigDecimal(true);
		return decimalFormat.format(valor);

	}

	/**
	 * Converte um double para string com mascara de valor
	 * 
	 * @param valor
	 *            Double que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static BigDecimal formatarBigDecimalParaMascaraValorTresCasas(BigDecimal valor) {
		String valorMascara = "";
		if (valor != null) {
			NumberFormat currencyFormat = NumberFormat.getInstance();
			currencyFormat.setGroupingUsed(true);
			currencyFormat.setMinimumFractionDigits(0);
			currencyFormat.setMaximumFractionDigits(3);
			valorMascara = currencyFormat.format(valor);
			valorMascara = valorMascara.replace(",", ".");
		}
		return new BigDecimal(valorMascara);
	}
	
	/**
	 * Converte um double para string com mascara de valor
	 * 
	 * @param valor
	 *            Double que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static BigDecimal formatarBigDecimalParaMascaraValorDuasCasas(BigDecimal valor) {
		String valorMascara = "";
		if (valor != null) {
			NumberFormat currencyFormat = NumberFormat.getInstance();
			currencyFormat.setGroupingUsed(true);
			currencyFormat.setMinimumFractionDigits(0);
			currencyFormat.setMaximumFractionDigits(2);
			valorMascara = currencyFormat.format(valor);
			valorMascara = valorMascara.replace(",", "");
		}
		return new BigDecimal(valorMascara);
	}

	public static String cript(String texto) {
		char[] array = texto.toCharArray();
		for (int i = 0; i < texto.length(); i++) {
			array[i] = (char) (texto.charAt(i) + 75);
		}
		return new String(array);
	}

	public static String decripto(String texto) {
		char[] array = texto.toCharArray();
		for (int i = 0; i < texto.length(); i++) {
			array[i] = (char) (texto.charAt(i) - 75);
		}
		return new String(array);

	}

	public static String substituirArgumentosDoTexto(String texo, int numeroDeArgumentos, Object valorDoArgumento) {

		StringBuilder stringBuilder = new StringBuilder(texo.length() + 10);
		String chave = "{" + numeroDeArgumentos + "}";

		int i = texo.indexOf(chave);
		if (i >= 0) {
			stringBuilder.append(texo.substring(0, i));
			stringBuilder.append(valorDoArgumento);
			stringBuilder.append(texo.substring(i + chave.length()));
		} else {
			stringBuilder.append(texo);
		}
		return stringBuilder.toString();
	}

	public static Webservicecep buscarCePWebService(String cep) throws JAXBException, MalformedURLException {
		JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
		Webservicecep wCep = (Webservicecep) u.unmarshal(url);
		return wCep;
	}

	public static void redimensionaImg(File image, int new_w, int new_h, String caminho) throws IOException {

		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(image);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = new_img.createGraphics();

		g.drawImage(imagem, 0, 0, new_w, new_h, null);
		ImageIO.write(new_img, caminho.substring(caminho.length() - 3, caminho.length()), new File(caminho));

	}

	public static void salvarArquivos(byte[] bytes, String nome) {

		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
		String realPath = context.getRealPath("/");
		File file = new File(realPath + "resources/arquivos/");
		file.mkdirs();
		String caminho = realPath + "resources/arquivos/" + nome;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(caminho);
			fos.write(bytes);
			fos.close();
			redimensionaImg(new File(caminho), 400, 400, caminho);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void salvarArquivos(File file, byte[] bytes, Integer tamanho) {
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(file);
			imageOutput.write(bytes, 0, tamanho);
			imageOutput.close();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cropping failed."));
		}

		// FacesContext.getCurrentInstance().addMessage(null, new
		// FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Cropping
		// finished."));
	}

	public static Date zerarHoraMinutoSegundoDate(Date data) {

		Calendar cAtual = Calendar.getInstance();
		cAtual.setTime(data);
		cAtual.set(Calendar.HOUR_OF_DAY, cAtual.getMinimum(Calendar.HOUR_OF_DAY));
		cAtual.set(Calendar.MINUTE, cAtual.getMinimum(Calendar.MINUTE));
		cAtual.set(Calendar.SECOND, cAtual.getMinimum(Calendar.SECOND));
		cAtual.set(Calendar.MILLISECOND, cAtual.getMinimum(Calendar.MILLISECOND));

		return cAtual.getTime();

	}

	public static Date maximizarHoraMinutoSegundoDate(Date data) {

		Calendar cAtual = Calendar.getInstance();
		cAtual.setTime(data);
		cAtual.set(Calendar.HOUR_OF_DAY, cAtual.getMaximum(Calendar.HOUR_OF_DAY));
		cAtual.set(Calendar.MINUTE, cAtual.getMaximum(Calendar.MINUTE));
		cAtual.set(Calendar.SECOND, cAtual.getMaximum(Calendar.SECOND));
		cAtual.set(Calendar.MILLISECOND, cAtual.getMaximum(Calendar.MILLISECOND));

		return cAtual.getTime();
	}

	
	public static Date adicionarHoraDataInicio(Date dateInicio) {

		SimpleDateFormat dtInicio = new SimpleDateFormat("dd/MM/yyyy");
		String dataInicio = dtInicio.format(dateInicio);
		dataInicio += " 00:00:00";
		dtInicio = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		try {
			return dateInicio = dtInicio.parse(dataInicio);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static Date adicionarHoraDataFim(Date dateFim) {
		SimpleDateFormat dtFim = new SimpleDateFormat("dd/MM/yyyy");
		String dataFim = dtFim.format(dateFim);
		dataFim += " 23:59:59";
		dtFim = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		try {

			return dateFim = dtFim.parse(dataFim);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static boolean valorMoeda(String modeda) {

		return false;
	}

	public static boolean soContemNumeros(String texto) {
		Boolean retorno = true;
		if (texto != null && texto.length() > 0) {
			for (char letra : texto.toCharArray()) {
				if (letra != ' ' && letra != '.' && letra != ',' && letra < '0' || letra > '9') {
					retorno = false;
				}

			}
		}

		return retorno;

	}

	public static String retirarSomenteNumeros(String texto) {
		String retorno = texto.replaceAll("[^0-9]*", "");

		return retorno;

	}

	public static String retirarEspaçosString(String texto) {
		String retorno = "";
		texto = texto.replaceAll("\n", "");
		texto = texto.replaceAll(" ", "");

		// System.out.println("começou ");
		for (int i = 0; i < texto.length(); i++) {
			// System.out.println((int) texto.charAt(i)+ ":" + texto.charAt(i));
			if ((int) texto.charAt(i) < 160 || (int) texto.charAt(i) > 160) {
				retorno += (char) (texto.charAt(i));
			}
		}
		return retorno;
	}

	public static String retirarString(String texto) {
		texto = texto.replaceAll("\n", "");

		int cont = 0;
		int caract = 0;
		while (cont < 3) {
			System.out.println((int) texto.charAt(cont) + ":" + texto.charAt(cont));
			if ((int) texto.charAt(0) == 160) {
				texto = texto.substring(1, texto.length());
				if (caract == 1) {
					break;
				}

				caract++;
			}
			cont++;
		}
		return texto;
	}

	/**
	 * 
	 * @author Henrique
	 * @return Usuárioo
	 * 
	 * 
	 */
	public static Usuario getUsuario() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				Usuario usuario = ((Usuario) authentication.getPrincipal());

				return usuario;
			}
		}
		return null;
	}
	public static String dataAtualFormatadaPorExtenso(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		int dia = calendar.get(Calendar.DATE);
		int mes = calendar.get(Calendar.MONTH) + 1;
		int ano = calendar.get(Calendar.YEAR);
		String mesDescricao = "";
		switch (mes) {
		case 1:
			mesDescricao = "Janeiro";
			break;
		case 2:
			mesDescricao = "Fevereiro";
			break;
		case 3:
			mesDescricao = "Março";
			break;
		case 4:
			mesDescricao = "Abril";
			break;
		case 5:
			mesDescricao = "Maio";
			break;
		case 6:
			mesDescricao = "Junho";
			break;
		case 7:
			mesDescricao = "Julho";
			break;
		case 8:
			mesDescricao = "Agosto";
			break;
		case 9:
			mesDescricao = "Setembro";
			break;
		case 10:
			mesDescricao = "Outubro";
			break;
		case 11:
			mesDescricao = "Novembro";
			break;
		case 12:
			mesDescricao = "Dezembro";
			break;

		default:
			break;
		}

		return dia + " de " + mesDescricao + " de " + ano;
	}

	public static Date somenteData(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String d = format.format(data);
		try {
			return format.parse(d);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static String somenteDataString(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String d = format.format(data);
			return d;
		} catch (Exception e) {

			return "";
		}

	}

	public static Date somenteHora(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		String d = format.format(data);
		try {
			return format.parse(d);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static String obterNossoNumero(Long idDocumentoCobranca) {

		int zerosNossoNumero = 11;

		if (idDocumentoCobranca >= 1 && idDocumentoCobranca <= 99) {
			zerosNossoNumero = 11;
		} else if (idDocumentoCobranca >= 100 && idDocumentoCobranca <= 999) {
			zerosNossoNumero = 10;
		} else if (idDocumentoCobranca >= 1000 && idDocumentoCobranca <= 9999) {
			zerosNossoNumero = 11;
		} else if (idDocumentoCobranca >= 10000 && idDocumentoCobranca <= 60000) {
			zerosNossoNumero = 8;
		} else if (idDocumentoCobranca > 99999) {
			zerosNossoNumero = 7;
		}

		StringBuffer sb;

		if (idDocumentoCobranca < 60000) {

			sb = new StringBuffer(String.valueOf(idDocumentoCobranca + VALOR_INICIAL_NOSSO_NUMERO));

		} else {

			sb = new StringBuffer(String.valueOf(idDocumentoCobranca));

		}

		padding(sb, 2, zerosNossoNumero, '0');

		return sb.toString();

	}

	public static void padding(StringBuffer stringBuffer, int direcao, int quantidade, char caracter) {
		switch (direcao) {
		case 1:
			paddingDireita(stringBuffer, quantidade, caracter);
			break;
		case 2:
			paddingEsquerda(stringBuffer, quantidade, caracter);
			break;
		default:
			throw new IllegalArgumentException();
		}

	}

	private static void paddingDireita(StringBuffer stringBuffer, int quantidade, char caracter) {
		String original = stringBuffer.toString();
		stringBuffer.setLength(0);

		if (original.length() < quantidade) {
			stringBuffer.append(original);

			for (int i = 0; i < quantidade - original.length(); ++i) {
				stringBuffer.append(caracter);
			}
		} else {
			stringBuffer.append(original);
		}
	}

	public static int gerarDigitoModulo11(String campo) {

		int tamanho = campo.length();
		int mult = 2;
		int resultadoParcial = 0;

		for (int i = 0; i < tamanho; i++) {
			if (mult > 9)
				mult = 2;
			resultadoParcial += Integer.parseInt(campo.substring(tamanho - i - 1, tamanho - i)) * mult;
			mult++;
		}

		int resto = resultadoParcial % 11;
		int resultado = 11 - resto;
		if (resultado == 10) {
			resultado = 0;
		}

		return resultado;
	}

	private static void paddingEsquerda(StringBuffer stringBuffer, int quantidade, char caracter) {
		String original = stringBuffer.toString();
		stringBuffer.setLength(0);

		if (original.length() < quantidade) {
			for (int i = 0; i < quantidade - original.length(); ++i) {
				stringBuffer.append(caracter);
			}
			stringBuffer.append(original);
		} else {
			stringBuffer.append(original);
		}
	}

	public static Date retirarDiasData(Date data, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - dias);
		return calendar.getTime();
	}

	public static String retirarEspacosString(String text) {
		String string = text.trim();
		while (string.contains("  ")) {
			string = string.replaceAll("  ", " ");
		}
		return string;
	}

	public static List<String> leitor(String path) throws IOException {
		List<String> retorno = new ArrayList<String>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);
				retorno.add(linha);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();

		return retorno;
	}

	public static void atualizarBancoRipe() {
		String sql = "select table_name from information_schema.tables where table_schema='public'";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/corretor_docg_erp",
					"hndesen_postgre", "MoLiHe051709");
			PreparedStatement pt = conexao.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				String tabela = rs.getString("table_name");
				String update = "update " + tabela + " set fk_id_empresa=1";
				try {
					PreparedStatement exe = conexao.prepareStatement(update);
					exe.executeUpdate();
				} catch (Exception e) {

				}

			}

			String sqlSeq = "SELECT c.relname AS sequencename FROM pg_class c WHERE (c.relkind = 'S')";

			PreparedStatement seq = conexao.prepareStatement(sqlSeq);
			ResultSet reSeq = seq.executeQuery();
			while (reSeq.next()) {
				PreparedStatement upSeq = conexao.prepareStatement(
						"SELECT pg_catalog.setval('" + reSeq.getString("sequencename") + "', 10000, true);");
				// upSeq.execute();
			}

			conexao.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println("terminou");
	}

	public static void atualizarBancoSuprimentos() {
		String sql = "select table_name from information_schema.tables where table_schema='public'";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/corretor_docg_erp_garanhuns",
					"postgres", "postgres");
			PreparedStatement pt = conexao.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				String tabela = rs.getString("table_name");
				String update = "update " + tabela + " set fk_id_empresa=5003";
				try {
					PreparedStatement exe = conexao.prepareStatement(update);
					exe.executeUpdate();
				} catch (Exception e) {

				}

			}

			String sqlSeq = "SELECT c.relname AS sequencename FROM pg_class c WHERE (c.relkind = 'S')";

			PreparedStatement seq = conexao.prepareStatement(sqlSeq);
			ResultSet reSeq = seq.executeQuery();
			while (reSeq.next()) {
				PreparedStatement upSeq = conexao.prepareStatement(
						"SELECT pg_catalog.setval('" + reSeq.getString("sequencename") + "', 10000, true);");
				// upSeq.execute();
			}

			conexao.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println("terminou");
	}

	public static BigDecimal calcularMargemDeLucro(BigDecimal preco, Double margem) {
		if (preco != null && margem != null) {
			Double valor = preco.doubleValue()	+ (margem / 100.0) * (preco.doubleValue());
			return  new BigDecimal(valor);
		}
		return BigDecimal.ZERO;
	}
	
}
