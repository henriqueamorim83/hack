package br.com.hntecnologia.negocio.usuario;

import java.io.InputStream;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

 

@Entity
@Table(name="tb_arquivo")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "ativo", column = @Column(name = "ativo")),
	@AttributeOverride(name = "versao", column = @Column(name = "versao")),
	@AttributeOverride(name = "dataInclusao", column = @Column(name = "dt_inclusao")),
	@AttributeOverride(name = "dataAlteracao", column = @Column(name = "dt_alteracao")),
	@AttributeOverride(name = "dataExclusao", column = @Column(name = "dt_exclusao"))})
public class Arquivo extends PojoAudit {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7795584063577535748L;

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Lob()
	private byte [] arquivo;

	@javax.persistence.Transient
	private InputStream inputStream;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte [] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte [] arquivo) {
		this.arquivo = arquivo;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	

}
