package br.com.hntecnologia.infra.validate;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ValidatorUtil
{

	private static final String VALIDATE = "VALIDATE";

	public static final String KEY_VALIDAR = "NAO_VALIDAR";

	public static boolean check ()
	{
		return check(FacesContext.getCurrentInstance());
	}

	public static boolean check ( final FacesContext context )
	{
		final ExternalContext externalContext = context.getExternalContext();
		final Object validate = externalContext.getRequestMap().get(VALIDATE);
		if (validate != null)
		{
			return (Boolean) validate;
		}
		for ( final Map.Entry<String , String[]> requestParameters : externalContext
				.getRequestParameterValuesMap().entrySet())
		{
			final String key = requestParameters.getKey();
			if (key.contains(KEY_VALIDAR))
			{
				externalContext.getRequestMap().put(VALIDATE , Boolean.FALSE);
				return false;
			}
		}
		externalContext.getRequestMap().put(VALIDATE , Boolean.TRUE);
		return true;
	}

}
