package br.com.hntecnologia.converter.sistema;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.hntecnologia.fachada.Fachada;
  
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;
 

@FacesConverter(forClass = UsuarioEmpresa.class,value="usuarioEmpresaConverter")
public class UsuarioEmpresaConverter implements Converter {

	@Override
	  public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
      if (!submittedValue.trim().equals("")) {           
   
          try {
              Long number = Long.valueOf(submittedValue);

              Fachada fachada=  (Fachada) facesContext.getApplication().evaluateExpressionGet(facesContext,"#{fachada}", Fachada.class);
              return fachada.buscarUsuarioEmpresa(number);
              
             
          } catch(NumberFormatException exception) {
              throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
          }
      }
      return null;

   
  }

  public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
    String valor = "";
  	if (value != null ) {
  		UsuarioEmpresa categoria = (UsuarioEmpresa) value;
  		if(categoria.getId() != null){
      	 valor = categoria.getId().toString();
  		}
      } 
  	return valor;
  }
}
