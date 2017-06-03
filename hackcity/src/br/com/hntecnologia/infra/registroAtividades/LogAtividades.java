package br.com.hntecnologia.infra.registroAtividades;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.hntecnologia.negocio.usuario.PojoAudit;
import br.com.hntecnologia.negocio.usuario.Usuario;

@Entity
@Table(name="tb_log_atividades")

@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "ativo", column = @Column(name = "ativo")),
	@AttributeOverride(name = "versao", column = @Column(name = "versao")),
	@AttributeOverride(name = "dataCadastro", column = @Column(name = "data_cadastro")),
	@AttributeOverride(name = "dataAlteracao", column = @Column(name = "data_alteracao")),
	@AttributeOverride(name = "dataExclusao", column = @Column(name = "data_exclusao"))})
public class LogAtividades extends PojoAudit {
			
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8591616072691571039L;
	

	
	@Column(name="descricao_atividade",length=1000)
	private String descricaoAcao;
	@ManyToOne
	@JoinColumn(name="fk_id_usuario")
	private Usuario usuario;
	@Column(name="codigo_funcionalidade")
	private int codigoFuncionalidade;
	
	public LogAtividades() {
		super();
	}
	public LogAtividades(String descricao, Usuario usuario, Integer codigoFuncionalidade ) {
		setDescricaoAcao(descricao);
		setUsuario(usuario);
		setCodigoFuncionalidade(codigoFuncionalidade);
	}
		

	public String getDescricaoAcao() {
		return descricaoAcao;
	}

	public void setDescricaoAcao(String descricaoAcao) {
		this.descricaoAcao = descricaoAcao;
	}	

	public int getCodigoFuncionalidade() {
		return codigoFuncionalidade;
	}

	public void setCodigoFuncionalidade(int codigoFuncionalidade) {
		this.codigoFuncionalidade = codigoFuncionalidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
}

