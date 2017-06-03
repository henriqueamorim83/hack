package br.com.hntecnologia.view.controleAcesso;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;


import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import net.sf.jasperreports.components.barcode4j.UPCAComponent;
import br. com.hntecnologia.fachada.Fachada;
import br. com.hntecnologia.infra.enumeration.ErroMessage;
import br. com.hntecnologia.infra.enumeration.Mensagem;
import br. com.hntecnologia.infra.exception.NegocioException;
import br. com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br. com.hntecnologia.infra.util.Util;
import br. com.hntecnologia.infra.util.constantes.Classes;
import br. com.hntecnologia.infra.util.constantes.Constantes;
import br. com.hntecnologia.infra.util.sistema.FacesUtils;
import br. com.hntecnologia.negocio.empresa.Empresa;
 
import br. com.hntecnologia.negocio.usuario.Perfil;
import br. com.hntecnologia.negocio.usuario.Usuario;
import br. com.hntecnologia.negocio.usuario.UsuarioEmpresa;
import br. com.hntecnologia.persistence.sistema.PerfilBC;
import br. com.hntecnologia.persistence.sistema.UsuarioBC;
import br. com.hntecnologia.view.EntidadeViewMB;
import br. com.hntecnologia.view.ImagemView;
import br. com.hntecnologia.view.validacao.ValidarEntidade;

