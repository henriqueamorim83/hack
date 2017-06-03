package br.com.hntecnologia.infra.run.bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jca.endpoint.GenericMessageEndpointManager;

import de.hunsicker.jalopy.swing.syntax.SyntaxDocument;

public class Leitura {

	public static void main(String[] args) throws Exception {
			
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hndesen_ripe","postgres","postgres");
		
		String produto = "select id from tb_produto where ativo=false order by id asc";
		 
		 
		PreparedStatement pt ;
		
		PreparedStatement pr = con.prepareStatement(produto);
		ResultSet rs = pr.executeQuery();
		
		FileWriter arq = new FileWriter("/home/henrique/Documentos/delete.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	 
	  		
		while(rs.next()){
			String sql ="";
			
			sql = "delete from tb_produto_unidade where fk_id_produto=";
			sql +=rs.getLong("id");
			gravarArq.printf(sql+";%n");
			
			
			sql = "delete from tb_produto_receita where fk_id_produto=";
			sql +=rs.getLong("id");
			gravarArq.printf(sql+";%n");
			
			sql = "delete from tb_item_pedido where fk_id_produto=";
			sql +=rs.getLong("id");
			gravarArq.printf(sql+";%n");
			
			sql = "delete from tb_estoque_produto where fk_id_produto=";
			sql +=rs.getLong("id");
			gravarArq.printf(sql+";%n");
			
			
			 sql = "delete from tb_produto where id=";
			sql +=rs.getLong("id");
			gravarArq.printf(sql+";%n");
			 
			
			 
			
		}
		arq.close();
		System.out.println("terminou");
		con.close();
		//lerProdutos();
	}
	
	public static void lerProdutos() throws Exception{
		
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hndesen_ripe","postgres","postgres");
		 
		
		
		BufferedReader br = new BufferedReader(new FileReader("/home/henrique/Documentos/carnes.csv")); 
		while(br.ready()){ 
	   		String linha = br.readLine();  
	   		String[] array = linha.split(";");
	   		System.out.println(array[1]); 
	   		PreparedStatement p = con.prepareStatement("select * from tb_produto where upper(descricao) like '%"+array[1].toUpperCase()+"%' ");
	   		ResultSet rs = p.executeQuery();
		   		while(rs.next()){
		   			System.out.println(rs.getLong("id")+" "+rs.getInt("codigo_produto")+" "+rs.getString("descricao"));
		   		}
	   		
	   		break;
		} 
		con.close();
		br.close(); 
	}
	
	
	
	public static void selectNextval() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("/home/henrique/teste.txt")); 
		while(br.ready()){ 
   		String linha = br.readLine();    		
   		System.out.println("SELECT pg_catalog.setval('"+linha+"', 5000, true);"); 
		} 
		br.close(); 
	}
}
