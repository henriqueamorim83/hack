package br.com.hntecnologia.persistence.sistema;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;
import br.com.hntecnologia.persistence.PathDao;

@Repository("UsuarioEmpresaBC")
@Transactional
public class UsuarioEmpresaBC extends PathDao<UsuarioEmpresa> {

	@Override
	public void salvar(UsuarioEmpresa pojo) {

		getEntityManager().persist(pojo);
	}

	@Override
	public void atualizar(UsuarioEmpresa pojo) {

		getEntityManager().merge(pojo);
	}

	@Override
	public void remover(UsuarioEmpresa pojo) {
		getEntityManager().merge(pojo);

	}

	@Override
	public List<UsuarioEmpresa> listAll( ) {

		return getEntityManager().createQuery("from UsuarioEmpresa where ativo=true", UsuarioEmpresa.class).getResultList();
	}

	@Override
	public List<UsuarioEmpresa> consultarEntidade(UsuarioEmpresa pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		 
		return null;
	}

	@Override
	public Integer countAll(UsuarioEmpresa pojo) {
	 
		return null;
	}

	@Override
	public UsuarioEmpresa buscar(Long id ) {

		return getEntityManager().find(UsuarioEmpresa.class, id);
	}

	@Override
	protected Criteria createCriteria() {
		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(UsuarioEmpresa.class);
	}
	
	public List<UsuarioEmpresa> listagemEmpresasPorUsuario(Usuario usuario){
		String sql =" select p from UsuarioEmpresa p where p.ativo=true and p.usuario.id=:IdUsuario";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("IdUsuario", usuario.getId());
		return query.getResultList();
	}

}
