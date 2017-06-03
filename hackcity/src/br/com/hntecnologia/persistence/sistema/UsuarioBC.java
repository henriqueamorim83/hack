package br.com.hntecnologia.persistence.sistema;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.Perfil;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.persistence.PathDao;

@Repository("usuarioBC")
@Transactional
public class UsuarioBC extends PathDao<Usuario>
{

	@PersistenceContext
	private EntityManager entityManager;

	 

	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario buscarPorLogin ( String login ) 
	{
		
		String sql ="select u from Usuario u where u.ativo=true AND upper(u.username)=:Name   ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("Name", login.toUpperCase());
	 
		return (Usuario) query.getSingleResult();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario logar ( String login , String senha ) 
	{
		String sql ="select u from Usuario u where u.ativo=true AND upper(u.username)=:Name and u.password=:Password   ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("Name", login.toUpperCase());
		query.setParameter("Password", senha);
	 
		return (Usuario) query.getSingleResult();
	}

	 
	

	protected  Criteria createCriteria ()
	{
		Session session = ((Session) entityManager.getDelegate());
		return session.createCriteria(Usuario.class);
	}

	@Override
	public void salvar(Usuario bean)  {
		this.entityManager.persist(bean);
		
	}

	@Override
	public void atualizar(Usuario bean)  {
		this.entityManager.merge(bean);
		
	}

	@Override
	public void remover(Usuario bean)  {
		this.entityManager.merge(bean);
		
	}

	@Override
	public List<Usuario> consultarEntidade(Usuario pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters)  {
		String sql ="select u from Usuario u where u.ativo=true   ";
		Query query  =getEntityManager().createQuery(sql);
		 
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	@Override
	public Integer countAll(Usuario pojo )  {
		String sql ="select u from Usuario u where u.ativo=true   ";
		Query query  =getEntityManager().createQuery(sql);		
	//	query.setParameter("IDEmpresa", getEmpresa().getId());
		return query.getResultList().size();
	}

	

	public List<Usuario> listAll() {
		String sql = "select p from Usuario p where p.ativo=true  ";
		Query query = getEntityManager().createQuery(sql);
	 
		return query.getResultList();
	}

	@Override
	public Usuario buscar(Long id  ) {
		  return entityManager.find(Usuario.class , id);
	}
	
	
	public List<Object> resultado(String objeto){
		String sql = "select p from "+objeto +" p";
		Query query =getEntityManager().createQuery(sql);
	    return query.getResultList();
	}
	
	public void salvarObjeto(Object objeto){
		getEntityManager().merge(objeto);
	}
	
}
