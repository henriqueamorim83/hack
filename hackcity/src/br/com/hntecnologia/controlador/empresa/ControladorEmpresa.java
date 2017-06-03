package br.com.hntecnologia.controlador.empresa;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import br.com.hntecnologia.controlador.sistema.Controlador;
import br.com.hntecnologia.controlador.sistema.InterfaceControlador;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
 
import br.com.hntecnologia.negocio.usuario.Pojo;
import br.com.hntecnologia.persistence.empresa.EmpresaBC;

@Controller
public class ControladorEmpresa extends Controlador implements InterfaceControlador<Empresa>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966171672982621582L;

	@Autowired
	private EmpresaBC EmpresaBC;
	 
	 
	
 
	@Override
	public void salvar(Empresa pojo) {
		adicionarInformacoes(pojo);
		preDependencias(pojo);
		this.EmpresaBC.salvar(pojo);
		posDependencias(pojo);
		informarAtividades(Constantes.INSERIR,InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_ADICIONADO_COM_SUCESSO, Classes.EMPRESA ));
	
	}

	@Override
	public void atualizar(Empresa pojo) {
		atualizarInformacoes(pojo);
		preDependencias(pojo);
		this.EmpresaBC.atualizar(pojo);
		posDependencias(pojo);
		informarAtividades(Constantes.ATUALIZAR,
				InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO, Classes.EMPRESA ));
		}

	@Override
	public void remover(Empresa pojo) {
		adicionarInformacoesExclusao(pojo);
		this.EmpresaBC.remover(pojo);
		informarAtividades(Constantes.REMOVER,
				InformarMensagem.getInstancia().Mensagem(Mensagem.MENSAGEM_CADASTRO_REMOVIDO_COM_SUCESSO, Classes.EMPRESA));
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
	
	 
	public void preDependencias(Empresa pojo) {
		 
		
		
	}
	
	public void posDependencias(Empresa pojo) {
		
		
		 
		
	}
	
	@Override
	public Empresa buscarId(Long codigo) {
		Empresa  empresa = this.EmpresaBC.buscar(codigo);
		 
		 
		return empresa;
	}

	@Override
	public List<Empresa> listaAll() {
		
		return this.EmpresaBC.listAll();
	}

	@Override
	public Integer countAll(Empresa pojo) {
		
		return this.EmpresaBC.countAll(pojo);
	}

	@Override
	public List<Empresa> consultarEntidade(Empresa pojo, int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		
		return this.EmpresaBC.consultarEntidade(pojo, first, pageSize, sortField, sortOrder, filters);
	}

}

