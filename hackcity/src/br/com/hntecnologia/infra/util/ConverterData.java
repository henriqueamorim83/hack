package br.com.hntecnologia.infra.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterData {

	public Date conveteData(String Sdata){
	
		Date data = null;
		DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = dtOutput.parse(Sdata);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return data;	
	}
}
