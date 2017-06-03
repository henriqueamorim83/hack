package br.com.hntecnologia.converter.infra;
import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.Util;
;

@FacesConverter(value = "mascaraValorBigDecimalConverter")
public class MascaraValorBigDecimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			valor = Util.converteMascaraValorParaBigDecimal(value);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			valor = Util.formatarBigDecimalParaMascaraValor((BigDecimal) value);
		}
		return valor;
	}

}
