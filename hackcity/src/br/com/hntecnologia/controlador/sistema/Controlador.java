package br.com.hntecnologia.controlador.sistema;

import java.util.Date;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.hntecnologia.controlador.empresa.ControladorEmpresa;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.registroAtividades.LogAtividades;
import br.com.hntecnologia.infra.registroAtividades.LogErroSistema;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.Pojo;
import br.com.hntecnologia.negocio.usuario.PojoAudit;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.persistence.empresa.EmpresaBC;
import br.com.hntecnologia.persistence.sistema.ControleAcessoLoginBC;
import br.com.hntecnologia.persistence.sistema.UsuarioBC;
import br.com.hntecnologia.persistence.sistema.log.LogBC;
import br.com.hntecnologia.view.controleAcesso.UsuarioWeb;

@Controller
public class Controlador implements InterfaceController<Pojo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6953024999911861536L;

	 
	
	@Autowired
	private LogBC logBC;
	 
	@Autowired
	private ControleAcessoLoginBC controleAcessoLoginBC;
	
	@Autowired
	private UsuarioBC usuarioBC;

	private LogAtividades logAtividades;

	private LogErroSistema logErroSistema;
 
	 

	public void adicionarInformacoes(PojoAudit pojo) {
		 
		pojo.setAtivo(true);
		pojo.setVersao(Constantes.VERSAO_ATUAL);
		pojo.setDataCadastro(new Date());
		pojo.setUsuarioCadastro(getUsuario().getId());
		pojo.setEmpresa( getUsuario().getEmpresaSelecionada().getId());
	}

	public void atualizarInformacoes(PojoAudit pojo) {
		 
		pojo.setDataAlteracao(new Date());
		if(pojo.getVersao()!=null){
			pojo.setVersao(pojo.getVersao() + 1);
		}else{
			pojo.setVersao(Constantes.VERSAO_ATUAL);
		}
		
		
		pojo.setUsuarioAtualizacao( (getUsuario().getId()));
		pojo.setEmpresa( getUsuario().getEmpresaSelecionada().getId());
		pojo.setAtivo(true);

	}

	public void adicionarInformacoesExclusao(PojoAudit pojo) {
		 
		pojo.setDataExclusao(new Date());
		pojo.setVersao(pojo.getVersao() + 1);
		pojo.setAtivo(false);
		pojo.setEmpresa( getUsuario().getEmpresaSelecionada().getId());
		pojo.setUsuarioExclusao( getUsuario().getId());

	}

	
	
	
	@Override
	public void validarUnicidade(Pojo pojo) {

	}

	@Override
	public void validarUnicidadeInclusao(Pojo pojo) {

	}

	@Override
	public void validarUnicidadeAlterar(Pojo pojo) {

	}

	@Override
	public void validarUnicidadeExclusao(Pojo pojo) {

	}

	@Override
	public void validarAlteracao(Pojo pojo) {

	}

	@Override
	public void validarExclusao(Pojo pojo) {

	}

	@Override
	public void preDependencias(Pojo pojo) {

	}

	@Override
	public void posDependencias(Pojo pojo) {

	}

	@Override
	public void preDependenciasExclusao(Pojo pojo) {

	}

	@Override
	public void posDependenciasExclusao(Pojo pojo) {

	}

	public LogBC getLogBC() {
		return logBC;
	}

	public void setLogBC(LogBC logBC) {
		this.logBC = logBC;
	}

	public LogAtividades getLogAtividades() {
		return logAtividades;
	}

	public void setLogAtividades(LogAtividades logAtividades) {
		this.logAtividades = logAtividades;
	}

	public LogErroSistema getLogErroSistema() {
		return logErroSistema;
	}

	public void setLogErroSistema(LogErroSistema logErroSistema) {
		this.logErroSistema = logErroSistema;
	}

	public void informarAtividades( Integer funcionalidade, String descricao) {
		setLogAtividades(new LogAtividades( descricao,getUsuario(),funcionalidade));
		//adicionarInformacoes(getLogAtividades());
		getLogBC().salvarLogAtividade(getLogAtividades());
		
	}

	public LogErroSistema informarLogErros( Integer funcionalidade, String descricao, ErroMessage erroMessage,String classe) {
	
		String retorno = "";
		if(descricao!=null){
			String[] log = new String[2];
			log[0]=classe;
			log[1]= descricao;
			retorno =InformarMensagem.getInstancia().Mensagem(erroMessage,log);
		}else{
			retorno=InformarMensagem.getInstancia().Mensagem(erroMessage,classe);
		}
		setLogErroSistema(new LogErroSistema(funcionalidade, retorno, getUsuario()));
		//adicionarInformacoes(getLogErroSistema());
		  getLogBC().salvarLogErro(getLogErroSistema());
		return getLogErroSistema();		
		
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
				usuario = ((Usuario) authentication.getPrincipal());
				 return usuario;
			}
		}		 
		
		return null;
	}
	 

 





	@Override
	public void salvar(Pojo pojo) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void atualizar(Pojo pojo) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void remover(Pojo pojo) {
	 
		
	}

	
}
