package br.com.hntecnologia.infra.util.constantes;

import br.com.hntecnologia.infra.util.mensagem.MensagemUtil;

public class Classes {
	
	public static final String  USUARIO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.usuario.Usuario");
	public static final String  PERFIL=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.usuario.Perfil");
	
	public static final String  BAIRRO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Bairro");
	public static final String  LOGRADOURO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Logradouro");
	public static final String  CIDADE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Cidade");
	public static final String  ESTADO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Estado");
	public static final String  ENDERECO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Endereco");
	public static final String  PAIS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.endereco.Pais");
	public static final String  PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.Produto");
	public static final String  UNIDADE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.Unidade");
	public static final String  PRODUTO_UNIDADE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.ProdutoUnidade");
	public static final String  CATEGORIA_PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.categoria.CategoriaProduto");
	public static final String  SUB_CATEGORIA_PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.categoria.SubCategoria");
	public static final String  GRUPO_PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.categoria.GrupoProduto");
	public static final String  RECEITA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.receita.Receita");
	public static final String  GRUPO_RECEITA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.receita.GrupoReceita");
	public static final String  CATEGORIA_RECEITA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.receita.CategoriaReceita");
	public static final String  PRODUTO_RECEITA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.receita.ProdutoReceita");
	public static final String  GRUPO_FISCAL=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.fiscal.GrupoFiscal");
	public static final String  ITEM_PEDIDO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.ItemPedido");

	public static final String  ICMS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.fiscal.ICMS");
	public static final String  IPI=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.fiscal.IPI");
	public static final String  ORIGEM_MERCADORIA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.parametrizacao.OrigemMercadoria");
	public static final String  REGIME_TRIBUTARIO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.parametrizacao.RegimeTributario");
	public static final String  SITUACAO_TRIBUTARIA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.parametrizacao.SituacaoTributaria");
	public static final String  PRODUTO_COMPOSTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.produto.ProdutoComposto");
	
	public static final String  LOCAL_ESTOQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.estoque.LocalEstoque");
	public static final String  ESTOQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.estoque.Estoque");
	public static final String  LANCAMENTO_ESTOQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.estoque.LancamentoEstoque");
	public static final String  SAIDA_ESTOQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.estoque.SaidaEstoque");
	public static final String  ESTOQUE_PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.estoque.EstoqueProduto");
	
	
	public static final String  PEDIDO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.Pedido");
	public static final String  PEDIDO_PRODUTOS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.PedidoProdutos");
	public static final String  PEDIDO_PAGAMENTOS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.PedidoPagamentos");
	public static final String  FORMA_DE_PAGAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.FormaDePagamento");
	public static final String  SITUACAO_PAGAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.SituacaoPagamento");
	public static final String  SITUACAO_PEDIDO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.SituacaoPedido");
	public static final String  PARCELAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.Parcelamento");
	public static final String  CREDITO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.vendas.Credito");
	public static final String  DESPESAS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.Despesas");

	public static final String  ESTADO_CIVIL=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.EstadoCivil");
	public static final String  PESSOA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.Pessoa");
	public static final String  PESSOA_ALTERACAO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaAlteracao");
	public static final String  PESSOA_CONTATO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaContato");
	public static final String  PESSOA_ENDERECO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaEndereco");
	public static final String  PESSOA_FISICA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaFisica");
	public static final String  PESSOA_JURIDICA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaJuridica");
	public static final String  PESSOA_TELEFONE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.PessoaTelefone");
	public static final String  CLIENTE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.Cliente");
	public static final String  FORNECEDOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.Fornecedor");
	public static final String  TRANSPORTADORA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.Transportadora");
	
	public static final String  ATIVIDIDADE_FOR_CLI=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.AtividadeForCli");
	public static final String  SITUACAO_FOR_CLI=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.pessoa.SituacaoForCli");
	
	public static final String  CARGO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.Cargo");
	public static final String  COLABORADOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.Colaborador");
	public static final String  NIVELFORMACAO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.NivelFormacao");
	public static final String  SITUACAO_COLABORADOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.SituacaoColaborador");
	public static final String  TIPO_ADMISSAO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.TipoAdmissao");
	public static final String  TIPO_COLABORADOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.TipoColaborador");
	public static final String  TIPO_DESLIGAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.TipoDesligamento");
	public static final String  TIPO_RELACIONAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.rh.TipoRelacionamento");
	
	public static final String  SETOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.diversos.Setor");
	public static final String  ALMOXARIFADO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.diversos.Almoxarifado");
	public static final String  FERIADOS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.diversos.Feriados");
	public static final String  OPERADORA_PLANO_SAUDE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.diversos.OperadoraPlanoSaude");
	

