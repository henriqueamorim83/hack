package br.com.hntecnologia.fachada;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import br.com.hntecnologia.controlador.empresa.ControladorEmpresa;
import br.com.hntecnologia.controlador.sistema.Controlador;
import br.com.hntecnologia.controlador.usuario.ControladorUsuario;
import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.registroAtividades.LogErroSistema;
import br.com.hntecnologia.infra.util.RelatorioUtil.FormatoImpressao;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

 
import net.sf.jasperreports.engine.JasperReport;
 

@Repository("fachada")
@Controller
public class Fachada {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private ControladorUsuario controladorUsuario;
	
	 @Autowired
	 private ControladorEmpresa controladorEmpresa;
	 
	 @Autowired
	 private Controlador controlador;
	 
	
		
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method salvar usuario
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void salvarUsuario(Usuario pojo) {

		this.controladorUsuario.salvar(pojo);

	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method atualizar usuario
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void atualizarUsuario(Usuario pojo) {

		this.controladorUsuario.atualizar(pojo);
	}
	public void atualizarUsuarioDireto(Usuario pojo) {

		this.controladorUsuario.atualizarDireto(pojo);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method remover usuario
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void removerUsuario(Usuario pojo) {

		this.controladorUsuario.remover(pojo);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuario @
	 */

	public Usuario buscarUsuarioId(Long codigo) {

		return this.controladorUsuario.buscarId(codigo);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method atualizar usuario
	 * @company www.hntecnologia.com.br
	 * @return Lista de usuários @
	 */

	public List<Usuario> listaAllUsuarios() {

		return this.controladorUsuario.listaAll();
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method contagem usuarios
	 * @company www.hntecnologia.com.br
	 * @return @
	 */

	public Integer countAllUsuarios(Usuario usuario) {

		return this.controladorUsuario.countAll(usuario);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method consultar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuarios @
	 */

	public List<Usuario> consultarUsuario(Usuario pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		return this.controladorUsuario.consultarEntidade(pojo, first, pageSize, sortField, sortOrder, filters);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method logar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuarios @
	 */

	public Usuario logar(String login, String senha) {
		return this.controladorUsuario.logar(login, senha);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar usuario
	 * @company www.hntecnologia.com.br
	 * @return Usuario @
	 */

	public Usuario buscarPorLogin(String login) {

		return this.controladorUsuario.buscarPorLogin(login);
	}

	
	

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method salvar Empresa
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void salvarEmpresa(Empresa pojo) {

		this.controladorEmpresa.salvar(pojo);

	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method atualizar Empresa
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void atualizarEmpresa(Empresa pojo) {

		this.controladorEmpresa.atualizar(pojo);
	}
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method gravar Erros
	 * @company www.hntecnologia.com.br
	 * @return logErro @
	 */

	public LogErroSistema logAtividadesErro(Integer funcionalidade, String descricao, ErroMessage erroMessage,
			String classe) {
		return this.controlador.informarLogErros(funcionalidade, descricao, erroMessage, classe);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method remover Empresa
	 * @company www.hntecnologia.com.br
	 *
	 */

	public void removerEmpresa(Empresa pojo) {

		this.controladorEmpresa.remover(pojo);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar Empresa
	 * @company www.hntecnologia.com.br
	 * @return Empresa @
	 */

	public Empresa buscarEmpresaId(Long codigo) {

		return this.controladorEmpresa.buscarId(codigo);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method atualizar Empresa
	 * @company www.hntecnologia.com.br
	 * @return Lista de usuários @
	 */

	public List<Empresa> listaAllEmpresas() {

		return this.controladorEmpresa.listaAll();
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method contagem Empresas
	 * @company www.hntecnologia.com.br
	 * @return @
	 */

	public Integer countAllEmpresas(Empresa Empresa) {

		return this.controladorEmpresa.countAll(Empresa);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method consultar Empresa
	 * @company www.hntecnologia.com.br
	 * @return Empresas @
	 */

	public List<Empresa> consultarEmpresa(Empresa pojo, int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		return this.controladorEmpresa.consultarEntidade(pojo, first, pageSize, sortField, sortOrder, filters);
	}

	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method buscar  Empresa 
	 * @company www.hntecnologia.com.br
	 * @return  Empresa 
	 */
	
	public Empresa buscarEmpresa(Long id){
		return this.controladorEmpresa.buscarId(id);
	}
	 /**
		 * @author Henrique Amorim
		 * @param henrique@hntencologia.com.br
		 * @method buscar  UsuarioEmpresa 
		 * @company www.hntecnologia.com.br
		 * @return UsuarioEmpresa
		 */
	 public UsuarioEmpresa buscarUsuarioEmpresa(Long id){
		 return this.controladorUsuario.buscarUsuarioEmpresa(id);
	 }
	
	 /**
		 * @author Henrique Amorim
		 * @param henrique@hntencologia.com.br
		 * @method lista  UsuarioEmpresa 
		 * @company www.hntecnologia.com.br
		 * @return UsuarioEmpresa
		 */
	 
		public List<UsuarioEmpresa> listagemEmpresasPorUsuario(Usuario usuario){
			return this.controladorUsuario.listagemEmpresasPorUsuario(usuario);
		}
		
		/**
		 * @author Henrique Amorim
		 * @param henrique@hntencologia.com.br
		 * @method listar  Empresa 
		 * @company www.hntecnologia.com.br
		 * @return  Empresa 
		 */
		public List<Empresa> listagemEmpresa(){
			return this.controladorEmpresa.listaAll();
		}
		
		
	/**
	 * @author Henrique Amorim
	 * @param henrique@hntencologia.com.br
	 * @method count  Empresa 
	 * @company www.hntecnologia.com.br
	 * @return  Empresa 
	 */
	
	public Integer countAllEmpresa(Empresa pojo){
		return this.controladorEmpresa.countAll(pojo);
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	 
}	
