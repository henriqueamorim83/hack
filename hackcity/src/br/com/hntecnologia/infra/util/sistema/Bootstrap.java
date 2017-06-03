package br.com.hntecnologia.infra.util.sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hntecnologia.controlador.usuario.ControladorUsuario;
import br.com.hntecnologia.fachada.Fachada;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.empresa.Empresa;
 
import br.com.hntecnologia.negocio.usuario.Perfil;
import br.com.hntecnologia.negocio.usuario.Usuario;
import br.com.hntecnologia.negocio.usuario.UsuarioEmpresa;
import br.com.hntecnologia.persistence.empresa.EmpresaBC;
import br.com.hntecnologia.persistence.sistema.PerfilBC;
import br.com.hntecnologia.persistence.sistema.UsuarioBC;
import br.com.hntecnologia.persistence.sistema.UsuarioEmpresaBC;
import br.com.hntecnologia.view.service.TenantRoutingDataSource;


@Service("bootstrap")
public class Bootstrap
{

	@Autowired
	private ControladorUsuario controladorUsuario;
	
	@Autowired
	private UsuarioBC usuarioBC;
	
	@Autowired
	private UsuarioEmpresaBC usuarioEmpresaBC;

	@Autowired
	private PerfilBC perfilDao;
	
	@Autowired
	private EmpresaBC empresaBC;
	
	public void setup ()
	{

			carregaUsuario();
			 
	}

	
	 

	private void carregaUsuario () 
	{
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa ERP");
		empresa.setCnpj("11.111.111/0001-11");
		empresa.setDataCadastro(new Date());
		empresa.setAtivo(true);
		empresa.setVersao(Long.valueOf(0));
		empresa.setDatabase(Constantes.DATABASE_MATRIZ);
		this.empresaBC.salvar(empresa);
		
		empresa = new Empresa();
		empresa.setNome("Empresa RECIFE");
		empresa.setCnpj("11.111.111/0001-11");
		empresa.setDataCadastro(new Date());
		empresa.setAtivo(true);
		empresa.setVersao(Long.valueOf(0));
		empresa.setDatabase(Constantes.DATABASE_RECIFE);
		this.empresaBC.salvar(empresa);
		
		
		empresa = new Empresa();
		empresa.setNome("Empresa CARUARU");
		empresa.setCnpj("11.111.111/0001-11");
		empresa.setDataCadastro(new Date());
		empresa.setAtivo(true);
		empresa.setVersao(Long.valueOf(0));
		empresa.setDatabase(Constantes.DATABASE_CARUARU);
		this.empresaBC.salvar(empresa);
		
		
		empresa = new Empresa();
		empresa.setNome("Empresa GARANHUNS");
		empresa.setCnpj("11.111.111/0001-11");
		empresa.setDataCadastro(new Date());
		empresa.setAtivo(true);
		empresa.setVersao(Long.valueOf(0));
		empresa.setDatabase(Constantes.DATABASE_GARANHUNS);
		this.empresaBC.salvar(empresa);
		
		 
		
		Perfil user = perfilDao.load("OPERADOR");
		if (user == null)
		{
			LogUtil.logInfo("Criando perfil OPERADOR");
			user = new Perfil();
			user.setName("OPERADOR");			
			perfilDao.save(user);
			LogUtil.logInfo("Perfil OPERADOR criado");
			
			LogUtil.logInfo("Criando perfil CLIENTE");
			user = new Perfil();
			user.setName("CLIENTE");			
			perfilDao.save(user);
			LogUtil.logInfo("Perfil CLIENTE criado");
		}

		Perfil admin = perfilDao.load("ADMINISTRADOR");
		if (admin == null)
		{
			LogUtil.logInfo("Criando perfil ADMINISTRADOR");
			admin = new Perfil();
			admin.setName("ADMINISTRADOR");
			perfilDao.save(admin);
			LogUtil.logInfo("Perfil AMINISTRADOR criado");
		}

		List<Perfil> roles = new ArrayList<Perfil>();
		  admin = perfilDao.load("ADMINISTRADOR");
		roles.add(admin);
 
		Usuario usuario = new Usuario();
		  
		LogUtil.logInfo("Criando usuário ADMIN");
		 
		usuario.setNome("USUÁRIO ADMIN");
		usuario.setUsername("henrique");
		usuario.setPassword("monitor83");
		usuario.setAtivo(true);
		usuario.setVersao(new Long(0));
		usuario.setDataCadastro(new Date());
		usuario.setEnabled(true);
		usuario.setRoles(roles);		
		usuario.setEmpresa(Long.valueOf(1));
		usuario.setEmpresaSelecionada(empresa);
		usuario.setListaEmpresas(new ArrayList<UsuarioEmpresa>());
		try{
		usuarioBC.salvar(usuario);
		 
		 UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
		 usuarioEmpresa.setUsuario(this.usuarioBC.buscar(usuario.getId()));
		 usuarioEmpresa.setEmpresa(Long.valueOf(1));
		 usuarioEmpresa.setEmpresaSelecionada(new Empresa(Long.valueOf(1)));
		 usuarioEmpresa.setAtivo(true);
		 usuarioEmpresa.setVersao(Constantes.VERSAO_ATUAL);
		 usuarioEmpresa.setDataCadastro(new Date());
		 this.usuarioEmpresaBC.salvar(usuarioEmpresa);
		 
		 
		 //usuario.getListaEmpresas().add(usuarioEmpresa);
		 
		 
		  
		LogUtil.logInfo("Usuário ADMIN criado");
		}catch(Exception e ){
			System.out.println(e.getMessage());
		}
	}

}
