package br.com.hntecnologia.view.service;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import br.com.hntecnologia.infra.util.constantes.Constantes;

public class TenantRoutingDataSource extends AbstractRoutingDataSource{

	public static String database = Constantes.DATABASE_MATRIZ;
	 
	@Override
	protected Object determineCurrentLookupKey() {
		
		/*
		 * here goes the logic for changing db... 
		 * 
		 * you cann get the logged user, read a file, etc.
		 * 
		 * I'll use a static string... :P
		 */
		 
		return getDatabase();
	}
	public static String getDatabase() {
		return database;
	}
	public static void setDatabase(String database) {
		TenantRoutingDataSource.database = database;
	}
	
	
}
