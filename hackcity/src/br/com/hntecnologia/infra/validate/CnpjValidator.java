package br.com.hntecnologia.infra.validate;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

import br.com.hntecnologia.infra.util.Util;

@FacesValidator(value = "cnpjValidator")
public class CnpjValidator implements Validator
{

	public static final String CNPJ_INVALIDO = "br.com.banksystem.validator.cnpj.invalido";

	@Override
	public void validate ( FacesContext context , UIComponent component ,
			Object value ) throws ValidatorException
	{
		if (ValidatorUtil.check(context))
		{
			if ((context == null) || (component == null))
			{
				throw new NullPointerException();
			}
			if (value != null)
			{
				String converted = String.valueOf(value);
				converted = converted.replaceAll("_" , "");
				boolean validacaoCNPJ = Util.validacaoCNPJ(converted);
				if (!validacaoCNPJ)
				{
					throw new ValidatorException(MessageFactory.getMessage(
							context , CNPJ_INVALIDO , converted ,
							MessageFactory.getLabel(context , component)));
				}
			}
		}
	}
}
