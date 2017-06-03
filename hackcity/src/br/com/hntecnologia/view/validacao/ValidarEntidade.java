package br.com.hntecnologia.view.validacao;

import java.util.ArrayList;
import java.util.List;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.usuario.Usuario;
 

public class ValidarEntidade {

	 

	public static List<ErroMessage> validarCnpjCpf(String documento) {

		List<ErroMessage> retorno = new ArrayList<ErroMessage>();
		List<String> cnpjs = new ArrayList<String>();
		cnpjs.add("00.000.000/0000-00");
		cnpjs.add("11.111.111/1111-11");
		cnpjs.add("22.222.222/2222-22");
		cnpjs.add("33.333.333/3333-33");
		cnpjs.add("44.444.444/4444-44");
		cnpjs.add("55.555.555/5555-55");
		cnpjs.add("66.666.666/6666-66");
		cnpjs.add("77.777.777/7777-77");
		cnpjs.add("88.888.888/8888-88");
		cnpjs.add("99.999.999/9999-99");

		for (String cnpj : cnpjs) {
			if (cnpj.equalsIgnoreCase(documento)) {
				retorno.add(ErroMessage.ERRO_VALIDACAR_CPF_CNPJ);
			}
		}
		List<String> cpfs = new ArrayList<String>();
		cpfs.add("000.000.000-00");
		cpfs.add("111.111.111-11");
		cpfs.add("222.222.222-22");
		cpfs.add("333.333.333-33");
		cpfs.add("444.444.444-44");
		cpfs.add("555.555.555-55");
		cpfs.add("666.666.666-66");
		cpfs.add("888.888.888-88");
		cpfs.add("999.999.999-99");
		for (String cpf : cpfs) {
			if (cpf.equalsIgnoreCase(documento)) {
				retorno.add(ErroMessage.ERRO_VALIDACAR_CPF_CNPJ);
			}
		}

		return retorno;
	}
 
	 
	
}
