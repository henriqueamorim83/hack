package br.com.hntecnologia.converter.infra;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "mascaraValorBigDecimalQuatroCasasConverter")
public class MascaraValorBigDecimalQuatroCasasConverter implements Converter {

	/**
	 * Converte um double para string com mascara de valor
	 * 
	 * @param valor Double que deseja-se formatar
	 * @return Valor com mascara
	 */
	public static String formatarDoubleParaMascaraValorQuatroCasas(Double valor) {
		String valorMascara = "";
		if (valor != null) {
			NumberFormat currencyFormat = NumberFormat.getInstance();
			currencyFormat.setGroupingUsed(true);
			currencyFormat.setMinimumFractionDigits(1);
			currencyFormat.setMaximumFractionDigits(4);
			valorMascara = currencyFormat.format(new BigDecimal(valor));
		}
		return valorMascara;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			valor = value.replace(",", ".");
			valor = new BigDecimal(String.valueOf(valor));
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			valor = MascaraValorDecimalQuatroCasasConverter.formatarDoubleParaMascaraValorQuatroCasas(new BigDecimal(value.toString()));
		}
		return valor;
	}

}