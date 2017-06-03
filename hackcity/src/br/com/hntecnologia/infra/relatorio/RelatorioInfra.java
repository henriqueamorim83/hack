package br.com.hntecnologia.infra.relatorio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;


public class RelatorioInfra {
	
	
	public static final String RELATORIO_PRODUTOS="relatorio_produto.jasper";

	public static final String RELATORIO_FORNECEDORES="relatorio_fornecedores.jasper";
	
	public static final String RELATORIO_CLIENTES="relatorio_clientes.jasper";
	
	public static final String RELATORIO_RECEITAS="relatorio_receitas.jasper";
	
	public static final String RELATORIO_RECEITAS_SINTETICO="relatorio_produto_ripe.jasper";
	
	public static final String RELATORIO_ESTOQUE="relatorio_estoque.jasper";
	public static final String RELATORIO_ESTOQUE_VALIDADE="relatorio_estoque_validade.jasper";
	public static final String RELATORIO_ESTOQUE_LANCAMENTO_ENTRADA="estoque_lancamento_entrada.jasper";
	public static final String RELATORIO_ESTOQUE_LANCAMENTO_PRODUTOS="estoque_lancamento_itens.jasper";
	public static final String RELATORIO_ESTOQUE_LANCAMENTO_SAIDA="estoque_lancamento_saida.jasper";
	
	public static final String RELATORIO_DESPESAS="relatorio_despesas.jasper";
	
	public static final String RELATORIO_VENDAS="relatorio_vendas.jasper";
	
