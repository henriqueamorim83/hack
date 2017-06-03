package br.com.hntecnologia.infra.run.nfe;
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.URL;  
import java.security.KeyStore;  
import java.security.PrivateKey;  
import java.security.cert.X509Certificate;  
import java.util.Enumeration;  
  
import org.apache.axiom.om.OMElement;  
import org.apache.axiom.om.util.AXIOMUtil;  
import org.apache.commons.httpclient.protocol.Protocol;


 
public class NfeStatusService {

	private static final int SSL_PORT = 443;  
	  
  /*  public static void main(String[] args) {  
        try {  
              
        	 URL url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx");
        	//funciona  // URL url = new URL("https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx");  
        	 
            String caminhoDoCertificadoDoCliente = "/home/henrique/programa/certificado/9641147.pfx";  
            String senhaDoCertificado = "1234";  
            String arquivoCacertsGeradoTodosOsEstados = "/home/henrique/programa/certificado/NFeCacertss";  
  
            InputStream entrada = new FileInputStream(caminhoDoCertificadoDoCliente);  
            KeyStore ks = KeyStore.getInstance("pkcs12");  
            try {  
                ks.load(entrada, senhaDoCertificado.toCharArray());  
            } catch (IOException e) {  
                throw new Exception(  
                        "Senha do Certificado Digital esta incorreta ou Certificado inválido.");  
            }  
  
            String alias = "";  
            Enumeration<String> aliasesEnum = ks.aliases();  
            while (aliasesEnum.hasMoreElements()) {  
                alias = (String) aliasesEnum.nextElement();  
                if (ks.isKeyEntry(alias))  
                    break;  
            }  
            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);  
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias,senhaDoCertificado.toCharArray());  
            SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);  
            socketFactoryDinamico.setFileCacerts(arquivoCacertsGeradoTodosOsEstados);  
  
            Protocol protocol = new Protocol("https", socketFactoryDinamico,SSL_PORT);  
            Protocol.registerProtocol("https", protocol);  
  
            String dados = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"  
                    + "<distDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.00\">"  
                    + "<tpAmb>2</tpAmb>"   
                    + "<cUFAutor>26</cUFAutor>"  
                   // + "<CNPJ>23504607000104</CNPJ>"   
                   // + "<distNSU>"  
                   // + "<ultNSU>000000000000000</ultNSU>"   
                  //  + "</distNSU>"   
                    + "</distDFeInt>";  
  
            NfeDistDFeInteresseResponse result = new NfeDistDFeInteresseResponse();  
            OMElement ome = AXIOMUtil.stringToOM(dados.trim());  
            NfeDadosMsg_type0 dadosMsg = new NfeDadosMsg_type0();  
            dadosMsg.setExtraElement(ome);  
            NfeDistDFeInteresse distDFeInteresse = new NfeDistDFeInteresse();  
            distDFeInteresse.setNfeDadosMsg(dadosMsg);  
            NFeDistribuicaoDFeStub stub = new NFeDistribuicaoDFeStub(url.toString());  
            result = stub.nfeDistDFeInteresse(distDFeInteresse);  
            System.out.println(result);  
            System.out.println(result.getNfeDistDFeInteresseResult()  
                    .getExtraElement().toString());  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
          
    } */ 
}
