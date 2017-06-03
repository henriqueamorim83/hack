package br.com.hntecnologia.infra.run.nfe;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.Security;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;  
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;

;  
public class NFe3 {
	
	public static void main(String[] args)  {
		/*String caminhoCertificado = "/home/henrique/programa/certificado/9641147.pfx";  
        String senhaCertificado = "1234";  
        String caminhoCacertsEstados = "/home/henrique/programa/certificado/NFeCacertss";  
        String codigoDoEstado = "26";  
        URL url = null;
		try {
			url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
          
        System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");  
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
        System.setProperty("javax.net.ssl.keyStore", caminhoCertificado);  
        System.setProperty("javax.net.ssl.keyStorePassword", senhaCertificado);  
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
        System.setProperty("javax.net.ssl.trustStore", caminhoCacertsEstados);  
          
    
            StringBuilder xml = new StringBuilder();    
           xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");    
           xml.append("<consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\">");    
           xml.append("<tpAmb>2</tpAmb>"); //1 = produção, 2 = homologação    
           xml.append("<cUF>26</cUF>");   
          // xml.append("<CNPJ>23504607000104</CNPJ>");
           xml.append("<xServ>STATUS</xServ>");    
           xml.append("</consStatServ>");    
           
           OMElement ome = null;
		try {
			ome = AXIOMUtil.stringToOM(xml.toString());
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
           NfeStatusServico2Stub.NfeDadosMsg dadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();    
           dadosMsg.setExtraElement(ome);    
    
           NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();    
           nfeCabecMsg.setCUF("26");    
           nfeCabecMsg.setVersaoDados("3.10");    
    
           NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();    
           nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);    
    
           NfeStatusServico2Stub stub = null;
		try {
			stub = new NfeStatusServico2Stub(url.toString());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
           NfeStatusServico2CallbackHandler.NfeStatusServicoNF2Result result = null;
		try {
			result = stub.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
    
           System.out.println(result.getExtraElement().toString()); */  
	}
	
	 
}
