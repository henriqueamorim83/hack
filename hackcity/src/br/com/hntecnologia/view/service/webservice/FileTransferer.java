package br.com.hntecnologia.view.service.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.stereotype.Controller;
 
/**
 * A web service endpoint interface.
 * @author www.codejava.net
 *
 */
 
@WebService
public interface FileTransferer {
	
	 
	public void salvar(String texto);
	
	  
	
}