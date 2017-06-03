package br.com.hntecnologia.converter.infra;


import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.Util;



@FacesConverter(value = "mascaraValorDecimalTresCasasConverter")
public class MascaraValorDecimalTresCasasConverter implements Converter {

	/**
	 * Converte um double para string com mascara de valor
	 * 
	 * @param valor Double que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static String formatarDoubleParaMascaraValorQuatroCasas(BigDecimal valor) {
		String valorMascara = "";
		if (valor != null) {
			NumberFormat currencyFormat = NumberFormat.getInstance();
			currencyFormat.setGroupingUsed(true);
			currencyFormat.setMinimumFractionDigits(1);
			currencyFormat.setMaximumFractionDigits(3);
			valorMascara = currencyFormat.format(valor);
		}
		return valorMascara;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			valor = new BigDecimal(value);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			valor = MascaraValorDecimalTresCasasConverter.formatarDoubleParaMascaraValorQuatroCasas((BigDecimal) value);
		}
		return valor;
	}

}