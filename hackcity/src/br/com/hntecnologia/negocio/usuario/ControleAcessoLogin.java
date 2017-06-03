package br.com.hntecnologia.negocio.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="tb_controle_acesso_login")
public class ControleAcessoLogin implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5474434146590966483L;
	@Id
	@Column(name="id_usuario")
	private Long idUsuario;
	@Column(name="id_empresa")
	private  Long idEmpresa;
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	
}
