package br.com.hntecnologia.converter.sistema;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.persistence.sistema.UsuarioBC;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	protected void addAttribute(final UIComponent component, final Usuario o) {
		String key = "";
		if (o.getId() != null) {
			key = o.getId().toString();
		}
		getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(final UIComponent component) {
		return component.getAttributes();
	}

	public Object getAsObject(final FacesContext context,
			final UIComponent component, final String value) {
		if (value != null) {
			return getAttributesFrom(component).get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {

		String strValue = null;
		if ((value != null) && !"".equals(value)) {
			Usuario entity = (Usuario) value;
			addAttribute(component, entity);

			Object codigo = entity.getId();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return strValue;
	}
}
