package br.com.hntecnologia.persistence.sistema;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hntecnologia.negocio.usuario.Perfil;
import br.com.hntecnologia.negocio.usuario.Usuario;;

@Repository("perfilBC")
@Transactional
public class PerfilBC
{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Perfil> listAll ()
	{
		return entityManager.createQuery("from Perfil" , Perfil.class).getResultList();
	}

	public void save ( Perfil Perfil )
	{
		entityManager.merge(Perfil);
	}

	public void update ( Perfil Perfil )
	{
		entityManager.merge(Perfil);
	}

	public void delete ( Perfil Perfil )
	{
		entityManager.remove(entityManager.merge(Perfil));
	}

	public List<Perfil> getListaPerfis ()
	{
		return listAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Perfil load ( String id )
	{
		return entityManager.find(Perfil.class , id);
	}
	
	
	 
	public List<Perfil> consultarEntidade(Perfil t, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters)  {
		String sql ="select u from Perfil u      ";
		Query query  =this.entityManager.createQuery(sql);
		
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	 
	public Integer countAll(Perfil pojo )  {
		String sql ="select u from Perfil u      ";
		Query query  =this.entityManager.createQuery(sql);		
		 
		return query.getResultList().size();
	}
}
