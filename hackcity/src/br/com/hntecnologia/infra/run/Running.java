package br.com.hntecnologia.infra.run;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hntecnologia.infra.util.Util;


public class Running
{

	public static void main(String args[]){
	   
	//Util.atualizarBancoRipe();
	Util.atualizarBancoSuprimentos();
		
	}
	

}
