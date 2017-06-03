package br.com.hntecnologia.infra.run.certificadoDigital;

 

import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;
import iaik.pkcs.pkcs11.objects.Data;
import iaik.pkcs.pkcs11.objects.X509AttributeCertificate;
import iaik.pkcs.pkcs11.objects.X509PublicKeyCertificate;
 
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Manipula dados no token
 *
 * @author Thiago Galbiatti Vespa
 * @version 2.0
 */
public class ETokenDataManager {
    private final static Logger logger = Logger
            .getLogger(ETokenConnection.class.getName());
    private Token token;
    private Session session;
 
    /**
     * Construtor para manipulação de dados no token
     *
     * @param token
     *            token que terá os dados manipulados
     * @throws TokenException
     *             caso o token não esteja conectado
     */
    public ETokenDataManager(Token token) throws TokenException {
        if (token == null) {
            logger.severe("Não há token conectado!");
            throw new TokenException("Token is not connected!");
        }
        this.token = token;
    }
 
    /**
     * Abre uma sessão segura com o token
     *
     * @param userPIN
     *            senha utilizada no token
     * @throws TokenException
     *             em caso de senha inválida ou login inválido
     */
    public void openSession(String userPIN) throws TokenException {
 
        this.session = token.openSession(Token.SessionType.SERIAL_SESSION,
                Token.SessionReadWriteBehavior.RW_SESSION, null, null);
 
        TokenInfo tokenInfo = token.getTokenInfo();
 
        if (tokenInfo.isLoginRequired()) {
            if (tokenInfo.isProtectedAuthenticationPath()) {
                session.login(Session.UserType.USER, null);
            } else {
                session.login(Session.UserType.USER, userPIN.toCharArray());
            }
        }
 
    }
 
    /**
     * Fecha a conexão com o token
     *
     * @throws TokenException
     */
    public void closeSession() throws TokenException {
        session.logout();
        session.closeSession();
        session = null;
    }
 
    /**
     * Realiza a leitura de dados do token
     *
     * @param application
     *            aplicação que gravou os dados
     * @param label
     *            label que identifica os dados
     * @return dados recuperados e nulo caso não encontrado
     * @throws TokenException
     */
    public byte[] readData(String application, String label)
            throws TokenException {
        if (session == null) {
            logger.severe("Sessão fechada!");
            throw new TokenException("Session is closed!");
        }
 
        // cria o template para busca
        Data dataObjectTemplate = new Data();
 
        if (application != null) {
            // se tiver aplicação atribui
            dataObjectTemplate.getApplication().setCharArrayValue(
                    application.toCharArray());
        }
 
        // atribui o label
        dataObjectTemplate.getLabel().setCharArrayValue(label.toCharArray());
 
        logger.info(dataObjectTemplate.toString());
 
        // inicia a busca
        session.findObjectsInit(dataObjectTemplate);
 
        Object[] foundDataObjects = session.findObjects(1);
 
        Data dataObject;
        if (foundDataObjects.length > 0) {
            // Estamos considerando que só terá um objeto para o template
            // definido
            // Pode haver mais que um
            dataObject = (Data) foundDataObjects[0];
            logger.info("Achou um objeto: ");
            logger.info(dataObject.toString());
        } else {
            dataObject = null;
        }
        // Finaliza a busca
        session.findObjectsFinal();
 
        if (dataObject == null || dataObject.getValue() == null) {
            return null;
        }
        byte[] data = dataObject.getValue().getByteArrayValue();
        return data;
    }
 
