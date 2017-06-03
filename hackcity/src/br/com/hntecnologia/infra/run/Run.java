package br.com.hntecnologia.infra.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.formula.functions.T;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;
 

import com.ibm.icu.text.SimpleDateFormat;

import br.com.hntecnologia.infra.enumeration.ErroMessage;
import br.com.hntecnologia.infra.enumeration.Mensagem;
import br.com.hntecnologia.infra.registroAtividades.InformarMensagem;
import br.com.hntecnologia.infra.util.Util;
import br.com.hntecnologia.infra.util.constantes.Classes;
import br.com.hntecnologia.infra.util.constantes.Constantes;
import br.com.hntecnologia.infra.util.mensagem.MensagemUtil;
 

public class Run {

	 private static final String diretorios = "/home/henrique/programa/projeto_java/ripe_cafe/suprimentos/src";
	public static void main(String[] args) {
		
		try {
			visualizarArquivos(diretorios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		Calendar calendar = Calendar.getInstance();			
		int cont =1;		
		calendar.setTime(new Date());
		while(cont<6){
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONDAY)+1);
	//		System.out.println(calendar.getTime());
			cont++;
		}
		 
		BigDecimal big = new BigDecimal(10.00);
		System.out.println(big);
		
		//System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		/*String resultado = new SimpleDateFormat("hh:mm:ss").format(new Date());
		
		System.out.println(Aceite.A.name());
		System.out.println(Aceite.N.name());*/
		
	/*System.out.println(TipoDeTitulo.DM_DUPLICATA_MERCANTIL.getCodigo());
		System.out.println(TipoDeTitulo.DS_DUPLICATA_DE_SERVICO.getCodigo());
		System.out.println(TipoDeTitulo.RC_RECIBO.getCodigo());
		System.out.println(TipoDeTitulo.NP_NOTA_PROMISSORIA.getCodigo());*/
		
		
		Map<String, String> unsortMap = new HashMap<String, String>();
		unsortMap.put("Z", "z");
		unsortMap.put("B", "b");
		unsortMap.put("A", "a");
		unsortMap.put("C", "c");
		unsortMap.put("D", "d");
		unsortMap.put("E", "e");
		unsortMap.put("Y", "y");
		unsortMap.put("N", "n");
		unsortMap.put("J", "j");
		unsortMap.put("M", "m");
		unsortMap.put("F", "f");

	//	System.out.println("Unsort Map......");
	//	printMap(unsortMap);

	//	System.out.println("\nSorted Map......");
	//	Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
	//	printMap(treeMap);
		
		
		Map<Date, String> Map1 = new HashMap<Date, String>();
		try {
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2016"), "1");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("07/01/2016"), "7");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("03/01/2016"), "3");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("20/01/2016"), "20");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("25/01/2016"), "25");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("14/01/2016"), "14");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("19/01/2016"), "19");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2016"), "5");
			Map1.put(new SimpleDateFormat("dd/MM/yyyy").parse("13/01/2016"), "13");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Map<Date, String> treeMap1 = new TreeMap<Date, String>(Map1);
		//printMap1(treeMap1);

	}

	public static void printMap1(Map<Date, String> map) {
		for (Map.Entry<Date, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
		}
	}
	
	
	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
		}
	}
	
	
	public static void visualizarArquivos(String diretorio) throws IOException {

		File file = new File(diretorio);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File arquivos = afile[i];
			System.out.println(arquivos.getName());
			if(afile[i].isDirectory()){
				
				visualizarArquivos(diretorio+"/"+arquivos.getName());
			}else{
				BufferedReader br = new BufferedReader(new FileReader(diretorio+"/"+arquivos.getName()));
				while(br.ready()){
				   String linha = br.readLine();
				   System.out.println(linha);
				   alteraLinha("br.com.hntecnologia", "suprimentos", diretorio+"/"+arquivos.getName());
				}
				br.close();
			}
			
			//break;
		}

	}

	public static void alteraLinha(String palavraAntiga, String palavraNova,String arquivo) throws IOException {
	 //   String arquivo = "ARQUIVO";
	    String arquivoTmp = "ARQUIVO-tmp";

	    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
	    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

	    String linha;
	    while ((linha = reader.readLine()) != null) {
	        if (linha.contains(palavraAntiga)) {
	            linha = linha.replace(palavraAntiga, palavraNova);
	        }
	        writer.write(linha + "\n");
	    }

	    writer.close();        
	    reader.close();

	    new File(arquivo).delete();
	    new File(arquivoTmp).renameTo(new File(arquivo));
	}
}