	public static final String RELATORIO_VENDAS_SINTETICO="relatorio_vendas_detalhado.jasper";
	public static final String RELATORIO_VENDAS_ABERTO="relatorio_vendas_aberto.jasper";
	public static final String RELATORIO_COMPRAS_PEDIDO="relatorio_compras_pedido.jasper";


private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_RECEITAS = new DynaProperty[] {

		
	new DynaProperty("descricao", String.class),	
	new DynaProperty("preco_unitario", String.class),	
	new DynaProperty("preco_venda", String.class),	
	new DynaProperty("dias_vencimento", Integer.class),	
	new DynaProperty("valor_total_insumos", String.class),	
	new DynaProperty("grupo", String.class),	
	new DynaProperty("categoria", String.class),	
	new DynaProperty("margem", String.class),	
	new DynaProperty("usuario", String.class),	
	new DynaProperty("dataPorExtenso", String.class),	
	new DynaProperty("lista", List.class)

};

public static final DynaClass LISTAGEM_RECEITAS = new BasicDynaClass("LISTAGEM_RECEITAS", null,ATRIBUTOS_RELATORIO_LISTAGEM_RECEITAS);
	
	

private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_INSUMOS_RECEITAS = new DynaProperty[] {

		
	new DynaProperty("codigoProduto", Integer.class),	
	new DynaProperty("descricao", String.class),	
	new DynaProperty("ean", String.class),	
	new DynaProperty("precoVenda", String.class),	
	new DynaProperty("quantidade", String.class),	
	new DynaProperty("unidade", String.class)
	

};

public static final DynaClass LISTAGEM_INSUMOS_RECEITAS = new BasicDynaClass("LISTAGEM_INSUMOS_RECEITAS", null,ATRIBUTOS_RELATORIO_LISTAGEM_INSUMOS_RECEITAS);
	
	
	
	
	
	

private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_PRODUTOS = new DynaProperty[] {

		
	new DynaProperty("codigoProduto", String.class),	
	new DynaProperty("descricao", String.class),	
	new DynaProperty("ean", String.class),	
	new DynaProperty("unidades", String.class),	
	new DynaProperty("grupo", String.class),	
	new DynaProperty("categoria", String.class),	
	new DynaProperty("subCategoria", String.class),	
	new DynaProperty("precoCompra", String.class),	
	new DynaProperty("precoVenda", String.class),	
	new DynaProperty("usuario", String.class),	
	new DynaProperty("dataPorExtenso", String.class),	
	new DynaProperty("margem", String.class)

};

public static final DynaClass LISTAGEM_PRODUTOS = new BasicDynaClass("LISTAGEM_PRODUTOS", null,ATRIBUTOS_RELATORIO_LISTAGEM_PRODUTOS);
	




private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_FORNECEDORES	 = new DynaProperty[] {

		
	new DynaProperty("cnpj", String.class),	
	new DynaProperty("razaoSocial", String.class),	
	new DynaProperty("endereco", String.class),	
	new DynaProperty("contato", String.class),	
	new DynaProperty("celular", String.class),	
	new DynaProperty("email", String.class)


};

public static final DynaClass LISTAGEM_FORNECEDORES = new BasicDynaClass("LISTAGEM_FORNECEDORES", null,ATRIBUTOS_RELATORIO_LISTAGEM_FORNECEDORES);
	





private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_CLIENTES	 = new DynaProperty[] {

		
	new DynaProperty("cnpj", String.class),	
	new DynaProperty("razaoSocial", String.class),	
	new DynaProperty("endereco", String.class),	
	new DynaProperty("contato", String.class),	
	new DynaProperty("celular", String.class),	
	new DynaProperty("email", String.class)


};

public static final DynaClass LISTAGEM_CLIENTES = new BasicDynaClass("LISTAGEM_CLIENTES", null,ATRIBUTOS_RELATORIO_LISTAGEM_CLIENTES);
	



private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_ESTOQUE	 = new DynaProperty[] {

		
	new DynaProperty("codigoProduto", String.class),	
	new DynaProperty("descricao", String.class),
	new DynaProperty("ean", String.class),	
	new DynaProperty("fornecedor", String.class),	
	new DynaProperty("grupo", String.class),	
	new DynaProperty("categoria", String.class),	
	new DynaProperty("subcategoria", String.class),	
	new DynaProperty("margem", String.class),	
	new DynaProperty("precoCompra", String.class),	
	new DynaProperty("precoVenda", String.class),
	new DynaProperty("qtdMinima", String.class),	
	new DynaProperty("qtdMaxima", String.class)	,		
	new DynaProperty("quantidade", String.class),
	new DynaProperty("usuario", String.class),
	new DynaProperty("dataPorExtenso", String.class),
	new DynaProperty("localEstoque", String.class),
	new DynaProperty("listaEntradas", List.class),
	new DynaProperty("listaSaidas", List.class)
	


};

public static final DynaClass LISTAGEM_ESTOQUE = new BasicDynaClass("LISTAGEM_ESTOQUE", null,ATRIBUTOS_RELATORIO_LISTAGEM_ESTOQUE);
	


private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_ENTRADAS_ESTOQUE = new DynaProperty[] {

		new DynaProperty("localEstoque", String.class),
		new DynaProperty("dataEntrada", String.class),	
		new DynaProperty("dataEmissao", String.class),	
		new DynaProperty("numeroNota", String.class),	
		new DynaProperty("serie", String.class),	
		new DynaProperty("quantidade", String.class),
		new DynaProperty("unidadeCompra", String.class),		
		new DynaProperty("dataValidade", String.class),	
		new DynaProperty("lote", String.class),	
		new DynaProperty("operador", String.class),	
		new DynaProperty("pedido", String.class),		
		new DynaProperty("usuario", String.class),		
		new DynaProperty("dataPorExtenso", String.class),		
		new DynaProperty("precoCompra", String.class)
		

	};

	public static final DynaClass LISTAGEM_ENTRADAS_ESTOQUE  = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_ENTRADAS_ESTOQUE", null,ATRIBUTOS_RELATORIO_LISTAGEM_ENTRADAS_ESTOQUE);
		

	private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_SAIDA_ESTOQUE = new DynaProperty[] {

			
			new DynaProperty("codigoProduto", Integer.class),	
			new DynaProperty("descricao", String.class),	
			new DynaProperty("ean", String.class),	
			new DynaProperty("precoVenda", String.class),	
			new DynaProperty("quantidade", String.class),	
			new DynaProperty("unidade", String.class)
			

		};

