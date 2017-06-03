package br.com.hntecnologia.infra.registroAtividades;

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

import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.usuario.PojoAudit;
import br.com.hntecnologia.negocio.usuario.Usuario;

@Entity
@Table(name = "tb_erro_sistema")

@AttributeOverrides({ 
		@AttributeOverride(name = "id", column = @Column(name = "id") ),
		@AttributeOverride(name = "ativo", column = @Column(name = "ativo") ),
		@AttributeOverride(name = "versao", column = @Column(name = "versao") ),
		@AttributeOverride(name = "dataCadastro", column = @Column(name = "data_cadastro") ),
		@AttributeOverride(name = "dataAlteracao", column = @Column(name = "data_alteracao") ),
		@AttributeOverride(name = "dataExclusao", column = @Column(name = "data_exclusao") ) })
public class LogErroSistema extends PojoAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4958435084354030170L;



	
	@Column(name = "descricao_erro",length=1000)
	private String descricaoErro;
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;

	@Column(name = "codigo_funcionalidade")
	private int codigoFuncionalidade;

	public LogErroSistema() {

	}

	public LogErroSistema(Integer codigoFuncionalidade, String descricao, Usuario usuario) {
		setCodigoFuncionalidade(codigoFuncionalidade);
		setDescricaoErro(descricao);
		setUsuario(usuario);
		
	}
	
	public String getDescricaoDoLog(){
			String retorno = "codigo : "+getId()+" data : "+Util.converterDateToString(getDataCadastro(), Constantes.FORMATO_DATA)+
					" erro : "+getDescricaoErro();
		
		return retorno;
	}
	
	

	public String getDescricaoErro() {
		return descricaoErro;
	}

	public void setDescricaoErro(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCodigoFuncionalidade() {
		return codigoFuncionalidade;
	}

	public void setCodigoFuncionalidade(int codigoFuncionalidade) {
		this.codigoFuncionalidade = codigoFuncionalidade;
	}

	

}
