package br.com.hntecnologia.converter.infra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "dataConverter")
public class DataConverter implements Converter {

	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			if ((value != null) && !value.isEmpty()) {
				int indexDia = value.indexOf("/");
				String substringDia = value.substring(0, indexDia);
				int dia = Integer.parseInt(substringDia);

				String value2 = value.substring(indexDia + 1);

				int indexMes = value2.indexOf("/");
				String substringMes = value2.substring(0, indexMes);
				int mes = Integer.parseInt(substringMes);

				Map<String, Object> atributos = component.getAttributes();

				if ((dia > 31) || (mes > 12)) { 
					throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, atributos.get("label")
						+ ": Não é possível reconhecer '" + value + "' como uma data.", "")); 
					
				}
				
				
				
				
			}
			return format.parse(value);
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return format.format((Date) value);
	}

}