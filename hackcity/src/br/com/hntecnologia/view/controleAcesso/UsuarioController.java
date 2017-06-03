package br.com.hntecnologia.view.controleAcesso;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.hntecnologia.negocio.usuario.Usuario;

public class UsuarioController implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079826201524425291L;

	private Usuario usuario;

	public UsuarioController()
	{
		usuario = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext)
		{
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication)
			{
				System.out.println();
				usuario.setUsername(((User) authentication.getPrincipal())
						.getUsername());
			}
		}

	}

	public Usuario getUsuario ()
	{
		return usuario;
	}

	public void setUsuario ( Usuario usuario )
	{
		this.usuario = usuario;
	}

}