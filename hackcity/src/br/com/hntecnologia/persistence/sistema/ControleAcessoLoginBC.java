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

import br.com.hntecnologia.negocio.usuario.ControleAcessoLogin;

 

@Repository("controleAcessoLoginBC")
@Transactional
public class ControleAcessoLoginBC {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ControleAcessoLogin> listAll ()
	{
		return entityManager.createQuery("from ControleAcessoLogin" , ControleAcessoLogin.class).getResultList();
	}

	public void save ( ControleAcessoLogin controleAcessoLogin )
	{
		entityManager.persist(controleAcessoLogin);
	}

	public void update ( ControleAcessoLogin controleAcessoLogin )
	{
		delete(controleAcessoLogin);
		save(controleAcessoLogin);
		 
	}

	public void delete ( ControleAcessoLogin controleAcessoLogin )
	{
		entityManager.remove(controleAcessoLogin);
	}

	 

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ControleAcessoLogin load ( String id )
	{
		return entityManager.find(ControleAcessoLogin.class , id);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ControleAcessoLogin buscar(Long idUsuario){
		String sql ="select u from ControleAcessoLogin u  where u.idUsuario=:Usuario    ";
		
		Query query  =this.entityManager.createQuery(sql);
		query.setParameter("Usuario", idUsuario);
		List<ControleAcessoLogin> lista = query.getResultList();
		return lista.size()==1?lista.get(0):null;
	}
	
	 
	public List<ControleAcessoLogin> consultarEntidade(ControleAcessoLogin t, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters)  {
		String sql ="select u from ControleAcessoLogin u      ";
		Query query  =this.entityManager.createQuery(sql);
		
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	 
	public Integer countAll(ControleAcessoLogin pojo )  {
		String sql ="select u from ControleAcessoLogin u      ";
		Query query  =this.entityManager.createQuery(sql);		
		 
		return query.getResultList().size();
	}
}
