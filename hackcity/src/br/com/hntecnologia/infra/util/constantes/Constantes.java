package br.com.hntecnologia.infra.util.constantes;

import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import br.com.hntecnologia.infra.util.PropertiesUtil;

public class Constantes
{
	
	 // Aqui é a referencia para o arquivo  
    // O meu no caso é o messages.properties que está no pacote resources  
    public static String MENSAGENS_PROPERTIES = "br"+System.getProperty("file.separator")+"com"+System.getProperty("file.separator")+"hntecnologia"+System.getProperty("file.separator")+"resources"+System.getProperty("file.separator")+"Mensagens";
    
    public static String CLASSES_PROPERTIES = "br"+System.getProperty("file.separator")+"com"+System.getProperty("file.separator")+"hntecnologia"+System.getProperty("file.separator")+"resources"+System.getProperty("file.separator")+"Classes";
    public static String USUARIO_PROPERTIES = "usuario.properties";
    
    
    public static String LAYOUT_CNAB240_BB_REMESSA = "layout_cnab240_bb_remessa.xml";
    public static String LAYOUT_CNAB240_BB_RETORNO = "layout_cnab240_bb_retorno.xml";
    
    
    //public static final String DIRETORIO_IMAGENS = "/home/hndesen/imagens/";
    		
   public static String PESSOA_FISICA="Fisica";
   public static String PESSOA_JURIDICA="Juridica";
   
   
   
    // Aqui é a declaraçao  
    // Perceba que PropriedadesMd.getInt("mensagem") mensagem é o nome do  
    // que você deu no seu arquivo properties e Mensagem é o o nome o qual   
    // será identificado.  
    public static int Mensagem = PropertiesUtil.getInt("mensagem"); 

    public static final String STRING_VIRGULA_ESPACO = ", ";
    
	public static final Integer INSERIR = 0;
	public static final Integer ATUALIZAR = 1;
	public static final Integer REMOVER = 2;
	public static final Integer CONSULTAR = 3;
    
	public static final Date DATA_ATUAL = new Date();
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";

	public static final Long VERSAO_ATUAL = new Long(0);
	
	public static final Long USUARIO_ADMIN = new Long(1);

	public static final Boolean SITUACAO_ATIVO = true;

	public static final Boolean SITUACAO_EXCLUIDO = false;

	public static final Double ESTOQUE_ZERO = 0.0;

	public static final String FORMATO_VALOR_MONETARIO_BR = "#,##0.00";

	public static final String ISO = "BR";

	public static Locale LOCALE_PADRAO = new Locale("pt" , ISO);

	public static final Integer CONTADOR_INICIAL_CODIGO_PRODUTO=100000;

	public static final int TAMANHO_MAXIMO_UPLOAD_ARQUIVOS = 209715200;

	public static final Integer TAMANHO_ARQUIVO = 5242880;

	public static final String EXTENSAO_ARQUIVOS = "RAR, ZIP, 7ZIP, TAR, PDF, JPEG, JPG, PNG, DOC, DOCX, ODT";
	
	public static final Integer ENTRADA =0;
	public static final Integer SAIDA =1;
	public static final Integer AVARIA =2;
	public static final Integer TRANSFERENCIA =3;
	public static final Integer ACERTO_ESTOQUE =4;
	
	
	public static final Integer TIPO_ESTOCAGEM_PADRAO = 0;
	public static final Integer TIPO_ESTOCAGEM_REFRIGERADO = 1;
	
	public static final String TIPO_PESO_KILOGRAMA = "KG";
	public static final String TIPO_PESO_GRAMA = "GR";

	
	public static final int TIPO_UNIDADE_CAIXA = 1;
	public static final int TIPO_UNIDADE_UND = 0;
	
	public static final Long COZINHA_PADRAO=new Long(1);
	
	public static final Long UNIDADE_PADRAO= new Long(105);
	
	public static final Integer TIPO_DOCUMENTO_CNPJ =0;
	
