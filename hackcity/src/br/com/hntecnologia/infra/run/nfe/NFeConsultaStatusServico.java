package br.com.hntecnologia.infra.run.nfe;


 
import java.net.URL;  
import java.security.Security;  
import org.apache.axiom.om.OMElement;  
import org.apache.axiom.om.util.AXIOMUtil;
  
  
/** 
* 
* @author JavaC - Java Community 
*/  
public class NFeConsultaStatusServico {  
  
    public static void main(String[] args) {  
       /* try {  
            /** 
             * 1) codigoDoEstado = Código do Estado conforme tabela IBGE. 
             * 
             * 2) url = Endereço do WebService para cada Estado. 
             *       Ver relação dos endereços em: 
             *       Para Homologação: http://hom.nfe.fazenda.gov.br/PORTAL/WebServices.aspx 
             *       Para Produção: http://www.nfe.fazenda.gov.br/portal/WebServices.aspx 
             * 
             * 3) caminhoDoCertificadoDoCliente = Caminho do Certificado do Cliente (A1). 
             * 
             * 4) senhaDoCertificadoDoCliente = Senha do Certificado A1 do Cliente. 
             * 
             * 5) arquivoCacertsGeradoParaCadaEstado = Arquivo com os Certificados necessarios para 
             * acessar o WebService. Pode ser gerado com a Classe NFeBuildCacerts. 
             */  
            /*String codigoDoEstado = "26";  
            URL url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx");  
            String caminhoDoCertificadoDoCliente = "/home/henrique/programa/certificado/9641147.pfx";  
            String senhaDoCertificadoDoCliente = "1234";  
            String arquivoCacertsGeradoParaCadaEstado = "/home/henrique/programa/certificado/NFeCacertss";  
  
            /** 
             * Informações do Certificado Digital. 
             */  
            /*System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
  
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
  
            System.clearProperty("javax.net.ssl.keyStore");  
            System.clearProperty("javax.net.ssl.keyStorePassword");  
            System.clearProperty("javax.net.ssl.trustStore");  
  
            System.setProperty("javax.net.ssl.keyStore", caminhoDoCertificadoDoCliente);  
            System.setProperty("javax.net.ssl.keyStorePassword", senhaDoCertificadoDoCliente);  
  
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
            System.setProperty("javax.net.ssl.trustStore", arquivoCacertsGeradoParaCadaEstado);  
  
            /** 
             * Xml de Consulta. 
             */  
            /*StringBuilder xml = new StringBuilder();  
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")  
                .append("<consStatServ versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")  
                .append("<tpAmb>2</tpAmb>")  
                .append("<cUF>")  
                .append(codigoDoEstado)  
                .append("</cUF>")  
                .append("<xServ>STATUS</xServ>")  
                .append("</consStatServ>");  
  
            OMElement ome = AXIOMUtil.stringToOM(xml.toString());  
            NfeStatusServico2Stub.NfeDadosMsg dadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();  
            dadosMsg.setExtraElement(ome);  
  
            NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();  
            /** 
             * Código do Estado. 
             */  
           /* nfeCabecMsg.setCUF(codigoDoEstado);  
  
            /** 
             * Versao do XML 
             */  
         /*   nfeCabecMsg.setVersaoDados("3.10");  
            NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();  
            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);  
  
            NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url.toString());  
            NfeStatusServico2Stub.NfeStatusServicoNF2Result result = stub.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);  
  
            System.out.println(result.getExtraElement().toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  */
    }  
  
}  
