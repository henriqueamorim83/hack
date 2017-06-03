package br.com.hntecnologia.negocio.usuario;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
 



@Entity
@NamedQueries({ @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username=:username and u.enabled=true") })
@Table(name="tb_usuario")

@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "ativo", column = @Column(name = "ativo")),
	@AttributeOverride(name = "versao", column = @Column(name = "versao")),
	@AttributeOverride(name = "dataCadastro", column = @Column(name = "data_cadastro")),
	@AttributeOverride(name = "dataAlteracao", column = @Column(name = "data_alteracao")),	
	@AttributeOverride(name = "dataExclusao", column = @Column(name = "data_exclusao"))})

public class Usuario extends PojoAudit   implements Serializable,  UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149160207029554817L;



	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, name = "senha")
	private String password;
	
	@Column(name="nome")
	private String nome;
	
	 
	@Lob()
	@Column(name = "foto_imagem")
	private byte[] imagem;
	
	
	
	 
	@Transient
	private
	List<UsuarioEmpresa> listaEmpresas;
	
	@Transient
	private Empresa empresaSelecionada;
	
	
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	

	public boolean isAdministrador(){
		if(this.getId()==1){
			return true;
		}else if(getRoles().get(0).getName().equalsIgnoreCase(Constantes.USUARIO_PERFIL_ADMINISTRADOR)){
			return true;
		}
		return false;
	}
	

	public boolean isOperador(){
		if( Util.isListNaoNulaNaoVazia(getRoles()) && getRoles().get(0).getName().equalsIgnoreCase(Constantes.USUARIO_PERFIL_OPERADOR)){
			return true;
		}
		return false;
	}
	
	public boolean isCliente(){
		if(Util.isListNaoNulaNaoVazia(getRoles()) && getRoles().get(0).getName().equalsIgnoreCase(Constantes.USUARIO_PERFIL_CLIENTE)){
			return true;
		}
		return false;
	}
	
	public Usuario() {
		super();
		// 
	}
	public Usuario(String nome){
		setNome(nome);
	}

	public Usuario(Long id, String username, String password, boolean enabled,
			boolean mainUser, String nome, List<Perfil> roles) {
		super();
		setId(id);
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.mainUser = mainUser;
		this.nome = nome;
		this.roles = roles;
	}

	private boolean enabled;
	
	private boolean mainUser;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Perfil> roles;

	
	public Collection<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();

		for (Perfil role : roles) {
			result.add(new GrantedAuthorityImpl(role.getName()));
		}
		return result;
	}

	
	public Usuario(Long id, String username, String password) {
		super();
		setId(id);
		this.username = username;
		this.password = password;
	}


	
	public String getPassword() {
		return password;
	}

	
	public String getUsername() {
		return username;
	}

	@Transient
	
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
	public boolean isEnabled() {
		return enabled;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = Util.setMD5Password(password);
	}

	public List<Perfil> getRoles() {
		return roles;
	}

	public void setRoles(List<Perfil> roles) {
		this.roles = roles;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isMainUser() {
		return mainUser;
	}

	public void setMainUser(boolean mainUser) {
		this.mainUser = mainUser;
	}

	
	  
	



	 
	public List<UsuarioEmpresa> getListaEmpresas() {
		if(!Util.isListNaoNulaNaoVazia(listaEmpresas)){
			this.listaEmpresas = new ArrayList<UsuarioEmpresa>();
		}
		return listaEmpresas;
	}

	public void setListaEmpresas(List<UsuarioEmpresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	 

 


 
	

}
