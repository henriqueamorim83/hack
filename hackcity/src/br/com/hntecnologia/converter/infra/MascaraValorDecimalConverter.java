package br.com.hntecnologia.converter.infra;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.Util;
;

@FacesConverter(value = "mascaraValorDecimalConverter")
public class MascaraValorDecimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			valor = Util.converteMascaraValorParaDouble(value);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = "0";
		if ((value != null && Double.valueOf(""+value)>0)) {
			valor = Util.formatarDoubleParaMascaraValor((Double) value);
		}
		return valor;
	}

}