	public static final String  CHEQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.Cheque");
	public static final String  CONTA_CAIXA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.ContaCaixa");
	public static final String  TALONARIO_CHEQUE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.TalonarioCheque");
	public static final String  BANCO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.Banco");
	public static final String  AGENCIA_BANCO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.AgenciaBanco");
	public static final String  OPERADORA_CARTAO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.OperadoraCartao");
	public static final String  BOLETO_BANCARIO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.BoletoBancario");
	public static final String  FIN_TIPO_PAGAMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinTipoPagamento");
	public static final String  FIN_TIPO_RECEBIMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinTipoRecebimento");
	public static final String  FIN_STATUS_PARCELA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinStatusParcela");
	public static final String  PLANO_NATUREZA_FINANCEIRA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.PlanoNaturezaFinanceira");
	public static final String NATUREZA_FINANCEIRA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.NaturezaFinanceira");
	public static final String FIN_DOCUMENTO_ORIGEM=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinDocumentoOrigem");
	public static final String FIN_CHEQUE_EMITIDO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinChequeEmitido");
	public static final String FIN_LANCAMENTO_A_PAGAR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinLancamentoPagar");
	
	public static final String FIN_LANCAMENTO_A_RECEBER=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinLancamentoReceber");
	public static final String FIN_COBRANCA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinCobranca");
	
	
	public static final String FIN_PARCELA_PAGAR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinParcelaPagar");
	public static final String FIN_PARCELA_RECEBER=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinParcelaReceber");
	public static final String FIN_PARCELA_RECEBIMENTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinParcelaRecebimento");
	public static final String FIN_PAGAMENTO_FIXO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinPagamentoFixo");
	public static final String FIN_CHEQUE_RECEBIDO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinChequeRecebido");
	
	public static final String FIN_LACTO_PAGAR_NT_FINANCEIRA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinLctoPagarNtFinanceira");
	public static final String FIN_LACTO_RECEBER_NT_FINANCEIRA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinLctoReceberNtFinanceira");
	public static final String FIN_FECHAMENTO_CAIXA_BANCO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.financeiro.FinFechamentoCaixaBanco");
	
	
	
	public static final String  CNAE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Cnae");
	public static final String  EMPRESA_CNAE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaCnae");
	public static final String  EMPRESA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Empresa");
	public static final String  EMPRESA_CONTATO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaContato");
	public static final String  EMPRESA_ENDERECO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaEndereco");
	public static final String  EMPRESA_PESSOA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaPessoa");
	public static final String  EMPRESA_PRODUTO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaProduto");
	public static final String  EMPRESA_TELEFONE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaTelefone");
	public static final String  EMPRESA_TRANSPORTE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaTransporte");
	public static final String  EMPRESA_TRANSPORTE_ITINERARIO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.EmpresaTransporteItinerario");
	public static final String  FPAS=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Fpas");
	
	public static final String  PLANO_CONTA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.PlanoConta");
	public static final String  CONTABIL_CONTA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.ContabilConta");
	public static final String  CONTADOR=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Contador");
	public static final String  SINDICATO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Sindicato");
	public static final String  CONVENIO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.empresa.Convenio");
	
	public static final String  ORCAMENTO_DETALHE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoDetalhe");
	public static final String  ORCAMENTO_EMPRESARIAL=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoEmpresarial");
	public static final String  ORCAMENTO_FLUXO_CAIXA=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoFluxoCaixa");
	public static final String  ORCAMENTO_FLUXO_CAIXA_DETALHE=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoFluxoCaixaDetalhe");
	public static final String  ORCAMENTO_FLUXO_CAIXA_PERIODO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoFluxoCaixaPeriodo");
	public static final String  ORCAMENTO_PERIODO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.orcamento.OrcamentoPeriodo");
	 
	public static final String  PLANO_CENTRO_RESULTADO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.contabilidade.PlanoCentroResultado");
	 
	public static final String  CENTRO_RESULTADO=MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.contabilidade.CentroResultado");
	
	public static final String ADM_PARAMETRO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.administrativo.AdmParametro");
	
	 
	public static final String COMPRA_COTACAO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraCotacao");
	public static final String COMPRA_COTACAO_DETALHE = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraCotacaoDetalhe");
	public static final String COMPRA_COTACAO_PEDIDO_DETALHE = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraCotacaoPedidoDetalhe");
	public static final String COMPRA_FORNECEDOR_COTACAO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraFornecedorCotacao");
	public static final String COMPRA_PEDIDO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraPedido");
	public static final String COMPRA_PEDIDO_DETALHE = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraPedidoDetalhe");
	public static final String COMPRA_REQ_COTACAO_DETALHE = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraReqCotacaoDetalhe");
	public static final String COMPRA_REQUISICAO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraRequisicao");
	public static final String COMPRA_REQUISICAO_DETALHE = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraRequisicaoDetalhe");
	public static final String COMPRA_TIPO_PEDIDO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompraTipoPedido");
	public static final String COMPRA_TIPO_REQUISICAO = MensagemUtil.obterMensagemClasses("br.com.hntecnologia.negocio.compras.CompratipoRequisicao");
	
}
