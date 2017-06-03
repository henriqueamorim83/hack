package br.com.hntecnologia.view.controleAcesso;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.hntecnologia.negocio.usuario.Usuario;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class UsuarioWeb implements Serializable
{

	private Usuario usuario;

	private String perfil;

	public void loga ( Usuario usuario )
	{
		this.usuario = usuario;
		this.perfil = usuario.getRoles().get(0).getName();
	}

	public boolean isUsuarioLimitado ()
	{
		return this.perfil.equalsIgnoreCase("USUARIO");
	}

	public boolean isUsuarioAdmin ()
	{
		return this.perfil.equalsIgnoreCase("ADMINISTRADOR");
	}

	public Usuario getUsuario ()
	{
		return usuario;
	}

	public String getPerfil ()
	{
		return perfil;
	}
	public boolean isPermissoes(){
		return true;
	}

}