		public static final DynaClass LISTAGEM_SAIDA_ESTOQUE = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_ENTRADAS_SAIDA", null,ATRIBUTOS_RELATORIO_LISTAGEM_SAIDA_ESTOQUE);
		

		private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_DESPESAS = new DynaProperty[] {

				
				new DynaProperty("cliente", String.class),	
				new DynaProperty("descricao", String.class),
				new DynaProperty("titulo", String.class),
				new DynaProperty("dataInicio", String.class),
				new DynaProperty("dataFinal", String.class),
				new DynaProperty("valor", String.class),
				new DynaProperty("situacao", String.class),
				new DynaProperty("codigo_barras", String.class)
				

			};

			public static final DynaClass LISTAGEM_DESPESAS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_DESPESAS", null,ATRIBUTOS_RELATORIO_LISTAGEM_DESPESAS);
			
			
		
			private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS = new DynaProperty[] {
					
					new DynaProperty("numeroPedido", String.class),	
					new DynaProperty("cliente", String.class),
					new DynaProperty("dataVenda", String.class),
					new DynaProperty("situacao", String.class),
					new DynaProperty("desconto", String.class),
					new DynaProperty("usuarioDesconto", String.class),
					new DynaProperty("frete", String.class),
					new DynaProperty("outros", String.class),
					new DynaProperty("valorTotal", String.class),
					new DynaProperty("formaPagamento", String.class),
					new DynaProperty("parcelamento", String.class),
					new DynaProperty("dataPorExtenso", String.class),
					new DynaProperty("dataInicio", String.class),
					new DynaProperty("dataFinal", String.class),
					new DynaProperty("usuario", String.class)
					

				};

				public static final DynaClass LISTAGEM_VENDAS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS);
				
				
				private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_RECEITAS = new DynaProperty[] {
						
						 
						new DynaProperty("grupo", String.class),
						new DynaProperty("categoria", String.class),
						new DynaProperty("descricao", String.class),
						new DynaProperty("valorUnitario", String.class),
						new DynaProperty("quantidade", String.class),					
						new DynaProperty("valorVenda", String.class)
						
						

					};

					public static final DynaClass LISTAGEM_VENDAS_RECEITAS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_RECEITAS", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_RECEITAS);
					
					private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_PAGAMENTOS = new DynaProperty[] {
							
							new DynaProperty("vencimento", String.class),	
							new DynaProperty("parcela", String.class),
							new DynaProperty("valor", String.class),
							new DynaProperty("situacao", String.class)
							
							

						};

						public static final DynaClass LISTAGEM_VENDAS_PAGAMENTOS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_PAGAMENTOS", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_PAGAMENTOS);
						
					
				
				private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_SINTETICO = new DynaProperty[] {
						
						new DynaProperty("numeroPedido", String.class),	
						new DynaProperty("cliente", String.class),
						new DynaProperty("dataVenda", String.class),
						new DynaProperty("situacao", String.class),
						new DynaProperty("desconto", String.class),
						new DynaProperty("usuarioDesconto", String.class),
						new DynaProperty("frete", String.class),
						new DynaProperty("outros", String.class),
						new DynaProperty("valorTotal", String.class),
						new DynaProperty("formaPagamento", String.class),
						new DynaProperty("parcelamento", String.class),
						new DynaProperty("dataPorExtenso", String.class),
						new DynaProperty("dataInicio", String.class),
						new DynaProperty("dataFinal", String.class),
						new DynaProperty("listaProdutos", List.class),
						new DynaProperty("listaParcelamentos", List.class),
						new DynaProperty("usuario", String.class)
						

					};

					public static final DynaClass LISTAGEM_VENDAS_SINTETICO = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_SINTETICO", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_SINTETICO);
					
					
