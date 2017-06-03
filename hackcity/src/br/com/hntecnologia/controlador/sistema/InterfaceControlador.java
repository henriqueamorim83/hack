package br.com.hntecnologia.controlador.sistema;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;



public interface InterfaceControlador<Pojo> extends Serializable
{

	void salvar ( Pojo pojo )  ;

	void atualizar ( Pojo pojo ) ;

	void remover ( Pojo pojo ) ;

	Pojo buscarId ( Long codigo ) ;

	List<Pojo> listaAll () ;

	Integer countAll (Pojo pojo) ;

	List<Pojo> consultarEntidade (Pojo pojo, int first , int pageSize , String sortField ,
			SortOrder sortOrder , Map<String , Object> filters ) ;

}
