package br.com.hntecnologia.view.controleAcesso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIForm;

import org.apache.poi.ss.formula.functions.T;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.infra.util.sistema.FacesUtils;
import br.com.hntecnologia.negocio.usuario.Perfil;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.persistence.sistema.PerfilBC;

@ViewScoped
@ManagedBean
public class RoleBean
{

	private Perfil role = new Perfil();

	private List<Perfil> roles = new ArrayList<Perfil>();

	private static final String ESTADO_DE_NOVO = "_novo";

	private static final String ESTADO_DE_EDICAO = "_edicao";

	private static final String ESTADO_DE_PESQUISA = "_pesquisa";

	private String state = ESTADO_DE_PESQUISA;

	private UIForm form;

	@ManagedProperty("#{perfilBC}")
	private PerfilBC roleDao;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;
	
	private LazyDataModel<Perfil> objetos;

	public void lista ()
	{
		roles = roleDao.listAll();
		for(Perfil p : roles){
			if(p.getName().equalsIgnoreCase("SORAYA")){
				roles.remove(p);
				break;
			}
		}
		
		setState(ESTADO_DE_PESQUISA);
	}

	public void preparaParaAdicionar ()
	{
		this.role = new Perfil();
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_NOVO);
	}

	/*
	 * Todo usu�rio criado pelo sistema inicia com o PERFIL USU�RIO
	 */
	public void adiciona ()
	{
		roleDao.save(role);
		facesUtils
				.adicionaMensagemDeInformacao("Perfil adicionado com sucesso!");
		lista();
	}

	public void remove (Perfil role)
	{
		roleDao.delete(role);
		facesUtils.adicionaMensagemDeInformacao("Perfil removido com sucesso!");
		lista();
	}

	public void preparaParaAlterar ( Perfil role )
	{
		this.role = roleDao.load(role.getName()); // evita
													// LazyInitializationException
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_EDICAO);
	}

	public void altera ()
	{

		roleDao.update(role);
		facesUtils
				.adicionaMensagemDeInformacao("Perfil atualizado com sucesso!");
		lista();
	}

	public void voltar ()
	{
		this.role = new Perfil();
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		lista();
	}

	public boolean isAdicionando ()
	{
		return ESTADO_DE_NOVO.equals(state);
	}

	public boolean isEditando ()
	{
		return ESTADO_DE_EDICAO.equals(state);
	}

	public boolean isPesquisando ()
	{
		return ESTADO_DE_PESQUISA.equals(state);
	}

	public void setRoleDao ( PerfilBC roleDao )
	{
		this.roleDao = roleDao;
	}

	public void setFacesUtils ( FacesUtils facesUtils )
	{
		this.facesUtils = facesUtils;
	}

	public String getState ()
	{
		return state;
	}

	public void setState ( String state )
	{
		this.state = state;
	}

	public UIForm getForm ()
	{
		return form;
	}

	public void setForm ( UIForm form )
	{
		this.form = form;
	}

	public List<Perfil> getRoles ()
	{
		return roles;
	}

	public void setRoles ( List<Perfil> roles )
	{
		this.roles = roles;
	}

	public Perfil getRole ()
	{
		return role;
	}

	public void setRole ( Perfil role )
	{
		this.role = role;
	}
	
	@PostConstruct
	public void listagem() {
		try {
			setObjetos(new LazyDataModel<Perfil>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 8152736868979263988L;

				public List<Perfil> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<Perfil> lista = new ArrayList<Perfil>();
					
					
					lista = roleDao.listAll();
					for(Perfil p : lista){
						if(p.getName().equalsIgnoreCase("SORAYA")){
							lista.remove(p);
							break;
						}
					}
					getObjetos().setRowCount(lista.size());
					getObjetos().setPageSize(getObjetos().getPageSize() * 10);
					
					return lista;

				}
			});
		} catch (Exception e) {
			

		}

	}

	public LazyDataModel<Perfil> getObjetos() {
		return objetos;
	}

	public void setObjetos(LazyDataModel<Perfil> objetos) {
		this.objetos = objetos;
	}


}