@ManagedBean
@ViewScoped
public class UsuarioBean extends EntidadeViewMB<Usuario>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -303301032465629795L;

	private static final String SENHA_PADRAO = "123456";

	private Long id;

	private String loginAtual;

	private String novaSenha;

	private Usuario usuario = new Usuario();

	private String confirmacaoDeSenha;

	private Perfil role = new Perfil();

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private static final String ESTADO_DE_NOVO = "_novo";

	private static final String ESTADO_DE_EDICAO = "_edicao";

	private static final String ESTADO_DE_PESQUISA = "_pesquisa";

	private String state = ESTADO_DE_PESQUISA;

	private UIForm form;
	
	private List<Empresa> empresasSelecionadas;
	

	@ManagedProperty("#{fachada}")
	private Fachada fachada;

	@ManagedProperty("#{perfilBC}")
	private PerfilBC roleDao;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	 
	
	public Fachada getFachada() {
		return fachada;
	}
	


	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public PerfilBC getRoleDao() {
		return roleDao;
	}

	public FacesUtils getFacesUtils() {
		return facesUtils;
	}

	public void init () 
	{
		if (id != null)
		{
			usuario = fachada.buscarUsuarioId(id);
			setState(ESTADO_DE_EDICAO);
			id = null;
		}
	}

	public void resetPassword () 
	{
		Usuario usuario = fachada.buscarPorLogin(loginAtual);
		if (usuario == null)
		{
			adicionarMensagem(ErroMessage.ERROR_CADASTRO_USUARIO_NAO_ENCONTRADO);
			return;
		}
		try{
		usuario.setPassword(SENHA_PADRAO);
		fachada.atualizarUsuario(usuario);
		adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO, loginAtual);
		}catch(Exception e){
			adicionarMensagem(ErroMessage.ERROR_CADASTRO_ATUALIZAR,Classes.USUARIO);
		}

		loginAtual = null;
	}

	public void lista () 
	{
		//usuarios = fachada.listaAllUsuarios();
		listagem();
		setState(ESTADO_DE_PESQUISA);
		
	}

	
	
	
	
	public void preparaParaAdicionar ()
	{
		limpar();
		 
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_NOVO);
	}

	/*
	 * Todo usu�rio criado pelo sistema inicia com o PERFIL USU�RIO
	 */
	public void adiciona () throws Exception
	{
		
		 
			List<Perfil> roles = new ArrayList<Perfil>();
			roles.add(roleDao.load("OPERADOR"));
			usuario.setRoles(roles);
			usuario.setEnabled(true);
			usuario.setPassword(SENHA_PADRAO);
			
			if(Util.isListNaoNulaNaoVazia(getEmpresasSelecionadas())){
				for(Empresa emp : getEmpresasSelecionadas()){
					UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
					usuarioEmpresa.setEmpresaSelecionada(emp);
					usuario.getListaEmpresas().add(usuarioEmpresa);
				}
			}
			
			try{
			fachada.salvarUsuario(usuario);
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ADICIONADO_COM_SUCESSO,Classes.USUARIO);
			lista();
			}catch(Exception e){		
				
				adicionarMensagem(getFachada().logAtividadesErro(Constantes.INSERIR, e.getMessage(), ErroMessage.ERROR_CADASTRO_INSERIR,Classes.USUARIO).getDescricaoDoLog());
			}
	 
		
	}
		

	public void remove (Usuario usuario) 
	{
		try{
			setUsuario(getFachada().buscarUsuarioId(usuario.getId()));
		usuario.setEnabled(false);
		fachada.removerUsuario(usuario);
		adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_REMOVIDO_COM_SUCESSO,Classes.USUARIO);
		}catch(Exception e ){
			adicionarMensagem(getFachada().logAtividadesErro(Constantes.REMOVER, e.getMessage(), ErroMessage.ERROR_CADASTRO_REMOVER,Classes.USUARIO).getDescricaoDoLog());
		}
		
		lista();
	}
	
	public void limpar(){
		setLoginAtual("");
		setNovaSenha("");
		setConfirmacaoDeSenha("");
		setCurrentImageName("");
		setNewImageName("");
		setUsuario(new Usuario());
		
	}

	public void preparaParaAlterar ( Usuario usuario ) 
	{
		limpar();
		this.usuario =fachada.buscarUsuarioId(usuario.getId()) ; // evita
			
			if(this.usuario.getImagem()!=null){
				String nome =   Util.getRandomImageName()+".jpg";
				Util.salvarArquivos(this.usuario.getImagem(), nome);					
				setImagem(nome);
			}
			setEmpresasSelecionadas(new ArrayList<Empresa>());
			for(UsuarioEmpresa us : this.usuario.getListaEmpresas()){
				getEmpresasSelecionadas().add(us.getEmpresaSelecionada());
			}
			
		// LazyInitializationException
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_EDICAO);
	}

	public void alteraRole () 
	{
		List<Perfil> roles = new ArrayList<Perfil>();
		roles.add(role);
		usuario.setRoles(roles);
		try{
		fachada.atualizarUsuario(usuario);
		adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO,Classes.USUARIO);
		}catch(Exception e ){
			adicionarMensagem(getFachada().logAtividadesErro(Constantes.ATUALIZAR, e.getMessage(), ErroMessage.ERROR_CADASTRO_INSERIR,Classes.USUARIO).getDescricaoDoLog());
		}
		
		lista();
	}

	public void altera () 
	{
		 
		List<Perfil> roles = new ArrayList<Perfil>();
		roles.add(role);
		// usuario.setRoles(roles);
		
		try{
			if(Util.isStringNaoNulaNaoVazia(getImagem())){				
				FileInputStream ip = new FileInputStream(new File(getContext() + File.separator + "resources" + File.separator + "arquivos" + File.separator +getImagem()));
				usuario.setImagem(IOUtils.toByteArray(ip));			
			}
			//
			
			
			if(Util.isListNaoNulaNaoVazia(getEmpresasSelecionadas())){
			
				usuario.setListaEmpresas(new ArrayList<UsuarioEmpresa>());
				for(Empresa emps : getEmpresasSelecionadas()){
					UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
					usuarioEmpresa.setEmpresaSelecionada(emps);
					usuario.getListaEmpresas().add(usuarioEmpresa);
				}
			}
			
			
		fachada.atualizarUsuario(usuario);
		adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO, Classes.USUARIO);
		}catch(Exception e){
			adicionarMensagem(getFachada().logAtividadesErro(Constantes.ATUALIZAR, e.getMessage(), ErroMessage.ERROR_CADASTRO_ATUALIZAR,Classes.USUARIO).getDescricaoDoLog());	
		}
		lista();
		 
	}

	public void alteraPerfil () 
	{
		List<Perfil> roles = new ArrayList<Perfil>();
		roles.add(role);
		usuario.setRoles(roles);
		try{
		fachada.atualizarUsuario(usuario);
		adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO,Classes.USUARIO);
		lista();
		}catch(Exception e){
			adicionarMensagem(ErroMessage.ERROR_CADASTRO_ATUALIZAR, Classes.USUARIO);
		}
		
		
		
	}

	public void alteraLoginSenha () 
	{
		
		try{
			fachada.atualizarUsuario(usuario);
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO,Classes.USUARIO);
			lista();
			}catch(Exception e){
				adicionarMensagem(ErroMessage.ERROR_CADASTRO_ATUALIZAR, Classes.USUARIO);
			}
	}

	public void voltar () 
	{
		this.usuario = new Usuario();
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

	public List<Usuario> getUsuarios ()
	{
		return usuarios;
	}



	public void setRoleDao ( PerfilBC roleDao )
	{
		this.roleDao = roleDao;
	}

	public Usuario getUsuario ()
	{
		if(this.usuario==null){
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario ( Usuario usuario )
	{
		this.usuario = usuario;
	}

	public String getConfirmacaoDeSenha ()
	{
		return confirmacaoDeSenha;
	}

	public void setConfirmacaoDeSenha ( String confirmacaoDeSenha )
	{
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	public void setFacesUtils ( FacesUtils facesUtils )
	{
		this.facesUtils = facesUtils;
	}

	public void setUsuarios ( List<Usuario> usuarios )
	{
		this.usuarios = usuarios;
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

	public Perfil getRole ()
	{
		return role;
	}

	public void setRole ( Perfil role )
	{
		this.role = role;
	}

	public Long getId ()
	{
		return id;
	}

	public void setId ( Long id )
	{
		this.id = id;
	}

	public String getLoginAtual ()
	{
		return loginAtual;
	}

	public void setLoginAtual ( String loginAtual )
	{
		this.loginAtual = loginAtual;
	}

	public String getNovaSenha ()
	{
		return novaSenha;
	}

	public void setNovaSenha ( String novaSenha )
	{
		this.novaSenha = novaSenha;
	}

	
	   @PostConstruct
	   public void listagem() {
			try {
				setObjetos(new LazyDataModel<Usuario>() {

					/**
					 * 
					 */
					private static final long serialVersionUID = 8152736868979263988L;

					public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
							Map<String, Object> filters) {
						List<Usuario> lista = new ArrayList<Usuario>();
						
						 
						lista = fachada.consultarUsuario(getUsuario(), first, pageSize, sortField, sortOrder, filters);

						getObjetos().setRowCount(fachada.countAllUsuarios(getUsuario()));
						getObjetos().setPageSize(getObjetos().getPageSize() * 10);
						
						return lista;

					}
				});
			} catch (Exception e) {
				adicionarMensagem(getFachada().logAtividadesErro(Constantes.CONSULTAR, e.getMessage(), ErroMessage.ERROR_CADASTRO_CONSULTAR, Classes.CATEGORIA_PRODUTO).getDescricaoDoLog());

			}

		}



	
	
	public void fileUploadListener(FileUploadEvent event) throws IOException{		
			
		String path = getFachada().getServletContext().getRealPath("/");
		Util.salvarArquivos(event.getFile().getContents(),event.getFile().getFileName());		
		Util.redimensionaImg(new File(path+"resources/arquivos/"), 200, 200, event.getFile().getFileName());
		setImagem( event.getFile().getFileName());	
			//Util.salvarArquivos(event.getFile().getContents(),event.getFile().getFileName());
			//setCurrentImageName(event.getFile().getFileName());
	       
	}
	
	
	
	public void crop() {
        if(getCroppedImage() == null) {
            return;
        }         
        setNewImageName(Util.getRandomImageName() +".jpg");
        setImagem(getNewImageName());       
        String newFileName =getContext() + File.separator + "resources" + File.separator + "images" + File.separator + getNewImageName();
        Util.salvarArquivos(new File(newFileName), getCroppedImage().getBytes(), getCroppedImage().getBytes().length);
         
    }
     
	public String getFoto(){
		 
		if(usuarioLogado()!=null && usuarioLogado().getImagem()!=null) { 	
		setNewImageName(Util.getRandomImageName() +".jpg");
	              
	        String newFileName =getContext() + File.separator + "resources" + File.separator + "images" + File.separator + getNewImageName();
	        Util.salvarArquivos(new File(newFileName), usuarioLogado().getImagem(), usuarioLogado().getImagem().length);
	         return File.separator + "resources" + File.separator + "images" + File.separator + getNewImageName();
		}else if(usuarioLogado()!=null){
			
			return "/resources/images/avatar2.png";
		}
		
		 
		return " ";
	}
	
	 
	public List<Perfil> getListaPerfis(){
		return this.getRoleDao().listAll();
	}
	
	 


	public List<Empresa> getEmpresasSelecionadas() {
		return empresasSelecionadas;
	}



	public void setEmpresasSelecionadas(List<Empresa> empresasSelecionadas) {
		this.empresasSelecionadas = empresasSelecionadas;
	}

   public List<Empresa> listaEmpresas(){
	   List<Empresa> lista = getFachada().listagemEmpresa();
	    
	   return lista;
   }
	
}
