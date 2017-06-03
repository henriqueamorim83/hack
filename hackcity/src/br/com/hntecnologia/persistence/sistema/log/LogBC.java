package br.com.hntecnologia.persistence.sistema.log;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hntecnologia.infra.registroAtividades.LogAtividades;
import br.com.hntecnologia.infra.registroAtividades.LogErroSistema;

@Repository("logBC")
@Transactional
public class LogBC {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvarLogAtividade(LogAtividades logs){		
		this.entityManager.merge(logs);
	}
	
	public void salvarLogErro(LogErroSistema logs){
		this.entityManager.merge(logs);
	}
	
	
	
	
}
