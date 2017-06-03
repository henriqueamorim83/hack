package br.com.hntecnologia.view.controleAcesso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.hntecnologia.fachada.Fachada;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.ControleAcessoLogin;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;
import br.com.hntecnologia.persistence.sistema.ControleAcessoLoginBC;
import br.com.hntecnologia.persistence.sistema.UsuarioBC;
import br.com.hntecnologia.view.EntidadeViewMB;
import br.com.hntecnologia.view.service.AuthenticationService;
import br.com.hntecnologia.view.service.TenantRoutingDataSource;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.infra.util.sistema.Bootstrap;
import br.com.hntecnologia.infra.util.sistema.FacesUtils;
import br.com.hntecnologia.infra.util.sistema.UsuarioUtil;


@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean extends EntidadeViewMB<Usuario>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3521099371838081438L;

	private static final String CLIENTE = "/pages/cliente/pedido/pedido?faces-redirect=true";
	
	private static final String SUPRIMENTOS = "/pages/suprimentos/index?faces-redirect=true";
	
	private static final String MICHELLE = "/pages/michelle/index?faces-redirect=true";
		
	private static final String INDEX = "/pages/index?faces-redirect=true";

	private static final String LOGIN = "/auth/login?faces-redirect=true";
	
	private static final String EMPRESA="/pages/usuario/selecionarEmpresa?faces-redirect=true";
	
	private static final String SENHA_PADRAO = "123456";

	private static final String ESTADO_PRIMEIRO_ACESSO = "_primeiroLogin";

	private static final String ESTADO_LOGIN = "_login";

	private String state = ESTADO_LOGIN;

	private String login;

	private String senha;

	private String loginAtual;

	private String senhaAtual;

	private String novoLogin = "";

	private String novaSenha;

	private String confirmacaoDeSenha;

	private boolean senhaPadrao = false;
	
	private Empresa empresa;

	@ManagedProperty("#{authenticationService}")
	private AuthenticationService authenticationService;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	@ManagedProperty("#{usuarioWeb}")
	private UsuarioWeb usuarioWeb;

	@ManagedProperty("#{fachada}")
	private Fachada fachada;
 
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public FacesUtils getFacesUtils() {
		return facesUtils;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public Bootstrap getBootstrap() {
		return bootstrap;
	}



	@ManagedProperty("#{bootstrap}")
	private Bootstrap bootstrap;

	@PostConstruct
	public void prepareBootstrap () 
	{
		if (fachada.listaAllUsuarios().size() == 0)
		{
			bootstrap.setup();
		}else{
			//inicia o banco de dados padrao
			TenantRoutingDataSource.setDatabase(Constantes.DATABASE_MATRIZ);
		}
	}

	public String logar ()
	{
		Usuario usuario = null;
		senhaPadrao = this.senha.equals(Util.setMD5Password(SENHA_PADRAO));
		boolean usuarioAutenticado = authenticationService.login(login , senha);
		
		if (!usuarioAutenticado)
		{
			adicionarMensagem(ErroMessage.ERROR_CADASTRO_USUARIO_SENHA_INVALIDA);

			return null;
		}

		if (senhaPadrao)
		{
			setLoginAtual(login);
			setSenhaAtual(SENHA_PADRAO);
			setState(ESTADO_PRIMEIRO_ACESSO);
			
			return null;
		}

		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext)
		{
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication)
			{
				usuario = (Usuario) authentication.getPrincipal();
		 
				usuarioWeb.loga(usuario);
				
				 
					return EMPRESA;
				 
			}
		}
		
		

		return EMPRESA;
	}

	public String logout ()
	{
		authenticationService.logout();
		setState(ESTADO_LOGIN);
		return LOGIN;
	}

	public void alterarCredenciais () 
	{
		Usuario usuario = fachada.logar(loginAtual ,	Util.setMD5Password(senhaAtual));
		if (usuario != null)
		{
			boolean senhaInvalida = !confirmacaoDeSenha.equals(novaSenha);
			if (senhaInvalida)
			{
				adicionarMensagem(ErroMessage.ERROR_CADASTRO_USUARIO_SENHA_CONFIRMACAO_NAO_CONFERE);
				return;
			}

			if (novaSenha.equalsIgnoreCase(SENHA_PADRAO))
			{
				facesUtils.adicionaMensagemDeErro("");
				return;
			}

			if (!novoLogin.isEmpty()&& !usuario.getNome().equals(novoLogin))
			{
				Usuario verificaLogin = fachada.buscarPorLogin(novoLogin);
				
				if (verificaLogin != null)
				{
				//	adicionarMensagem(ErroMessage.ERROR_CADASTRO_USUARIO_LOGIN_JA_UTILIZADO);
				//	return;
				} else
				{
					usuario.setUsername(novoLogin);
				}
			}
			usuario.setPassword(novaSenha);
			try{
			usuario.setEmpresa(null);	
			usuario.setListaEmpresas(fachada.listagemEmpresasPorUsuario(usuario));
			fachada.atualizarUsuarioDireto(usuario);
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO,Classes.USUARIO);
			logout();
			}catch(Exception e){
				adicionarMensagem(ErroMessage.ERROR_CADASTRO_ATUALIZAR, Classes.USUARIO);
			}
			
		} else
		{
			adicionarMensagem(ErroMessage.ERROR_CADASTRO_USUARIO_NAO_ENCONTRADO);
			
		}
	}

	public boolean isPrimeiroAcesso ()
	{
		return ESTADO_PRIMEIRO_ACESSO.equals(state);
	}

	public boolean isAcessoNormal ()
	{
		return ESTADO_LOGIN.equals(state);
	}

	public void setAuthenticationService (
			AuthenticationService authenticationService )
	{
		this.authenticationService = authenticationService;
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

	public String getLogin ()
	{
		return login;
	}

	public void setLogin ( String login )
	{
		this.login = login;
	}

	public String getSenha ()
	{
		return senha;
	}

	public void setSenha ( String senha )
	{
		this.senha = Util.setMD5Password(senha);
	}

	public void setUsuarioWeb ( UsuarioWeb usuarioWeb )
	{
		this.usuarioWeb = usuarioWeb;
	}

	public String getLoginAtual ()
	{
		return loginAtual;
	}

	public void setLoginAtual ( String loginAtual )
	{
		this.loginAtual = loginAtual;
	}

	public String getSenhaAtual ()
	{
		return senhaAtual;
	}

	public void setSenhaAtual ( String senhaAtual )
	{
		this.senhaAtual = senhaAtual;
	}

	public String getNovoLogin ()
	{
		return novoLogin;
	}

	public void setNovoLogin ( String novoLogin )
	{
		this.novoLogin = novoLogin;
	}

	public String getNovaSenha ()
	{
		return novaSenha;
	}

	public void setNovaSenha ( String novaSenha )
	{
		this.novaSenha = novaSenha;
	}

	public String getConfirmacaoDeSenha ()
	{
		return confirmacaoDeSenha;
	}

	public void setConfirmacaoDeSenha ( String confirmacaoDeSenha )
	{
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	public boolean isSenhaPadrao ()
	{
		return senhaPadrao;
	}

	public void setSenhaPadrao ( boolean senhaPadrao )
	{
		this.senhaPadrao = senhaPadrao;
	}

	

	public void setBootstrap ( Bootstrap bootstrap )
	{
		this.bootstrap = bootstrap;
	}
	
	public List<Empresa> getListagemEmpresasPorUsuario(){
		TenantRoutingDataSource.setDatabase(Constantes.DATABASE_MATRIZ);
		List<UsuarioEmpresa> lista = getFachada().listagemEmpresasPorUsuario(usuarioLogado());
		
		List<Empresa> retorno = new ArrayList<Empresa>();
		if(Util.isListNaoNulaNaoVazia(lista)){
			for(UsuarioEmpresa us : lista){
				//if(us.getEmpresaSelecionada().getId().equals(Constantes.DATABASE_MATRIZ)){
				//	retorno.add(us.getEmpresaSelecionada()!=null?us.getEmpresaSelecionada():getFachada().buscarEmpresa(us.getEmpresa()));	
				//}
				retorno.add(us.getEmpresaSelecionada());
			}
		}
		
		return retorno;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	public String utilizarEmpresaSelecionada(){
		usuarioLogado().setEmpresaSelecionada(getEmpresa());	 
		usuarioWeb.loga(usuarioLogado());	
		UsuarioUtil.logar(usuarioLogado(), getFachada());
		 /**
		  * Tentativa de fazer funciona pelo banco. Mas houve muitas consultas
		  * deixado aqui ainda para caso mas na frente haja problemas com novas conexões
		  * */
		/*ControleAcessoLogin controleAcessoLogin = getFachada().buscarControleAcessoLogin(usuarioLogado().getId());		
		 if(controleAcessoLogin!=null){
			 controleAcessoLogin.setIdEmpresa(getEmpresa().getId());
			getFachada().atualizarControleAcessoLogin(controleAcessoLogin);
		 }else{
			ControleAcessoLogin controleAcessoLoginNew = new ControleAcessoLogin();
			controleAcessoLoginNew.setIdEmpresa(getEmpresa().getId());
			controleAcessoLoginNew.setIdUsuario(usuarioLogado().getId());
			getFachada().salvarControleAcessoLogin(controleAcessoLoginNew);		 
			 
		 }*/
		String retorno ="";
		TenantRoutingDataSource.setDatabase(getEmpresa().getDatabase());
		if(getEmpresa().getDatabase().equals(Constantes.DATABASE_MATRIZ) ){
			retorno= INDEX;
		} 
		
		return retorno;
		
	}
	public static String sairSistema(){
		SecurityContextHolder.getContext().setAuthentication(null);
		
		return LOGIN;
	}
	
	public static String trocarEmpresa(){
		
		return EMPRESA;
	}
}
