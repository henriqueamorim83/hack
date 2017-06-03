package br.com.hntecnologia.infra.run;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.apache.commons.beanutils.converters.CharacterArrayConverter;

import com.mchange.v1.lang.ClassUtils;

import br.com.hntecnologia.infra.util.constantes.Classes;





public class Run_senha{
	
	public static void main(String[] args) {  
      
		
		//System.out.println(cript("1"));
		//System.out.println(decripto(cript("1")));
		//System.out.println(Classes.GRUPO_FISCAL);
	}
	
	public  static String cript(String texto){
		char[] array = texto.toCharArray();
		for(int i=0;i<texto.length();i++){
			 array[i]=(char) (texto.charAt(i)+75);			
		}
		return new String(array);
	}
	public  static String decripto(String texto){
		char[] array = texto.toCharArray();
		for(int i=0;i<texto.length();i++){
			 array[i]=(char) (texto.charAt(i)-75);			
		}
		return new String(array);
		
	}
	
}
