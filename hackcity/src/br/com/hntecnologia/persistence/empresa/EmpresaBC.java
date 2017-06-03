package br.com.hntecnologia.persistence.empresa;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.persistence.PathDao;

@Repository("empresaBC")
@Transactional
public class EmpresaBC extends PathDao<Empresa>{


	@Override
	public void salvar(Empresa pojo)  {
		
		getEntityManager().persist(pojo);
	}

	@Override
	public void atualizar(Empresa pojo)  {
		
		getEntityManager().merge(pojo);
	}

	@Override
	public void remover(Empresa pojo)  {
		getEntityManager().merge(pojo);
		
	}

 

	@Override
	public List<Empresa> consultarEntidade(Empresa pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters)  {
		String sql = "select p from Empresa p where p.ativo=true  ";
	 
		Query query = getEntityManager().createQuery(sql);
		 
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public Integer countAll(Empresa pojo)  {
		String sql = "select p from Empresa p where p.ativo=true  ";
		
		Query query = getEntityManager().createQuery(sql);
		 
		return query.getResultList().size();
	}

 

	@Override
	protected Criteria createCriteria() {
		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(Empresa.class);
	}

	

	@Override
	public List<Empresa> listAll( ) {
		String sql = "select p from Empresa p where p.ativo=true order by p.id asc";		
		Query query = getEntityManager().createQuery(sql);
		List<Empresa> lista =  query.getResultList();
		
		return lista;
	}


	@Override
	public Empresa buscar(Long id ) {
	 
		Empresa empresa = getEntityManager().find(Empresa.class, id);
		
		return   empresa;
	}

}