private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_ABERTO_PRODUTOS = new DynaProperty[] {
							
							new DynaProperty("data", String.class),	
							new DynaProperty("produto", String.class),
							new DynaProperty("quantidade", String.class),
							new DynaProperty("unidade", String.class)						

						};

	public static final DynaClass LISTAGEM_VENDAS_ABERTO_PRODUTOS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_ABERTO_PRODUTOS", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_ABERTO_PRODUTOS);
						


	private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_ABERTO = new DynaProperty[] {
			
			new DynaProperty("cliente", String.class),	
			new DynaProperty("produtos", List.class),			 
			new DynaProperty("produtoRipe", List.class)						

		};

public static final DynaClass LISTAGEM_VENDAS_ABERTO = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_ABERTO", null,ATRIBUTOS_RELATORIO_LISTAGEM_VENDAS_ABERTO);

			
private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDOS = new DynaProperty[] {
		
		new DynaProperty("fornecedor", String.class),	
		new DynaProperty("cliente", String.class),
		new DynaProperty("dataPedido", String.class),
		new DynaProperty("tipo", String.class),
		new DynaProperty("valorDesconto", String.class),
		new DynaProperty("usuarioDesconto", String.class),
		new DynaProperty("frete", String.class),
		new DynaProperty("localEntrega", String.class),
		new DynaProperty("localCobranca", String.class),
		new DynaProperty("valorTotal", String.class),
		new DynaProperty("formaPagamento", String.class),
		new DynaProperty("previsaoEntrega", String.class),
		new DynaProperty("previsaoPagamento", String.class),
		new DynaProperty("contato", String.class),
		new DynaProperty("dataPorExtenso", String.class),
		new DynaProperty("taxaDesconto", String.class),
		new DynaProperty("subTotal", String.class),
		new DynaProperty("listaProdutos", List.class),		
		new DynaProperty("usuario", String.class)
		

	};

	public static final DynaClass LISTAGEM_COMPRAS_VENDAS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDOS", null,ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDOS);
	
private static final DynaProperty[] ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDO_PRODUTOS = new DynaProperty[] {
			
			new DynaProperty("produto", String.class),	
			new DynaProperty("quantidade", String.class),	
			new DynaProperty("unidade", String.class),	
			new DynaProperty("valorUnitario", String.class),	
			new DynaProperty("valorDesconto", String.class),	
			new DynaProperty("valorTotal", String.class)						

		};

public static final DynaClass LISTAGEM_VENDAS_COMPRAS_PEDIDO_PRODUTOS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDO_PRODUTOS", null,ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDO_PRODUTOS);



private static final DynaProperty[] ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ENTRADA = new DynaProperty[] {
		
		new DynaProperty("data", String.class),	
		new DynaProperty("tipo", String.class),	
		new DynaProperty("localEstoque", String.class),	
		new DynaProperty("numeroItens", String.class),	
		new DynaProperty("valorTotal", String.class),	
		new DynaProperty("numeroNota", String.class),	
		new DynaProperty("serie", String.class),	
		new DynaProperty("dataEmissao", String.class),	
		new DynaProperty("valorAdicional", String.class),	
		new DynaProperty("itens", List.class),	
		new DynaProperty("observacoes", String.class),
		new DynaProperty("confirmacao", String.class)	

	};

public static final DynaClass LISTAGEM_RELATORIO_LANCAMENTO_ESTOQUE_ENTRADA = new BasicDynaClass("ATRIBUTOS_RELATORIO_LISTAGEM_COMPRAS_PEDIDO_PRODUTOS", null,ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ENTRADA);

private static final DynaProperty[] ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ITENS = new DynaProperty[] {
		
		new DynaProperty("codigo", String.class),	
		new DynaProperty("item", String.class),	
		new DynaProperty("quantidade", String.class),	
		new DynaProperty("unidade", String.class),	
		new DynaProperty("valorCompra", String.class),	
		new DynaProperty("valorTotal", String.class),	
		new DynaProperty("saldo", String.class),	
		new DynaProperty("validade", String.class)	
		 					

	};

public static final DynaClass LISTAGEM_ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ITENS = new BasicDynaClass("ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ITENS", null,ATRIBUTOS_RELATORIO_LANCAMENTO_ESTOQUE_ITENS);



}
