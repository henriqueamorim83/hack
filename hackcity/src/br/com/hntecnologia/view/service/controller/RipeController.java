package br.com.hntecnologia.view.service.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.hntecnologia.infra.util.Util;
 
 
import br.com.hntecnologia.fachada.Fachada;

@Controller
public class RipeController {

	public static final String EXEMPLO = "/rest/{key}";
	public static final String CADASTRO_PEDIDO = "/pedido/{pedido}";
	public static final String SALVAR_PEDIDO = "/compra_pedido/{pedido}";
	public static final String ULTIMO_PRECO = "/codigo_produto/{codigo}";
	  
	
	 
	 
	
	@RequestMapping(value = CADASTRO_PEDIDO, method = RequestMethod.GET)
	public @ResponseBody String getPedido(@PathVariable("pedido") String pedido) {
		String resultado="";
		  
		if(pedido!=null){
			resultado=pedido;
		}else{
			resultado="nada";
		}
		
		return resultado;
	}
	
	
	
	 
	
	
	
	 
	
	
}
