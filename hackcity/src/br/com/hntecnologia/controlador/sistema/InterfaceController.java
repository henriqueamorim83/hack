package br.com.hntecnologia.controlador.sistema;

import java.io.Serializable;

public interface InterfaceController<T> extends Serializable
{

	public abstract void salvar ( T pojo );

	public abstract void atualizar ( T pojo );

	public abstract void remover ( T pojo );

	public abstract void validarUnicidade ( T pojo );

	public abstract void validarUnicidadeInclusao ( T pojo );

	public abstract void validarUnicidadeAlterar ( T pojo );

	public abstract void validarUnicidadeExclusao ( T pojo );

	public abstract void validarAlteracao ( T pojo );

	public abstract void validarExclusao ( T pojo );

	public abstract void preDependencias ( T pojo );

	public abstract void posDependencias ( T pojo );

	public abstract void preDependenciasExclusao ( T pojo );

	public abstract void posDependenciasExclusao ( T pojo );

}
