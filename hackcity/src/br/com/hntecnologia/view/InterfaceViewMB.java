package br.com.hntecnologia.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public interface InterfaceViewMB<T> extends Serializable
{

	public void prepararParaAdicionar ();

	public void adiciona ();

	public void limpar ();

	public void prepararAlterar ( T pojo );
	
	public void prepararVisualizar ( T pojo );

	public void remove (T pojo);

	public void alterar ();

	void lista ();

	@PostConstruct
	void init ();

	void voltar ();

}
