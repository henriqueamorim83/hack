package br.com.hntecnologia.persistence;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.primefaces.model.SortOrder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.ControleAcessoLogin;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.view.controleAcesso.UsuarioWeb;
import br.com.hntecnologia.view.service.TenantRoutingDataSource;



public abstract class PathDao<T>
{

	@PersistenceContext
	private EntityManager entityManager;
	
	 
	public abstract void salvar ( T pojo ) ;

	public abstract void atualizar ( T pojo ) ;

	public abstract void remover ( T pojo ) ;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public abstract List<T> listAll () ;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public abstract List<T> consultarEntidade (T pojo, int first , int pageSize ,
			String sortField , SortOrder sortOrder ,
			Map<String , Object> filters ) ;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public abstract Integer countAll (T pojo) ;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public abstract T buscar ( Long id ) ;

	
	public EntityManager getEntityManager ()
	{
		return entityManager;
	}

	public void setEntityManager ( EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}

	protected abstract Criteria createCriteria ();
	
	public Empresa getEmpresa() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			//System.out.println(TenantRoutingDataSource.getDatabase());
			if (authentication instanceof Authentication) {
				try{
					
				 
					if(((Usuario) authentication.getPrincipal())!=null  ){
					 Usuario usuario =((Usuario) authentication.getPrincipal());
					 //Empresa empresa = entityManager.find(Empresa.class, new Long(5001));					
					 TenantRoutingDataSource.setDatabase(((Usuario) authentication.getPrincipal()).getEmpresaSelecionada().getDatabase());				
					 return ((Usuario) authentication.getPrincipal()).getEmpresaSelecionada();
					  
					} 
					
				}catch(Exception e ){
					Empresa empresa = entityManager.find(Empresa.class, new Long(1));					
					 TenantRoutingDataSource.setDatabase(Constantes.DATABASE_MATRIZ);				
					 return empresa;
				}
			}
		}		 
		
		return null;
	}

	public Usuario getUsuario() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				Usuario usuario = new Usuario();
				usuario.setId(((Usuario) authentication.getPrincipal()).getId());
				usuario.setNome(((Usuario) authentication.getPrincipal()).getNome());
				usuario.setPassword(((Usuario) authentication.getPrincipal()).getPassword());
				
				 return usuario;
			}
		}		 
		
		return null;
	}
	 

}
