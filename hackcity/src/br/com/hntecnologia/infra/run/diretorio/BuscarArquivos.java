package br.com.hntecnologia.infra.run.diretorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hntecnologia.infra.util.Util;

public class BuscarArquivos {

	
	  private static int cont = 0;   
	  
	  public static List<String> lista = new ArrayList<String>();
	    /** 
	     * 
	     * @param args 
	     * @throws IOException 
	     */  
	    public static void main( String[] args ) throws IOException{  
	  
	        String dir = "/home/henrique/programa/projeto_java/ripe_cafe/ripe/src/ripe/cafe/negocio/";  
	        File diretorio = new File(dir);  
	        
	        String[] arquivos = diretorio.list();  
	        
	        	
		       
		        for (int i=0; i<arquivos.length; i++) {
		        //	gravarArq.printf(arquivos[i].substring(0, arquivos[i].length()-5)+"\n");
		        //	System.out.println((arquivos[i].substring(0, arquivos[i].length()-5)));
		        	listFiles(new File(dir+arquivos[i]));
		        	}

		     
		       FileWriter arq = new FileWriter("/home/henrique/resultado1.txt");
	        	 if(Util.isListNaoNulaNaoVazia(lista)){
	        		 PrintWriter gravarArq = new PrintWriter(arq);
	        		 for(String nome : lista){
	        			 gravarArq.printf(nome+" \n");
	        			// System.out.println(nome);
	        		 }
	        	 }
	        	  arq.close();
	       
				
	        	  leitor("/home/henrique/resultado1.txt");
	        	  //escritor("/home/henrique/resultado1.txt");
	       
	    }  
	  
	    public static void leitor(String path) throws IOException {
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			while (true) {
				if (linha != null) {
					System.out.println(linha);

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();
		}

		public static void escritor(String path) throws IOException {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			String linha = "";
			Scanner in = new Scanner(System.in);
			System.out.println("Escreva algo: ");
			linha = in.nextLine();
			buffWrite.append(linha + "\n");
			buffWrite.close();
		}

	    
	    
	    
	    /** 
	     * Conta o total de arquivo num determinado diretorio 
	     * 
	     * @param diretorio 
	     * @throws IOException 
	     */  
	    private static void listFiles( File diretorio ) throws IOException{  
	  
	        String[] arquivos = diretorio.list();  
	  
	        for (int i = 0; i < arquivos.length; i++ ){  
	  
	            String string = arquivos[i];  
	  
	            File diretorioRaiz = new File(diretorio.getAbsolutePath() + "\\" + string);  
	  
	            if ( diretorioRaiz.isDirectory() ){  
	                listFiles(diretorioRaiz);  
	            } else if ( diretorioRaiz.isFile() ){  
	  
	                String nameFile = diretorioRaiz.getName();  
	                lista.add(nameFile);
	                int fileSize = nameFile.length();  
	  
	                String extensao = nameFile.substring(fileSize - 5 , fileSize);  
	  
	                if(extensao.compareToIgnoreCase(".java")==0)  
	                    cont++;  
	  
	            } else{  
	               // System.out.println("Nem arquivo nem diretorio!!!!!!");  
	           //     System.out.println(string); 	
	                lista.add(string);
	            }  
	  
	        }  

	        FileWriter arq = new FileWriter("/home/henrique/resultado.txt");
	        PrintWriter gravarArq = new PrintWriter(arq);
	        for (int i=0; i<arquivos.length; i++) {
	        	gravarArq.printf(""+arquivos[i].substring(0, arquivos[i].length()-5)+" \n");
	        	}

	       arq.close();
	        
	    } 
	    
	    
}
