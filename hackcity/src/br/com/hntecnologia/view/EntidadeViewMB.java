package br.com.hntecnologia.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;


import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

 

import br.com.hntecnologia.fachada.Fachada;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.util.Biblioteca;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.infra.util.sistema.FacesUtils;
 
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.view.controleAcesso.LoginBean;
import br.com.hntecnologia.view.controleAcesso.UsuarioWeb;
 
 

public abstract class EntidadeViewMB<T> extends ImagemView implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4197133076727100610L;

	public static final String ESTADO_DE_EDICAO = "_edicao";

	public static final String ESTADO_DE_VISUALIZAR = "_vizualizar";

	public static final String ESTADO_DE_PESQUISA = "_pesquisa";

	public static final String ESTADO_DE_NOVO = "_inserir";

	public String state = ESTADO_DE_PESQUISA;
	

	private static final String ESTADO_LOGIN = "_login";

	private LazyDataModel<T> objetos;

	@ManagedProperty("#{fachada}")
	private Fachada fachada;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	@ManagedProperty("#{usuarioWeb}")
	private UsuarioWeb usuarioWeb;
	
	private InformarMensagem informarMensagem;
	
	@Autowired
	private
	ServletContext servletContext;
	
	private UIForm form;
 
	 
	
	public void adicionarMensagem(Mensagem mensagem,String classe){
		String retorno = getInformarMensagem().Mensagem(mensagem, classe);
		getFacesUtils().adicionaMensagemDeInformacao(retorno);
	}
	
	public void adicionarMensagem(Mensagem mensagem){
		getFacesUtils().adicionaMensagemDeInformacao(getInformarMensagem().Mensagem(mensagem));
	}
	public void adicionarMensagemDeAlerta(Mensagem mensagem){
		getFacesUtils().adicionaMensagemDeAlerta(getInformarMensagem().Mensagem(mensagem));
	}
	
	public void adicionarMensagemDeAlerta(String mensagem){
		getFacesUtils().adicionaMensagemDeAlerta(mensagem);
	}
	
	public void adicionarMensagemDeAlerta(Mensagem mensagem,String descricao){
		getFacesUtils().adicionaMensagemDeAlerta(getInformarMensagem().Mensagem(mensagem,descricao));
	}
	public void adicionarMensagem(List<Mensagem> mensagens){
		List<String> lista = new ArrayList<String>();
		for(Mensagem mensagem : mensagens){
			lista.add(getInformarMensagem().Mensagem(mensagem));
		}
		getFacesUtils().adicionaMensagemDeInformacao(lista);
	}
	public void adicionarMensagenTexto(List<String> lista){		 
		getFacesUtils().adicionaMensagemDeInformacao(lista);
	}
	public void adicionarMensagem(String mensagem){
		getFacesUtils().adicionaMensagemDeInformacao(mensagem);
	}
	
	public void adicionarMensagem(ErroMessage mensagem){
		getFacesUtils().adicionaMensagemDeErro(getInformarMensagem().Mensagem(mensagem));
	}
	public void adicionarMensagem(ErroMessage mensagem,String classe){
		getFacesUtils().adicionaMensagemDeErro(getInformarMensagem().Mensagem(mensagem,classe));
	}
	
	
	
	public void adicionarMensagens(List<ErroMessage> mensagens){
		List<String> lista = new ArrayList<String>();
		for(ErroMessage mensagem : mensagens){
			lista.add(getInformarMensagem().Mensagem(mensagem));
		}
		getFacesUtils().adicionaMensagemDeErro(lista);
	}
	
	public static void downloadArquivo(File file, String nomeArquivo) throws Exception {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.setResponseHeader("Content-Type", "text/plain");
		externalContext.setResponseHeader("Content-Length", String.valueOf(file.length()));
		externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + nomeArquivo + "\"");
		externalContext.getResponseOutputStream().write(Biblioteca.getBytesFromFile(file));
		facesContext.responseComplete();
	}
	
	public void downloadFile(File file,String nomeArquivo) {   
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
	    response.setHeader("Content-Disposition", "attachment;filename="+nomeArquivo);
	    response.setContentLength((int) file.length());
	    FileInputStream input= null;
	    try {
	        int i= 0;
	        input = new FileInputStream(file);  
	        byte[] buffer = new byte[1024];
	        while ((i = input.read(buffer)) != -1) {  
	            response.getOutputStream().write(buffer);  
	            response.getOutputStream().flush();  
	        }               
	        facesContext.responseComplete();
	        facesContext.renderResponse();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(input != null) {
	                input.close();
	            }
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static boolean isUserInRole(String role) {
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
	}
	
	public InformarMensagem getInformarMensagem() {
		if(informarMensagem == null){
			informarMensagem = new InformarMensagem();
		}
		return informarMensagem;
	}

	public void setInformarMensagem(InformarMensagem informarMensagem) {
		this.informarMensagem = informarMensagem;
	}

	public Fachada getFachada ()
	{
		return fachada;
	}

	public void setFachada ( Fachada fachada )
	{
		this.fachada = fachada;
	}

	public FacesUtils getFacesUtils ()
	{
		return facesUtils;
	}

	public void setFacesUtils ( FacesUtils facesUtils )
	{
		this.facesUtils = facesUtils;
	}

	public UIForm getForm ()
	{

		return form;
	}

	public void setForm ( UIForm form )
	{
		this.form = form;
	}

	public String getState ()
	{
		return state;
	}

	public void setState ( String state )
	{
		this.state = state;
	}

	public boolean isAdicionando ()
	{

		return ESTADO_DE_NOVO.equals(getState());
	}

	public boolean isEditando ()
	{
		return ESTADO_DE_EDICAO.equals(getState());
	}

	public boolean isPesquisando ()
	{
		return ESTADO_DE_PESQUISA.equals(getState());
	}

	public boolean isVisualizando ()
	{
		return ESTADO_DE_VISUALIZAR.equals(getState());
	}

	public LazyDataModel<T> getObjetos ()
	{
		return objetos;
	}

	public void setObjetos ( LazyDataModel<T> objetos )
	{
		this.objetos = objetos;
	}

	/**
	 * 
	 * @author Henrique
	 * @return Usuárioo
	 * 
	 * 
	 */
	public static  Usuario usuarioLogado() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				try{
				return ((Usuario) authentication.getPrincipal());
				}catch(Exception e){
					LoginBean login = new LoginBean();
					login.logout();				 
				}
			}
		}
		return null;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	
	 
	
}
