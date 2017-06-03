package br.com.hntecnologia.infra.run.bd;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BD {

	public static void main(String[] args) throws IOException, SQLException {

		
		List<String>listaTables = new ArrayList<String>();
		Connection con = new BD().getConnection();
		String sequences = "SELECT * FROM unidade";
		PreparedStatement st = con.prepareStatement(sequences);
		
		ResultSet result = st.executeQuery();
		String insert = "insert into tb_unidade (id,ativo,data_cadastro,versao,descricao,abreviatura,quantidade,peso_liquido,"
				+ "peso_bruto,medida_liquida,medida_bruta,embalagem	) values ";
		while(result.next()){
			insert+="("+result.getInt("codigo")+",true,current_date,0,'"+result.getString("descricao")+"','"+result.getString("abreviatura")
					+ "',"+result.getInt("quantidade")+","+result.getInt("peso_liquido")+","+result.getInt("peso_bruto")
					+",'"+result.getString("medida_liquida")+"','"+result.getString("medida_bruta")+"','"
							+result.getString("embalagem")+ "'),";
				
		}
		
		System.out.println(insert);
		
		
		 
		// conectando
		//Connection con = new BD().getConnection();

		String sql = "select table_name from information_schema.tables where table_schema='public'";
		 listaTables = new ArrayList<String>();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);

			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				listaTables.add(res.getString("table_name"));
				
			}
			
			for(String texto : listaTables){
				//System.out.println(texto.substring(0, 2));
				if(!texto.equalsIgnoreCase("tb_perfil") && 
				!texto.equalsIgnoreCase("tb_pessoa_lista_pessoa_telefone") &&
				!texto.equalsIgnoreCase("tb_usuario_roles")&&
				texto.substring(0, 2).equalsIgnoreCase("tb")&&
				!texto.equalsIgnoreCase("tb_pessoa_lista_pessoa_contato")&&
				!texto.equalsIgnoreCase("tb_pessoa_lista_pessoa_endereco")				
				
				&&
				!texto.equalsIgnoreCase("view_c370")&&
				!texto.equalsIgnoreCase("view_c390")&&
				!texto.equalsIgnoreCase("view_sintegra_60d")&&
				!texto.equalsIgnoreCase("view_sintegra_60r")
						
				 	){
				/*String update = "update " + texto+" set ativo=true and versao=0 and data_cadastro=current_date";
				System.out.println(update);
				stmt= con.prepareStatement(update);
				stmt.executeUpdate();*/
				
				}
			}
			
			listaTables = new ArrayList<String>();
			
			  sequences = "SELECT * FROM information_schema.sequences";
			  st = con.prepareStatement(sequences);
			
			ResultSet results = st.executeQuery();
			if(results.next()){
				listaTables.add(results.getString("sequence_name"));
			}
			
			for(String texto : listaTables){
				String seq = "SELECT pg_catalog.setval('"+texto+"', 10, true);";
				System.out.println(seq);
				stmt= con.prepareStatement(seq);
				stmt.execute();
				
			}
			
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/acesse", "postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