	public static final Integer TIPO_DOCUMENTO_CPF =1;
	
	
	public static final Long SITUACAO_PEDIDO_EM_COTACAO = (long) 1;
	public static final Long SITUACAO_PEDIDO_COTADO =(long)2;
	public static final Long SITUACAO_PEDIDO_A_ENTREGAR =(long)3;
	public static final Long SITUACAO_PEDIDO_NA_ENTREGA =(long)4;
	public static final Long SITUACAO_PEDIDO_ENTREGUE =(long)5;
	public static final Long SITUACAO_PEDIDO_CANCELAR =(long)6;
	
	public static String PESSOA_FORNECEDOR="SIM";
	public static String PESSOA_COLABORADOR="SIM";
	public static String PESSOA_TRANSPORTADORA="SIM";
	public static String PESSOA_CLIENTE="SIM";
	
	public static final int EMPRESA_TELEFONE_CELULAR=1;
	public static final int EMPRESA_TELEFONE_OUTRO=2;
	public static final int EMPRESA_TELEFONE_RESIDENCIAL=3;
	public static final int EMPRESA_TELEFONE_COMERCIAL=4;
	
	public static final int EMPRESA_REGIME_SIMPLES_NACIONAL=1;
	public static final int EMPRESA_REGIME_LUCRO_REAL=2;
	public static final int EMPRESA_REGIME_LUCRO_PRESUMIDO=3;
	
	public static final String USUARIO_PERFIL_ADMINISTRADOR="ADMINISTRADOR";
	public static final String USUARIO_PERFIL_OPERADOR="OPERADOR";
	public static final String USUARIO_PERFIL_CLIENTE="CLIENTE";
	public static final String USUARIO_PERFIL_SUPRIMENTOS="SUPRIMENTOS";
	
	public static final String SIM="Sim";
	public static final String NAO="Não";
	
	public static final String COMPRA_ABERTA="Aberta";
	public static final String COMPRA_CONFIRMADA="Confirmada";
	public static final String COMPRA_FECHADA="Fechada";
	
	public static final Long GRUPO_PRODUTOS_SOBRA =  new Long(20);
	
	  public static String UNIDADE_GARRAFAO_LITROS="GF";
	  
	  public static String FORMA_DESCONTO_PRODUTO="Produto";
	  public static String FORMA_DESCONTO_FIM_PEDIDO="Fim do Pedido";
	  
	  public static final int SITUACAO_ESTOQUE_NORMAL = 1;
	  public static final int SITUACAO_ESTOQUE_BAIXO = 2;
	  public static final int SITUACAO_ESTOQUE_ALTO = 3;
	  public static final int SITUACAO_ESTOQUE_VENCIDO = 4;
	  public static final int SITUACAO_ESTOQUE_A_VENCER = 5;
	  
	  public static final long FIN_TIPO_PAGAMENTO_DINHEIRO= 1;
	  public static final long FIN_TIPO_PAGAMENTO_CHEQUE= 2;
	  public static final long FIN_TIPO_PAGAMENTO_CARTAO= 3;
	  
	  public static final long FIN_TIPO_RECEBIMENTO_DINHEIRO= 1;
	  public static final long FIN_TIPO_RECEBIMENTO_CHEQUE= 2;
	  public static final long FIN_TIPO_RECEBIMENTO_CARTAO= 3;
	  
	  public static final long FIN_STATUS_PARCELA_ABERTO=1;
	  public static final long FIN_STATUS_PARCELA_QUITADO=2;
	  public static final long FIN_STATUS_PARCELA_QUITADO_PARCIAL=3;
	  public static final long FIN_STATUS_PARCELA_VENCIDO=4;
	  public static final long FIN_STATUS_PARCELA_MESCLADO=5;
	  
	  
	  public static final int FIN_FORMA_PAGAMENTO_A_VISTA=0;
	  public static final int FIN_FORMA_PAGAMENTO_A_PRAZO=1;
	  public static final int FIN_FORMA_PAGAMENTO_A_OUTROS=2;
	  
