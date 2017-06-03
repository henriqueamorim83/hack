package br.com.hntecnologia.infra.util.sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import br.com.hntecnologia.fachada.Fachada;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.negocio.usuario.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class UsuarioUtil {
	
	
	
	public static void main(String[] args) throws IOException {
		 
		Usuario usuario = new Usuario();
		usuario.setId(new Long(55));
		usuario.setEmpresa(new Long(6444));
		String arquivo = "/home/henrique/programa/projeto_java/ripe_cafe/ripe/www/resources/conf/"+Constantes.USUARIO_PROPERTIES;
		 arquivoProperties(usuario,arquivo);
	}
	public static void logar(Usuario usuario,Fachada fachada){
		 arquivoProperties(usuario,fachada.getServletContext().getRealPath("/resources/conf/"+Constantes.USUARIO_PROPERTIES));
	}
	
	public static Long consultarUsuarioEmpresa(Usuario usuario,String arquivo){
		Properties prop = new Properties();		
		FileInputStream file;
		try {
			file = new FileInputStream(arquivo);
			prop.load(file);	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		String resultado=prop.getProperty(usuario.getId().toString());
		 return new Long(resultado);
	}	
	 
	 public static void arquivoProperties(Usuario usuario , String arquivo) {
		 Properties prop = new Properties();		 
		 boolean existe=true;
		 FileOutputStream fos=null;
			try{
				FileInputStream file = new FileInputStream(arquivo);
				 prop.load(file);	 
				 
				//pesquisa usuario pelo id
				String resultado=prop.getProperty(usuario.getId().toString());
				//se o usuario existir a gente atualizar a empresa que ele conectou
				if(resultado!=null){					
					prop.setProperty(usuario.getId().toString(), usuario.getEmpresa().toString());
					fos = new FileOutputStream(new File(arquivo));
					atualizarUsuarioProperties(prop, fos);
				}else{
					//se não existe vamos cadastrar ele no properties
					existe=false;
				}
	 		}catch(Exception e){
	 			//se não existe vamos cadastrar ele no properties
	 			existe=false;
	 			System.out.println(e.getMessage());
	 			
	 		}
			//se não existe vamos cadastrar ele no properties
				if(!existe){
					//seta o id do usuario para cadastrar e empresa selecionada
					prop.setProperty(usuario.getId().toString(), usuario.getEmpresa().toString());			  
					try {
						fos = new FileOutputStream(new File(arquivo));
						cadastrarUsuarioProperties(prop, fos);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			
		}
	 
	 private static void cadastrarUsuarioProperties(Properties prop, FileOutputStream fos) throws IOException{
			
			try {
				 
				//grava os dados no arquivo
				prop.store(fos, "");
				//fecha o arquivo
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	 }
	 
	 private static void atualizarUsuarioProperties(Properties prop,FileOutputStream fos) throws IOException{
		 
			System.out.println("verdadeiro");
			 
			//grava os dados no arquivo
			prop.store(fos, "");
			//fecha o arquivo
			fos.close();
	 }
	
}

