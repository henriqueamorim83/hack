package br.com.hntecnologia.negocio.empresa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.hntecnologia.negocio.usuario.Pojo;

@Entity

@Table(name="tb_empresa")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "ativo", column = @Column(name = "ativo")),
	@AttributeOverride(name = "versao", column = @Column(name = "versao")),
	@AttributeOverride(name = "dataCadastro", column = @Column(name = "data_cadastro")),
	@AttributeOverride(name = "dataAlteracao", column = @Column(name = "data_alteracao")),	
	@AttributeOverride(name = "dataExclusao", column = @Column(name = "data_exclusao"))})
public class Empresa extends Pojo {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183424851709531702L;

	
	private String cnpj;
	
	private String nome;
	
	private String database;
	
	public Empresa(){
		
	}
	

	public Empresa(Long id){
		setId(id);
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
