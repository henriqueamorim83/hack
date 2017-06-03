package br.com.hntecnologia.infra.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sourceforge.barbecue.Main;

public class InsertProdutoUnidadeGrama {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hndesen_ripe","postgres","postgres");
			String sqlProdutos = "select id from tb_produto";
			PreparedStatement pt = conexao.prepareStatement(sqlProdutos);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()){
				Long id = rs.getLong("id");
				String insert ="insert into tb_produto_unidade (id,ativo,versao,data_cadastro,fk_id_empresa,fk_id_produto,fk_id_unidade) values (nextval('tb_produto_unidade_id_seq'),true,0,current_date,1,?,5006);";
				PreparedStatement pe = conexao.prepareStatement(insert);
				pe.setLong(1, id);
				Integer r =  pe.executeUpdate();
				 System.out.println(r);
				pe.close();
			}
			
			rs.close();
			pt.close();
			conexao.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
