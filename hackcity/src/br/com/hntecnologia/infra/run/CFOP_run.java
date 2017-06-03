package br.com.hntecnologia.infra.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CFOP_run
{
	private String path;

	public static void main ( String[] args )
	{

		// Carregando arquivo especifico
		CFOP_run excel = new CFOP_run("/home/henrique/Documentos/Ripe Café/CFOP.xlsx");
		// Apenas mostrando os valores
		excel.processAll();
	//	excel.processAll(excel.getPath());
		//excel.run();
	}

	public CFOP_run(String path)
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
			String[] array = new String[3];
			
			for ( Row rowFor : s)
			{
				// FAzendo loop em todas as colunas
				
				
				
				if( rowFor.getCell(0).getNumericCellValue()==0.0){
					lista.get(lista.size()-1)[2]+="  " +rowFor.getCell(2).getStringCellValue();
					
				}else{
					array = new String[3];
					array[0]=String.valueOf(rowFor.getCell(0).getNumericCellValue());
					array[1]=rowFor.getCell(1).getStringCellValue();				
					array[2]=String.valueOf(rowFor.getCell(2));
					lista.add(array);
				}	
					
					/*System.out.println(rowFor.getCell(0).getNumericCellValue()+"  1  "
						+rowFor.getCell(1).getStringCellValue()+"  2"
						+rowFor.getCell(2).getStringCellValue()
						); */

			}
			
			System.out.println("Terminou : " +lista.size());
			 FileWriter x = new FileWriter("/home/henrique/Documentos/Ripe Café/cfop.sql", false);  
		       
		      String insert = "insert into tb_pr_cfop (id,data_cadastro,ativo,versao,cfop, descricao, aplicacao) values "; 
			int cont=1;
		      for(String[] resultado: lista){
				//System.out.println(" 0 "+resultado[0] +" 1  "+resultado[1]+" 2  "+ resultado[2]);
				insert+="("+cont+",current_date,true,0,'"+resultado[0].replace(".0", "")+"','"+resultado[1]+"','"+resultado[2]+"'),\n"; 
				
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
