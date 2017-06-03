package br.com.hntecnologia.controlador.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import br.com.hntecnologia.controlador.sistema.Controlador;
import br.com.hntecnologia.controlador.sistema.InterfaceControlador;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.ControleAcessoLogin;
import br.com.hntecnologia.negocio.usuario.Pojo;
import br.com.hntecnologia.negocio.usuario.PojoAudit;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;
import br.com.hntecnologia.persistence.empresa.EmpresaBC;
import br.com.hntecnologia.persistence.sistema.ControleAcessoLoginBC;
import br.com.hntecnologia.persistence.sistema.UsuarioBC;
import br.com.hntecnologia.persistence.sistema.UsuarioEmpresaBC;
 

@Controller
public class ControladorUsuario extends Controlador implements InterfaceControlador<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385143047254160772L;
	@Autowired
	private UsuarioBC usuarioBC;
	
	@Autowired
	private UsuarioEmpresaBC usuarioEmpresaBC;
	
	@Autowired
	private ControleAcessoLoginBC controleAcessoLoginBC;
	
	
	
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method salvar usuario
	 * @company www.hntecnologia.com.br
	 *
	 */
	@Override
	public void salvar(Usuario pojo) {
		adicionarInformacoes(pojo);
		this.usuarioBC.salvar(pojo);
		posDependencias(pojo);		 
		informarAtividades(Constantes.INSERIR,
				InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_ADICIONADO_COM_SUCESSO, Classes.USUARIO));

	}
 
	public void adicionarInformacoes(Pojo pojo) {
		pojo.setAtivo(true);
		pojo.setVersao(Constantes.VERSAO_ATUAL);
		pojo.setDataCadastro(Constantes.DATA_ATUAL);
		
	}
	
	public void atualizarInformacoes(Pojo pojo){
		pojo.setAtivo(true);
		pojo.setVersao(pojo.getVersao()+1);
		pojo.setDataAlteracao(Constantes.DATA_ATUAL);
	}
	 
	public void adicionarInformacoesExclusao(Pojo  pojo) {
		pojo.setAtivo(false);
		pojo.setVersao(pojo.getVersao()+1);
		pojo.setDataExclusao(Constantes.DATA_ATUAL);
	}
	
	public void replicarEmpresas(Usuario pojo){
		 
		List<UsuarioEmpresa> listaExclusao = listagemEmpresasPorUsuario(pojo);
		for(UsuarioEmpresa us : listaExclusao){
			adicionarInformacoesExclusao(us);
			this.usuarioEmpresaBC.remover(us);
		}
			
			for(UsuarioEmpresa u : pojo.getListaEmpresas()){
				u.setUsuario(pojo);
				if(u.getId()==null){
					
					adicionarInformacoes(u);
					this.usuarioEmpresaBC.salvar(u);						
				}else{
					atualizarInformacoes(u);
					this.usuarioEmpresaBC.atualizar(u);
				 
			} 
		}
		
		
		 
			 
				
	}
		
	
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @ @method atualizar usuario
	 * @company www.hntecnologia.com.br
	 *
	 */
	@Override
	public void atualizar(Usuario pojo) {
		 
		atualizarInformacoes(pojo);		 
		this.usuarioBC.atualizar(pojo);
		posDependencias(pojo);
 
		informarAtividades(Constantes.ATUALIZAR,
				InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO, Classes.USUARIO));
	}
	
	public void atualizarDireto(Usuario pojo) {
		 
		 	 
		this.usuarioBC.atualizar(pojo);
		posDependencias(pojo);
 
		}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method remover usuario
	 * @company www.hntecnologia.com.br
	 *
	 */
	@Override
	public void remover(Usuario pojo) {
		adicionarInformacoesExclusao(pojo);
		this.usuarioBC.remover(pojo);
		posDependenciasExclusao(pojo);
		 
		informarAtividades(Constantes.REMOVER,
				InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_REMOVIDO_COM_SUCESSO, Classes.USUARIO));
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuario @
	 */
	@Override
	public Usuario buscarId(Long codigo) {
		Usuario usuario = this.usuarioBC.buscar(codigo);
		 
		usuario.setListaEmpresas(this.usuarioEmpresaBC.listagemEmpresasPorUsuario(usuario));
		return usuario;
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method atualizar usuario
	 * @company www.hntecnologia.com.br
	 * @return Lista de usuários @
	 */
	@Override
	public List<Usuario> listaAll() {

		return this.usuarioBC.listAll();
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method contagem usuarios
	 * @company www.hntecnologia.com.br
	 * @return
	 */
	@Override
	public Integer countAll(Usuario pojo) {
		 
		return this.usuarioBC.countAll(pojo);
	}

	 
	public void posDependenciasExclusao(Usuario pojo) {
		List<UsuarioEmpresa> listaExclusao = listagemEmpresasPorUsuario(pojo);
		if(Util.isListNaoNulaNaoVazia(listaExclusao)){
			 
			for(UsuarioEmpresa us : listaExclusao){
				adicionarInformacoesExclusao(us);
				this.usuarioEmpresaBC.remover(us);
			}
			listaExclusao = null;
		}
		 replicarEmpresas(pojo);
	}
	 
	public void posDependencias(Usuario pojo) {
			 //verificar, isso não vai ser mas usado
		 replicarEmpresas(pojo);
	}
	
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method consultar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuarios @
	 */
	@Override
	public List<Usuario> consultarEntidade(Usuario pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		 
		return this.usuarioBC.consultarEntidade(pojo, first, pageSize, sortField, sortOrder, filters);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method login usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuarios @
	 */
	public Usuario logar(String login, String senha) {
		return this.usuarioBC.logar(login, senha);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuario @
	 */

	public Usuario buscarPorLogin(String login) {

		return this.usuarioBC.buscarPorLogin(login);
	}
	
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method listagem empresa
	 * @company www.hntecnologia.com.br
	 * @return empresa @
	 */
	public List<UsuarioEmpresa> listagemEmpresasPorUsuario(Usuario usuario){
		 
		return this.usuarioEmpresaBC.listagemEmpresasPorUsuario(usuario);
	}
	
	public UsuarioEmpresa buscarUsuarioEmpresa (Long id){
		return this.usuarioEmpresaBC.buscar(id);
	}
	
	
	public ControleAcessoLogin buscarControleAcessoLogin(Long idUsuario){
		return this.controleAcessoLoginBC.buscar(idUsuario);
	}
	
	public void atualizarControleAcessoLogin(ControleAcessoLogin controleAcessoLogin){
		this.controleAcessoLoginBC.update(controleAcessoLogin);
	}
	
	public void salvarControleAcessoLogin(ControleAcessoLogin controleAcessoLogin){
		this.controleAcessoLoginBC.save(controleAcessoLogin);
	}
}
