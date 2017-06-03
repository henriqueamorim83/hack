package br.com.hntecnologia.converter.sistema;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.negocio.usuario.Perfil;
import br.com.hntecnologia.persistence.sistema.PerfilBC;
import br.com.hntecnologia.persistence.sistema.PerfilBC;


@FacesConverter(forClass = Perfil.class)
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {

		if (value == null)
			return null;		

		PerfilBC dao = (PerfilBC) ctx.getApplication().evaluateExpressionGet(ctx,"#{perfilBC}", PerfilBC.class);

		Perfil role = dao.load(value);
		return role;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {

		if (value == null) {
			return null;
		}

		Perfil role = (Perfil) value;
		return role.getName();
	}

}
