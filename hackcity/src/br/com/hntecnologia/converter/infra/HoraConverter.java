package br.com.hntecnologia.converter.infra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;


@FacesConverter(value = "horaConverter")
public class HoraConverter implements Converter {

	private SimpleDateFormat format = new SimpleDateFormat("HH:mm");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			if ((value != null) && !value.isEmpty()) {
				int indexHora = value.indexOf(":");
				String substringHora = value.substring(0, indexHora);
				int hora = Integer.parseInt(substringHora);
				int min = Integer.parseInt(value.substring(indexHora + 1));
				Map<String, Object> atributos = component.getAttributes();

				 String[] retorno = new String[2];
				 retorno[0]=atributos.get("label").toString();
				 retorno[1]=value;				  
				String msg = InformarMensagem.getInstancia().Mensagem(ErroMessage.ERROR_DATA_HORA_INVALIDA,retorno);

			 
				if ((hora > 23) || (min > 59)) { throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "")); }
			}
			return format.parse(value);

		} catch (ParseException e) {
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return format.format((Date) value);
	}

}