    /**
     * Realiza a gravação de dados no token
     *
     * @param data
     *            dados a serem gravados
     * @param application
     *            aplicação responsável pela gravação
     * @param label
     *            label para identificação dos dados
     * @param modifiable
     *            verdadeiro se os dados forem modificáveis
     * @param privateData
     *            verdadeiro se os dados forem privados
     * @throws TokenException
     */
    public void writeData(byte[] data, String application, String label,
            Boolean modifiable, Boolean privateData) throws TokenException {
        if (session == null) {
            logger.severe("Sessão fechada!");
            throw new TokenException("Session is closed!");
        }
 
        logger.info("Gravando dados no token...");
 
        // cria o template para inserção
        Data dataObjectTemplate = new Data();
 
        if (application != null) {
            // se tiver aplicação atribui
            dataObjectTemplate.getApplication().setCharArrayValue(
                    application.toCharArray());
        }
 
        // atribui o label
        dataObjectTemplate.getLabel().setCharArrayValue(label.toCharArray());
 
        // atribui o conteúdo
        dataObjectTemplate.getValue().setByteArrayValue(data);
 
        // torna o dado persistente no token
        dataObjectTemplate.getToken().setBooleanValue(Boolean.TRUE);
 
        // atribui se o objeto é modificável ou não
        dataObjectTemplate.getModifiable().setBooleanValue(modifiable);
 
        // atribui se o objeto é privado ou não
        dataObjectTemplate.getPrivate().setBooleanValue(privateData);
 
        // cria o objeto no token
        session.createObject(dataObjectTemplate);
 
        logger.info("Dados gravados!");
 
    }
 
    /**
     * Grava o conteúdo do arquivo no token
     *
     * @param path
     *            caminho da localização do arquivo
     * @param application
     *            aplicação responsável pela gravação
     * @param label
     *            label para identificação dos dados
     * @param modifiable
     *            verdadeiro se os dados forem modificáveis
     * @param privateData
     *            verdadeiro se os dados forem privados
     * @throws IOException
     *             caso o arquivo não exista ou não esteja acessível
     * @throws TokenException
     */
    public void writeFromFile(String path, String application, String label,
            Boolean modifiable, Boolean privateData) throws IOException,
            TokenException {
 
        File file = new File(path);
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] dataArray = new byte[(int) file.length()];
            is.read(dataArray);
            writeData(dataArray, application, label, modifiable, privateData);
        } finally {
            is.close();
        }
    }
 
    /**
     * Lista todos os objetos em um token convertendo para um objeto certificado
     * se for um
     *
     * @return todos os objetos em um token
     * @throws TokenException
     */
    public List<Object> listObjects() throws TokenException {
        List<Object> objectsInToken = new ArrayList<Object>();
 
        session.findObjectsInit(null);
        iaik.pkcs.pkcs11.objects.Object[] objects = session.findObjects(1);
 
        CertificateFactory x509CertificateFactory = null;
        while (objects.length > 0) {
            Object object = objects[0];
 
            if (object instanceof X509PublicKeyCertificate) {
                try {
                    byte[] encodedCertificate = ((X509PublicKeyCertificate) object)
                            .getValue().getByteArrayValue();
                    if (x509CertificateFactory == null) {
                        x509CertificateFactory = CertificateFactory
                                .getInstance("X.509");
                    }
                    Certificate certificate = x509CertificateFactory
                            .generateCertificate(new ByteArrayInputStream(
                                    encodedCertificate));
                    logger.info("Certificado lido");
                    objectsInToken.add(certificate);
                } catch (Exception ex) {
                    logger.log(Level.SEVERE,
                            "Could not decode this X509PublicKeyCertificate",
                            ex);
                }
            } else if (object instanceof X509AttributeCertificate) {
                try {
                    byte[] encodedCertificate = ((X509AttributeCertificate) object)
                            .getValue().getByteArrayValue();
                    if (x509CertificateFactory == null) {
                        x509CertificateFactory = CertificateFactory
                                .getInstance("X.509");
                    }
                    Certificate certificate = x509CertificateFactory
                            .generateCertificate(new ByteArrayInputStream(
                                    encodedCertificate));
                    logger.info("Certificado att lido");
                    objectsInToken.add(certificate);
 
                } catch (Exception ex) {
                    logger.log(Level.SEVERE,
                            "Could not decode this X509AttributeCertificate",
                            ex);
                }
            } else {
                logger.info("Objeto lido");
                objectsInToken.add(object);
            }
            objects = session.findObjects(1);
        }
        session.findObjectsFinal();
        return objectsInToken;
 
    }
}