	  public static final String FIN_TIPO_FRETE_CIF="C";
	  public static final String FIN_TIPO_FRETE_FOB="F";
	  
	  
	  
	  public static final int NFE_LOCAL_DESTINO_INTERNA=1;
	  public static final int NFE_LOCAL_DESTINO_INTERESTADUAL=2;
	  public static final int NFE_LOCAL_DESTINO_COM_EXTERIOR=3;	  
	  
	  public static final int NFE_CONSUMIDOR_OPERACAO_NORMAL=0;
	  public static final int NFE_CONSUMIDOR_OPERACAO_FINAL=1;
	  
	  public static final int NFE_CONSUMIDOR_OPERACAO_PRESENCIAL=1;
	  public static final int NFE_CONSUMIDOR_OPERACAO_PRESENCIAL_INTERNET=2;
	  public static final int NFE_CONSUMIDOR_OPERACAO_PRESENCIAL_TELEATENDIMENTO=3;
	  public static final int NFE_CONSUMIDOR_OPERACAO_PRESENCIAL_OUTROS=9;
	  public static final int NFE_CONSUMIDOR_OPERACAO_PRESENCIAL_NAO_APLICA=0;
	  
	  public static final int NFE_TIPO_OPERACAO_ENTRADA=0;
	  public static final int NFE_TIPO_OPERACAO_SAIDA=1;
	  
	  public static final int NFE_TIPO_EMISSAO_NORMAL=1;
	  public static final int NFE_TIPO_EMISSAO_DPEC=4;
	  public static final int NFE_TIPO_EMISSAO_SCAN=3;
	  public static final int NFE_TIPO_EMISSAO_FSDA=5;
	  public static final int NFE_TIPO_EMISSAO_CONTIGENCIA=2;
	  
	  public static final int NFE_FINALIDADE_NORMAL=1;
	  public static final int NFE_FINALIDADE_COMPLEMENTAR=2;
	  public static final int NFE_FINALIDADE_AJUSTE=3;
	  
	  public static final int NFE_FORMATO_DANFE_RETRATO=1;
	  public static final int NFE_FORMATO_DANFE_PAISAGEM=2;
	  
	  
	  public static final int NFE_FORMA_PG_A_VISTA=2;
	  public static final int NFE_FORMA_PG_A_PRAZO=2;
	  public static final int NFE_FORMA_PG_OUTROS=2;
	  
	  
	  public static final Long COMPRA_TIPO_REQUISICAO_INTERNA=new Long(1);
	  public static final Long COMPRA_TIPO_REQUISICAO_EXTERNA=new Long(2);
	  
	  public static final Long COMPRA_TIPO_PEDIDO_NORMAL=new Long(1);
	  public static final Long COMPRA_TIPO_PEDIDO_PLANEJADO=new Long(2);
	  
	  
	  
	  public static final int USUARIO_ADMINISTRADOR=1;
	  
	  public static String TIPO_COMPRA_COTACAO_PRODUTOS="Produtos e Insumos";
	  public static String TIPO_COMPRA_COTACAO_RECEITAS="Bolos e Tortas";
	 
	  public static final String DATABASE_MATRIZ="matrizDataSource";
	  public static final String DATABASE_RECIFE="recifeDataSource";
	  public static final String DATABASE_CARUARU="caruaruDataSource";
	  public static final String DATABASE_GARANHUNS="garanhunsDataSource";
	  
	  
	  
	  
	  public static final Long CLIENTE_RIPE_VITORIA=(long) 5001;
	  public static final Long CLIENTE_RIPE_ESPINHEIRO=(long) 5002;
	  public static final Long CLIENTE_RIPE_BRASIL=(long) 5003;
	  
	  public static final Long FORNECEDOR_RIPE_ALIMENTOS=(long) 5017;
	  
	  public static final Long LOCAL_ESTOQUE_RIPE_ALIMENTOS_ESTOQUE=(long) 1;
	  
	  public static final Long LOCAL_ESTOQUE_RIPE_ALIMENTOS_PRODUCAO=(long) 5001;
	  
	  
}
