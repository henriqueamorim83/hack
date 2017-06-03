package br.com.hntecnologia.infra.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImporProdutos {
	
	
		private String path;

		public static void main ( String[] args )
		{

			// Carregando arquivo especifico
			ImporProdutos excel = new ImporProdutos("/home/henrique/Documentos/Ripe Café/produtosjorge.xlsx");
			// Apenas mostrando os valores
			excel.processAll();
		//	excel.processAll(excel.getPath());
			//excel.run();
		}

		public ImporProdutos(String path)
		{
			// Caminho do arquivo
			setPath(path);
		}

		
		public void processAll ()
		{
			try
			{
				// Leitura
				FileInputStream fi = new FileInputStream(new File(getPath()));

				// Carregando workbook
				XSSFWorkbook wb = new XSSFWorkbook(fi);

				// Selecionando a primeira aba
				XSSFSheet s = wb.getSheetAt(0);
				List<String[]> lista = new ArrayList<String[]>();
				// Fazendo um loop em todas as linhas
				String[] grupo = null;
				List<Integer> existe = new ArrayList<Integer>();
				int cont=0;
				for ( Row rowFor : s)
				{
					// FAzendo loop em todas as colunas
					if(cont>0){
						
					grupo =new String[2];		
					grupo[0]= 	String.valueOf(rowFor.getCell(1)).replace(".0", "");
					grupo[1]= String.valueOf(rowFor.getCell(4));
					lista.add(grupo);
					}
					cont++;
				}
			
					 
				 
				
				
				 FileWriter x = new FileWriter("/home/henrique/Documentos/Ripe Café/grupo.sql", false);  
			       
			      String insert = "insert into tb_grupo_produto (id,data_cadastro,ativo,versao, descricao,codigo) values "; 
				cont=0;
			      
			      for(String[] resultado: lista){
					
			    	  
			    		  insert+="("+cont+",current_date,true,0,'"+resultado[1]+"','"+resultado[0]+"'"+"),\n"; 
			    		  existe.add(Integer.valueOf(resultado[0]));
			    	 cont++;	
					 
				}
			      x.write(insert);  
				 x.close(); 
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		public void setPath ( String path )
		{
			this.path = path;
		}

		public String getPath ()
		{
			return path;
		}

		
		public void processAll( String caminho) {    
			 List<String[]> lista = new ArrayList<String[]>();
	        try {          
	            FileInputStream fi = new FileInputStream(new File(caminho));   
	            // Carregando workbook           
	            XSSFWorkbook wb = new XSSFWorkbook(fi);         
	            // Selecionando a primeira aba           
	            XSSFSheet s = wb.getSheetAt(0);         
	         
	            // Fazendo um loop em todas as linhas          
	            for (Row rowFor : s) {               
	                // FAzendo loop em todas as colunas   
	            	  String[] array = new String[6];
	            	int cont=0;
	                for (Cell cellFor : rowFor) {          
	                    try {                       
	                        // Verifica o tipo de dado       
	                        if (cellFor.getCellType() == Cell.CELL_TYPE_NUMERIC) {                                                    
	                                  // Mostrar numerico           
	                               //  System.out.println(Double.valueOf(cellFor.getNumericCellValue()).toString());  
	                                 array[cont]=String.valueOf(Double.valueOf(cellFor.getNumericCellValue()).toString());
	                            } else {                          
	                                // Mostrar String              
	                               // System.out.println(cellFor.getStringCellValue());     
	                                array[cont]=cellFor.getStringCellValue();
	                            }                   
	                        } catch (Exception e) {                 
	                            // Mostrar Erro                 
	                            System.out.println(e.getMessage());                
	                            } 
	                    cont++;
	                        }  
	                lista.add(array);
	                	
	                // Mostrar pulo de linha                
	                System.out.println("------------------------");        
	                }
	            	
	            } catch (Exception e) {        
	                    e.printStackTrace(); 
	                    }  
	        FileWriter arq;
			try {
				arq = new FileWriter("/home/henrique/ncm.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				 String insert="";
				 Integer cont=1;
				        	
				 System.out.println(lista.size());
		        for(String[] st : lista){
		        	
		        	//System.out.println(st[0]+" "+st[1]+" "+st[2]+" "+st[3]+" "+st[4]+" "+st[5]);
		        	
		       
		        if(cont==2168){
		        	break;
		        }
		        insert = "insert into tb_pr_ncm (id,data_cadastro,ativo,versao,codigo,ex,descricao,aliquota_nacional,aliquota_importada)";
		    			
		        insert +=" values ("+cont+",current_date,true,0,'"+st[0].trim().toString().replace(".0", "")+ "','"+st[1]+ "','"+st[2]+ "','"+st[3].toString().replace("\n", " ")+ "','"+st[4].toString().replace(".0", "")+ "','"+st[5].toString().replace(".0", "")+ "'"       	
			        	+");";
		        gravarArq.printf(insert); 	
			    System.out.println("contador: "+cont + " insert: " + insert); 
			    cont++;
			    insert="";
		        }
		        

		        arq.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		
		
		}     

		
		public void run() {

		    String arquivoCSV = "/home/henrique/Documentos/Ripe Café/ibpt_ncm (1).csv";
		    BufferedReader br = null;
		    String linha = "";
		    String csvDivisor = ";";
		    String insert="";
		    try {
		    	FileWriter 	arq = new FileWriter("/home/henrique/ncm.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
		        br = new BufferedReader(new FileReader(arquivoCSV));
		        while ((linha = br.readLine()) != null) {

		            String[] st = linha.split(csvDivisor);
		            	
			            System.out.println(st[0]+" "+st[1]+" "
			            +st[2]
			            		+" "+st[3].toString().replace("\n", " ")+" "+st[4]+" "+st[5]
			            				);
			         /*insert = "insert into tb_pr_ncm (id,data_cadastro,ativo,versao,codigo,ex,descricao,aliquota_nacional,aliquota_importada)"+
			        	" values (1,current_date,true,0,'" +st[0]+ "','"+st[1]+ "','"+st[2]+ "','"+st[3]+ "','"+st[4]+ "','"+st[5]+ "',"       	
			        	+"),";
			         gravarArq.printf(insert);*/

		        }
		        arq.close();
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		  }

	}
