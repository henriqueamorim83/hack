package br.com.hntecnologia.view.empresa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.map.HashedMap;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
import br.com.hntecnologia.view.EntidadeViewMB;
import br.com.hntecnologia.view.InterfaceViewMB;

@ManagedBean
@ViewScoped
public class EmpresaMB extends EntidadeViewMB<Empresa> implements InterfaceViewMB<Empresa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5360276172209072738L;

	private Empresa empresa = new Empresa();

	 
	private Boolean empresaEnderecoEdicao, empresaEnderecoLista, empresaPessoaEdicao, empresaPessoaLista;

	private Boolean empresaTelefoneEdicao;

	private Boolean empresaTelefoneLista;

	public void prepararParaAdicionar() {
		limpar();
		getFacesUtils().cleanSubmittedValues(getForm()); // limpa arvore
		setState(ESTADO_DE_NOVO);

	}

	@Override
	public void adiciona() {

		try {
			getFachada().salvarEmpresa(getEmpresa());
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ADICIONADO_COM_SUCESSO, Classes.EMPRESA);
			limpar();
			lista();
		} catch (Exception e) {

			adicionarMensagem(getFachada().logAtividadesErro(Constantes.INSERIR, e.getMessage(),
					ErroMessage.ERROR_CADASTRO_INSERIR, Classes.EMPRESA).getDescricaoDoLog());
		}

	}

	@Override
	public void limpar() {
		setEmpresa(new Empresa());
	 

		setEmpresaEnderecoEdicao(false);
		setEmpresaEnderecoLista(true);
		setEmpresaTelefoneEdicao(false);
		setEmpresaTelefoneLista(true);

		getFacesUtils().cleanSubmittedValues(getForm()); // limpa arvore
	}

	@Override
	public void prepararAlterar(Empresa bean) {
		limpar();
		setEmpresa(getFachada().buscarEmpresa(bean.getId()));
		getFacesUtils().cleanSubmittedValues(getForm());
		setState(ESTADO_DE_EDICAO);

	}

	@Override
	public void prepararVisualizar(Empresa bean) {
		limpar();
		setEmpresa(getFachada().buscarEmpresa(bean.getId()));
		getFacesUtils().cleanSubmittedValues(getForm());
		setState(ESTADO_DE_VISUALIZAR);
	}

	@Override
	public void remove(Empresa pojo) {
		try {
			getFachada().removerEmpresa(getFachada().buscarEmpresa(pojo.getId().longValue()));
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_REMOVIDO_COM_SUCESSO, Classes.EMPRESA);
			lista();
		} catch (Exception e) {

			adicionarMensagem(getFachada().logAtividadesErro(Constantes.INSERIR, e.getMessage(),
					ErroMessage.ERROR_CADASTRO_REMOVER, Classes.EMPRESA).getDescricaoDoLog());
		}
	}

	@Override
	public void alterar() {
		try {
			getFachada().atualizarEmpresa(getEmpresa());
			adicionarMensagem(Mensagem.MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO, Classes.EMPRESA);
			limpar();
			lista();
		} catch (Exception e) {

			adicionarMensagem(getFachada().logAtividadesErro(Constantes.INSERIR, e.getMessage(),
					ErroMessage.ERROR_CADASTRO_ATUALIZAR, Classes.EMPRESA).getDescricaoDoLog());
		}
	}

	@Override
	public void lista() {
		init();
		setState(ESTADO_DE_PESQUISA);

	}

	@PostConstruct
	public void init() {
		try {
			setObjetos(new LazyDataModel<Empresa>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 8152736868979263988L;

				public List<Empresa> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<Empresa> lista = new ArrayList<Empresa>();
				 
					lista = getFachada().consultarEmpresa(getEmpresa(), first, pageSize, sortField, sortOrder, filters);
					getObjetos().setRowCount(getFachada().countAllEmpresa(getEmpresa()));
					getObjetos().setPageSize(getObjetos().getPageSize() * 10);
					limpar();
					return lista;

				}
			});
		} catch (Exception e) {
			adicionarMensagem(getFachada().logAtividadesErro(Constantes.CONSULTAR, e.getMessage(),
					ErroMessage.ERROR_CADASTRO_CONSULTAR, Classes.EMPRESA).getDescricaoDoLog());

		}

	}

	@Override
	public void voltar() {
		lista();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	 

	public Boolean getEmpresaEnderecoEdicao() {
		return empresaEnderecoEdicao;
	}

	public void setEmpresaEnderecoEdicao(Boolean empresaEnderecoEdicao) {
		this.empresaEnderecoEdicao = empresaEnderecoEdicao;
	}

	public Boolean getEmpresaEnderecoLista() {
		return empresaEnderecoLista;
	}

	public void setEmpresaEnderecoLista(Boolean empresaEnderecoLista) {
		this.empresaEnderecoLista = empresaEnderecoLista;
	}

	public Boolean getEmpresaPessoaEdicao() {
		return empresaPessoaEdicao;
	}

	public void setEmpresaPessoaEdicao(Boolean empresaPessoaEdicao) {
		this.empresaPessoaEdicao = empresaPessoaEdicao;
	}

	public Boolean getEmpresaPessoaLista() {
		return empresaPessoaLista;
	}

	public void setEmpresaPessoaLista(Boolean empresaPessoaLista) {
		this.empresaPessoaLista = empresaPessoaLista;
	}

	public void adicionarEmpresaEndereco() {
		setEmpresaEnderecoEdicao(true);
		setEmpresaEnderecoLista(false);
		 
	}

	public void cancelarEmpresaEndereco() {
		setEmpresaEnderecoEdicao(false);
		setEmpresaEnderecoLista(true);
		 
	}
     

	public Boolean getEmpresaTelefoneEdicao() {
		return empresaTelefoneEdicao;
	}

	public void setEmpresaTelefoneEdicao(Boolean empresaTelefoneEdicao) {
		this.empresaTelefoneEdicao = empresaTelefoneEdicao;
	}

	public Boolean getEmpresaTelefoneLista() {
		return empresaTelefoneLista;
	}

	public void setEmpresaTelefoneLista(Boolean empresaTelefoneLista) {
		this.empresaTelefoneLista = empresaTelefoneLista;
	}

	 
	public String tipoRegime(Integer tipo){
		switch (tipo) {
			case Constantes.EMPRESA_REGIME_SIMPLES_NACIONAL:
				return "Simples Nacional";
			case Constantes.EMPRESA_REGIME_LUCRO_PRESUMIDO:
				return "Lucro Presumido";
			case Constantes.EMPRESA_REGIME_LUCRO_REAL:	
				return "Lucro Real";
		}
		return "";
	}

	public String tipoTelefone(Integer tipo){
		switch (tipo) {
		case Constantes.EMPRESA_TELEFONE_CELULAR:
			return "Celular";
			
		case Constantes.EMPRESA_TELEFONE_COMERCIAL:
					
			return "Comercial";
		case Constantes.EMPRESA_TELEFONE_RESIDENCIAL:
			
			return "Residêncial";
		case Constantes.EMPRESA_TELEFONE_OUTRO:
			
			return "Outro";

		}
		return "";
	}
}
