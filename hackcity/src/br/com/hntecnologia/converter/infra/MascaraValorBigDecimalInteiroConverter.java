package br.com.hntecnologia.converter.infra;
import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.Util;
;

@FacesConverter(value = "mascaraValorBigDecimalInteiroConverter")
public class MascaraValorBigDecimalInteiroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object valor = null;
		if (value != null) {
			String resultado="";
			char[] text = value.toCharArray();
			for(int i=0;i<text.length;i++){
				if(text[i]==','){
					break;
				}else{
					resultado+=text[i];
				}
			}
			
			valor = new BigDecimal(Integer.valueOf(resultado));///Util.converteMascaraValorParaBigDecimal(value);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String valor = null;
		if ((value != null)) {
			BigDecimal big = (BigDecimal) value;
			valor =  String.valueOf(big.intValue()); //Util.formatarBigDecimalParaMascaraValor((BigDecimal) value);
		}
		return valor;
	}

}
