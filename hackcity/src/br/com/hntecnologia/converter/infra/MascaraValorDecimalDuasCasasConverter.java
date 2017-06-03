package br.com.hntecnologia.converter.infra;


import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.Util;



@FacesConverter(value = "mascaraValorDecimalDuasCasasConverter")
public class MascaraValorDecimalDuasCasasConverter implements Converter {

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
			currencyFormat.setMaximumFractionDigits(2);
			valorMascara = currencyFormat.format(valor);
		}
		return valorMascara;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			String v = (String)value;
			v = v.replace(",", ".");
			valor = new BigDecimal(Double.valueOf(v));
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			String retorno =  String.valueOf(value);
			retorno = retorno.replace(".0", "");
			valor = retorno;
		}
		return valor;
	}

}