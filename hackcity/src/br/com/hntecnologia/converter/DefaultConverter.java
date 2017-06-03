package br.com.hntecnologia.converter;

import java.lang.reflect.Method;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.infra.util.sistema.LogUtil;
import br.com.hntecnologia.negocio.usuario.Pojo;
import br.com.hntecnologia.negocio.usuario.PojoAudit;

@FacesConverter(value = "br.com.hntecnologia.converter.defaultConverter")
public class DefaultConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {

		if (value != null && !"".equals(value)) {

			PojoAudit entity = (PojoAudit) value;

			if (entity.getId() != null) {
				// adiciona item como atributo do componente
				this.addAttribute(component, entity);

				Long codigo = entity.getId();
				if (codigo != null) {
					return String.valueOf(codigo);
				}
			}

		}

		return "";
	}

	protected void addAttribute(UIComponent component, PojoAudit o) {
		String key = o.getId().toString(); // codigo da empresa como chave neste
											// caso
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
