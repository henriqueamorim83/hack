package br.com.hntecnologia.infra.enumeration;

public enum Mensagem {
	//mensagem genérica
	MENSAGEM_CADASTRO_ADICIONADO_COM_SUCESSO("cadastro_inserir_com_sucesso"),
	MENSAGEM_CADASTRO_ATUALIZADO_COM_SUCESSO("cadastro_atualizado_com_sucesso"),
	MENSAGEM_CADASTRO_REMOVIDO_COM_SUCESSO("cadastro_removido_com_sucesso"),
	MENSAGEM_CADASTRO_USUARIO_SENHA_REDEFINIDA("cadastro_usuario_senha_redefinida"),
	MENSAGEM_CADASTRO_ESTOQUE_UNIDADE_ENTRADA("cadastro_produto_unidade_entrada"),
	MENSAGEM_LANCAMENTO_ESTOQUE_QTD_COMPRADA("cadastro_lancamento_estoque_qtd_comprada"),
	MENSAGEM_PAGAMENTO_REALIZADO_COM_SUCESSO("pagamento_realizado_com_sucesso"),
	MENSAGEM_LANCAMENTO_ESTOQUE_QTD_SAIDA("cadastro_lancamento_estoque_qtd_saida"),	
	MENSAGEM_TITULO_BOLETO_DUPLICATA_MERCANTIL("cadastro_boleto_bancario_label_especie_duplicata_mercantil"),
	MENSAGEM_TITULO_BOLETO_DUPLICATA_SERVICOS("cadastro_boleto_bancario_label_especie_duplicata_servicos"),
	MENSAGEM_TITULO_BOLETO_RECIBO("cadastro_boleto_bancario_label_especie_recibo"),
	MENSAGEM_TITULO_BOLETO_NOTA_PROMISSORIA("cadastro_boleto_bancario_label_especie_nota_promissoria"),	
	MENSAGEM_CADASTRO_BASE_PAGAMENTO_RECEBIMENTOS("fin_pagamento_recebimento_cadastro_base");

	private String key;
	
	private Mensagem(final String key) {
		this.setKey(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	
}
