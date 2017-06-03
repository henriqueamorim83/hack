package br.com.hntecnologia.infra.enumeration;

import br.com.hntecnologia.infra.util.PropertiesUtil;


public enum ErroMessage  {
	//cadastro usuário
	ERROR_USUARIO_DUPLICATE_LOGIN("cadastro_usuario_duplicate_login"),
	ERROR_DATA_HORA_INVALIDA("error_validacao_hora"),
	//generico
	ERROR_CADASTRO_INSERIR("cadastro_inserir_erro_cadastro"),
	ERROR_CADASTRO_ATUALIZAR("cadastro_atualizar_erro_cadastro"),
	ERROR_CADASTRO_REMOVER("cadastro_excluir_erro_cadastro"),
	ERROR_CADASTRO_CONSULTAR("cadastro_consultar_erro_cadastro"),
	ERROR_CADASTRO_PRODUTO_UNIDADE_COMPRA_VENDA("cadastro_produto_unidade_compra_venda"),
	ERROR_CADASTRO_USUARIO_NAO_ENCONTRADO("cadastro_usuario_nao_encontrado"),
	ERROR_CADASTRO_USUARIO_SENHA_INVALIDA("cadastro_usuario_senha_invalida"),
	ERROR_CADASTRO_USUARIO_LOGIN_JA_UTILIZADO("cadastro_usuario_login_em_uso"),
	ERROR_CADASTRO_USUARIO_SELECIONAR_CLIENTE_COLABORADOR("cadastro_usuario_cliente_colaborador"),
	ERROR_CADASTRO_USUARIO_SELECIONAR_CLIENTE_COLABORADOR_VAZIO("cadastro_usuario_cliente_colaborador_vazio"),
	ERRO_VALIDACAR_CPF_CNPJ("validar_cpf_cnpj"),
	ERRO_VALIDAR_UNIDADE_PADRAO_COMPRA("validar_unidade_padrao_ja_selecionada"),
	ERROR_CADASTRO_USUARIO_SENHA_CONFIRMACAO_NAO_CONFERE("cadastro_usuario_senha_e_confirmacao_nao_confere"),
	//cadastro produto
	ERROR_CADASTRO_PRODUTO_QTD_MINIMA_MAIOR_QTD_MAXIMA("cadastro_produto_qtd_minimo_maior_qtd_maxima"),
	ERROR_CADASTRO_PRODUTO_QTD_MAXIMA_MENOR_QTD_MINIMA("cadastro_produto_qtd_maxima_menor_qtd_minima"),
	ERROR_CADASTRO_PRODUTO_PRECO_COMPRA_MAIOR_PRECO_VENDA("cadastro_produto_preco_compra_maior_preco_venda"),
	ERROR_CADASTRO_PRODUTO_PRECO_VENDA_MENOR_PRECO_COMPRA("cadastro_produto_preco_venda_menor_preco_compra"),
	ERROR_CADASTRO_PRODUTO_CAMPOS_OBRIGATORIOS_CADASTRO_UNIDADE("cadastro_produto_campos_obrigatorios_cadastro_unidade"),
	ERROR_CADASTRO_PRODUTO_VALIDAR_CODIGO_BARRAS("cadastro_produto_validar_codigo_barras"),
	
	USUARIO_ADMINISTRADOR_CADASTRAR_UNIDADE("usuario_administrador_cadastrar_unidade"),
	//cadastro lancamento estoque
	ERROR_LANCAMENTO_ESTOQUE_DATA_LANCAMENTO("cadastro_lancamento_estoque_data_lancamento"),
	ERROR_LANCAMENTO_ESTOQUE_DATA_EMISSAO("cadastro_lancamento_estoque_data_emissao"),
	ERROR_LANCAMENTO_ESTOQUE_DATA_PRODUTO_VALIDADE("cadastro_lancamento_estoque_data_validade"),
	ERROR_LANCAMENTO_ESTOQUE_IMPOSTOS_NULO("cadastro_lancamento_estoque_impostos_nulo"),
	
	//pedido
	ERROR_PEDIDO_CLIENTE_VAZIO("cadastro_pedido_cliente_vazio"),
	ERROR_PEDIDO_ENDERECO_ENTREGA_VAZIO("cadastro_pedido_endereco_entrega_vazio"),
	ERROR_PEDIDO_ENDERECO_FATURAMENTO_VAZIO("cadastro_pedido_endereco_faturamento_vazio"),
	ERROR_PEDIDO_LISTA_RECEITAS_VAZIA("cadastro_pedido_lista_receita_vazia"),
	ERROR_PEDIDO_USUARIO_DESCONTO_VAZIO("cadastro_pedido_usuario_desconto_vazio"),
	ERROR_PEDIDO_CANCELAR_SOMENTE_EM_ABERTO("cadastro_pedido_cancelar_somente_em_aberto"),
	
	//#pessoa
	ERROR_CAD_PESSOA_LISTA_CONTATOS("cadastro_pessoa_lista_contatos"),
	ERROR_CAD_PESSOA_LISTA_ENDERECOS("cadastro_pessoa_lista_enderecos"),
	ERROR_CAD_PESSOA_LISTA_TELEFONES("cadastro_pessoa_lista_telefones"),
	//saida estoque
	ERROR_SAIDA_ESTOQUE_DATA_LANCAMENTO("cadastro_saida_estoque_data_saida"),
	ERROR_SAIDA_ESTOQUE_DATA_EMISSAO("cadastro_saida_estoque_data_emissao"),
	ERROR_SAIDA_ESTOQUE_DATA_PRODUTO_VALIDADE("cadastro_saida_estoque_data_validade"),
	ERROR_SAIDA_ESTOQUE_QTD_SAIDA_ACIMA_VALOR_REAL("cadastro_saida_estoque_qtd_saida_acima_valor_real"),
	ERROR_LANCAMENTO_PAGAR_CONTA_CAIXA_OBRIGATORIA("error_lancamento_pagar_conta_caixa_obrigatoria"),
	ERROR_LANCAMENTO_PAGAR_NATUREZA_FINANCEIRA_OBRIGATORIA("error_lancamento_pagar_natureza_financeira_obrigatoria")
	
	;
	private String key;
	
	private ErroMessage(final String key) {
		this.setKey(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String keyResult(String key){
		setKey(key);
		return getKey();
	}
	
	
	
	

	
}
