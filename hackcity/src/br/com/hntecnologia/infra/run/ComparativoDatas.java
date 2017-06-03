package br.com.hntecnologia.infra.run;

import java.util.Calendar;
import java.util.Date;

import net.sourceforge.barbecue.Main;

public class ComparativoDatas {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		if(new Date().getTime()==calendar.getTime().getTime()){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		System.out.println(calendar.get(Calendar.DATE));
	}

}
