package br.com.hntecnologia.converter.infra;


import java.text.NumberFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "mascaraValorPercentualConverter")
public class MascaraValorPercentualConverter implements Converter {

	private static NumberFormat currencyFormat;

	public static String converteDecimalParaMascaraPorcentagem(Double valor) {
		String valorMascara = "";
		if (valor != null) {
			valor = valor * 100;
			if (valor < 10) {
				valorMascara = "00";
			} else if (valor < 100) {
				valorMascara = "0";
			}
			valorMascara = valorMascara + getCurrencyFormat().format(valor);
			if (!valorMascara.contains(",")) {
				valorMascara = valorMascara + ",00";
			}
			valorMascara = valorMascara + "%";
		}
		return valorMascara;
	}

	public static Double converteMascaraValorParaDecimal(String mascaraValor) {
		Double valor = null;
		String valorStr = retirarFormatacaoPorcentagem(mascaraValor);
		if (valorStr != null) {
			try {
				valor = Double.parseDouble(valorStr) / 100.0;
			} catch (Exception e) {}
		}
		return valor;
	}

	public static Double formatarParaValorDecimal(String valor) {
		Double valorDecimal = converteMascaraValorParaDecimal(valor);
		if (valorDecimal != null) {
			String numero = getCurrencyFormat().format(valorDecimal).toString();
			valorDecimal = Double.parseDouble(numero.replaceAll(",", "."));
		}
		return valorDecimal;
	}

	public static NumberFormat getCurrencyFormat() {
		if (currencyFormat == null) {
			currencyFormat = NumberFormat.getInstance();
			currencyFormat.setMaximumFractionDigits(4);
		}
		return currencyFormat;
	}

	public static String retirarFormatacaoPorcentagem(String valor) {
		String retorno = null;
		if ((valor != null) && !valor.isEmpty()) {
			retorno = valor.replaceAll("%", "").replaceAll(",", ".");
		}
		return retorno;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			valor = MascaraValorPercentualConverter.formatarParaValorDecimal(value);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			valor = MascaraValorPercentualConverter.converteDecimalParaMascaraPorcentagem((Double) value);
		}
		return valor;
	}

}
