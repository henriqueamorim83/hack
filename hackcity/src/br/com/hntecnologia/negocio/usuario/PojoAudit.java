package br.com.hntecnologia.negocio.usuario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import br.com.hntecnologia.negocio.empresa.Empresa;

@MappedSuperclass
public class PojoAudit extends Pojo {
	
	
	//@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL )
	//@JoinColumn(name="fk_id_usuario_cadastro")
	@Column(name="fk_id_usuario_cadastro")
	private Long usuarioCadastro;

	//@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL )
	//@JoinColumn(name="fk_id_usuario_atualizacao")
	@Column(name="fk_id_usuario_atualizacao")
	private Long usuarioAtualizacao;
	//@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL )
	//@JoinColumn(name="fk_id_usuario_exclusao")
	@Column(name="fk_id_usuario_exclusao")
	private Long usuarioExclusao;
	
//	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL )
	//@JoinColumn(name="fk_id_empresa")
	@Column(name="fk_id_empresa")
	private Long empresa;

	public Long getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Long usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Long getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}

	public void setUsuarioAtualizacao(Long usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}

	public Long getUsuarioExclusao() {
		return usuarioExclusao;
	}

	public void setUsuarioExclusao(Long usuarioExclusao) {
		this.usuarioExclusao = usuarioExclusao;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}

	 
	
	
	 
}
