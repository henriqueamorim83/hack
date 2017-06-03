package br.com.hntecnologia.negocio.usuario;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.hntecnologia.negocio.empresa.Empresa;

@Entity
@Table(name="tb_usuario_empresa")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "ativo", column = @Column(name = "ativo")),
	@AttributeOverride(name = "versao", column = @Column(name = "versao")),
	@AttributeOverride(name = "dataCadastro", column = @Column(name = "data_cadastro")),
	@AttributeOverride(name = "dataAlteracao", column = @Column(name = "data_alteracao")),	
	@AttributeOverride(name = "dataExclusao", column = @Column(name = "data_exclusao"))})
public class UsuarioEmpresa extends PojoAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8812587865999497462L;
	
	@ManyToOne
	@JoinColumn(name="fk_id_usuario")
	private Usuario usuario;
	 
	@ManyToOne
	@JoinColumn(name="fk_id_empresa_selecionada")
	private Empresa empresaSelecionada;
	
	
	public UsuarioEmpresa(){}
	
	public UsuarioEmpresa(Long id, Long versao, Usuario usuario, Long empresa,String razaoSocial){
		
		setId(id);
		setVersao(versao);
		setUsuario(usuario);
		Empresa emp = new Empresa();
		emp.setId(empresa);
		emp.setNome(razaoSocial);
		
		 
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	 

	 

	
	

}
