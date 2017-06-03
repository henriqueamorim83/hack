package br.com.hntecnologia.infra.run.nfe;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
/*
import com.chronos.nfe.Nfe;
import com.chronos.nfe.TetesNfe;
import com.chronos.nfe.bo.EnviarNfe;
import com.chronos.nfe.bo.StatusServico;
import com.chronos.nfe.infra.Certificado;
import com.chronos.nfe.infra.RespostaSefaz;
import com.chronos.util.NFeUtil;*/

 

 

public class Nfe2 {
	  /*private static String senhaCertificado;
	    private static Certificado certificado;
	    private static String status;
	public static void main(String[] args) throws Exception {  
		 setCertificado(new Certificado());
	        try {
	            getCertificado().setArquivo(NFeUtil.getBytesFromFile(new File("/home/henrique/google/ripe cafe/9641147.pfx")));
	            getCertificado().setSenha("1234".toCharArray());
	        }
	        catch (Exception ex) {
	            Logger.getLogger(TetesNfe.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
		consultaStatus();
		//  enviarNFe();
		 
		 
	}
	
	 public static void consultaStatus() {
	        if (getCertificado() == null || getCertificado().getArquivo() == null || getCertificado().getSenha() == null) {
	            JOptionPane.showMessageDialog(null, "\u00e8 Necess\u00e1rio informar os dados do certificado antes de consultar o status!");
	        } else {
	            try {
	                Nfe nfe = new Nfe(getCertificado());
	                setStatus(nfe.statusServico("26", "2"));
	                JOptionPane.showMessageDialog(null, getStatus());
	            }
	            catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	public static Certificado getCertificado() {
		return certificado;
	}

	public static void setCertificado(Certificado certificado) {
		Nfe2.certificado = certificado;
	}

	public static String getSenhaCertificado() {
		return senhaCertificado;
	}

	public static void setSenhaCertificado(String senhaCertificado) {
		Nfe2.senhaCertificado = senhaCertificado;
	}

	public static String getStatus() {
		return status;
	}

	public static void setStatus(String status) {
		Nfe2.status = status;
	}
	
	 public static void enviarNFe() {
	        if (getCertificado() == null || getCertificado().getArquivo() == null || getCertificado().getSenha() == null) {
	            JOptionPane.showMessageDialog(null, "\u00e8 Necess\u00e1rio informar os dados do certificado antes de consultar o status!");
	        } else {
	            try {
	                String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\"><idLote>1</idLote><indSinc>0</indSinc><NFe><infNFe Id=\"NFe28160513382635000142550010000000111000000110\" versao=\"3.10\"><ide><cUF>28</cUF><cNF>00000011</cNF><natOp>VENDA</natOp><indPag>0</indPag><mod>55</mod><serie>1</serie><nNF>11</nNF><dhEmi>2016-05-19T16:24:14-03:00</dhEmi><dhSaiEnt>2016-05-19T16:24:14-03:00</dhSaiEnt><tpNF>1</tpNF><idDest>1</idDest><cMunFG>2802908</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>0</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres><procEmi>0</procEmi><verProc>100</verProc></ide><emit><CNPJ>13382635000142</CNPJ><xNome>EMPRESA MATRIZ PARA TESTES</xNome><xFant>EMPRESA PARA TESTES</xFant><enderEmit><xLgr>LOGRADOURO EMPRESA</xLgr><nro>1</nro><xCpl>COMPLEMENTO</xCpl><xBairro>BAIRRO</xBairro><cMun>2802908</cMun><xMun>CIDADE</xMun><UF>DF</UF><CEP>70000000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais></enderEmit><IE>974947245</IE><CRT>2</CRT></emit><dest><CPF>96229175851</CPF><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><enderDest><xLgr>rua teste</xLgr><nro>1310</nro><xBairro>centro</xBairro><cMun>2802908</cMun><xMun>ITABAIANA</xMun><UF>SE</UF><CEP>49500000</CEP><cPais>1058</cPais><xPais>Brazil</xPais></enderDest><indIEDest>2</indIEDest></dest><det nItem=\"1\"><prod><cProd>1313131313178</cProd><cEAN>1313131313178</cEAN><xProd>PRODUTO 1</xProd><NCM>82121020</NCM><CFOP>5101</CFOP><uCom>KG</uCom><qCom>1.0000</qCom><vUnCom>150.000000</vUnCom><vProd>150.00</vProd><cEANTrib>1313131313178</cEANTrib><uTrib>KG</uTrib><qTrib>1.0000</qTrib><vUnTrib>150.000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>3</modBC><vBC>150.00</vBC><pICMS>17.00</pICMS><vICMS>25.50</vICMS></ICMS00></ICMS><PIS><PISAliq><CST>01</CST><vBC>175.50</vBC><pPIS>0.65</pPIS><vPIS>1.14</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>175.50</vBC><pCOFINS>3.00</pCOFINS><vCOFINS>5.26</vCOFINS></COFINSAliq></COFINS></imposto></det><total><ICMSTot><vBC>150.00</vBC><vICMS>25.50</vICMS><vICMSDeson>0.00</vICMSDeson><vBCST>0.00</vBCST><vST>0.00</vST><vProd>150.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>1.14</vPIS><vCOFINS>5.26</vCOFINS><vOutro>0.00</vOutro><vNF>150.00</vNF></ICMSTot></total><transp><modFrete>0</modFrete></transp><infAdic/></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe28160513382635000142550010000000111000000110\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>rMBCO21pDlK0SAsYyRvYx7eUmVw=</DigestValue></Reference></SignedInfo><SignatureValue>jNUWUmj+NPIwSQ3zS7gjHul6w6AxRyal2PLPjoL8Oh1zGzu/LJG/kbmriC7pI9OrtRsdWodEod54WcmJ0zafmj41aOwk9N/QEdMKWUW/KIeeWr6zsqL4U8nCat1XTPIf+WMVZNDUYrQsLeV9wdZNhLXmcZsBC+1ZitWJcEs47qI7os9AZHC25bqrQhkiqGWBi/S6ln9u3q5avW/9atvqqAicUw0ZV5MEP+4uXboPjI7PJChlM7rq3UAxkspH6SWstZzQLVeDRGbHy7KIP6Ipz7TG+3LJRNmcjGtABf7Q0skRM5FGt72AHsN/f4fj620hl1CuoAGJTwqzedyYRCqV1Q==</SignatureValue><KeyInfo><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>";
	                KeyStore ks = KeyStore.getInstance("PKCS12");
	                ks.load(new ByteArrayInputStream(getCertificado().getArquivo()), getCertificado().getSenha());
	                String alias = ks.aliases().nextElement();
	                EnviarNfe enviarNfe = new EnviarNfe();
	                RespostaSefaz resposta = new RespostaSefaz();
	                Map mapResposta = enviarNfe.enviaNfe(xml, alias, ks, getCertificado().getSenha(), "26", "2");
	                Boolean autorizado = (Boolean)mapResposta.get("autorizado");
	                RespostaSefaz respostaSefaz = new RespostaSefaz();
	                respostaSefaz.setAutorizado(autorizado);
	                respostaSefaz.setResposta((String)mapResposta.get("resposta"));
	                respostaSefaz.setNumeroRecibo((String)mapResposta.get("numeroRecibo"));
	                respostaSefaz.setXmlEnviNfe((String)mapResposta.get("xmlEnviNfe"));
	                status = resposta.getResposta();
	                JOptionPane.showMessageDialog(null, status);
	            }
	            catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }*/
}
