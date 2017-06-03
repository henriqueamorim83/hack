package br.com.hntecnologia.negocio.usuario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.hntecnologia.negocio.empresa.Empresa;

@MappedSuperclass
public class Pojo implements Serializable
{

	private static final long serialVersionUID = 3488387671742814054L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "versao")
	private Long versao;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "data_exclusao")
	private Date dataExclusao;

	  

	public Long getVersao ()
	{
		return versao;
	}

	public void setVersao ( Long versao )
	{
		this.versao = versao;
	}

	public Date getDataCadastro ()
	{
		if(this.dataCadastro==null){
			this.dataCadastro=new Date();
		}
		return dataCadastro;
	}

	public void setDataCadastro ( Date dataCadastro )
	{
		this.dataCadastro = dataCadastro;
	}

	public Date getDataExclusao ()
	{
		return dataExclusao;
	}

	public void setDataExclusao ( Date dataExclusao )
	{
		this.dataExclusao = dataExclusao;
	}



	public Date getDataAlteracao ()
	{
		return dataAlteracao;
	}

	public void setDataAlteracao ( Date dataAlteracao )
	{
		this.dataAlteracao = dataAlteracao;
	}
	public Boolean getAtivo ()
	{
		return ativo;
	}

	public void setAtivo ( Boolean ativo )
	{
		this.ativo = ativo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
