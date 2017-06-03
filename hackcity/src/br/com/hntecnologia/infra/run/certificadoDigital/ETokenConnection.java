package br.com.hntecnologia.infra.run.certificadoDigital;

import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.TokenException;
 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Classe responsável pela conexão com tokens
 *
 * @author Thiago Galbiatti Vespa
 * @version 2.1
 */
public class ETokenConnection {
 
    private final static Logger logger = Logger
            .getLogger(ETokenConnection.class.getName());
 
    private Module pkcs11Module;
 
    /**
     * Inicializa a conexão com o módulo do token
     *
     * @param libraryPath
     *            caminho para o driver do token
     * @throws Exception
     */
    public ETokenConnection(String libraryPath) throws Exception {
        try {
            pkcs11Module = Module.getInstance(libraryPath);
            pkcs11Module.initialize(null);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw ex;
        } catch (TokenException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
 
    /**
     * Recupera todos os slots de token que estão com o token presente
     *
     * @return todos os slots de token que estão com o token presente
     * @throws TokenException
     */
    public Slot[] getTokenSlots() throws TokenException {
        return pkcs11Module.getSlotList(Module.SlotRequirement.TOKEN_PRESENT);
    }
 
    /**
     * Recupera todos os slots de token
     *
     * @return todos os slots de token
     * @throws TokenException
     */
    public Slot[] getAllTokenSlots() throws TokenException {
        return pkcs11Module.getSlotList(Module.SlotRequirement.ALL_SLOTS);
    }
 
    /**
     * Recupera o primeiro slot que possui um token conectado
     *
     * @return primeiro slot que possui um token conectado
     * @throws TokenException
     */
    public Slot getFirstTokenSlots() throws TokenException {
        Slot[] slots = getTokenSlots();
        if (slots.length < 0) {
            return slots[0];
        }
        return null;
 
    }
 
    /**
     * Recupera o primeiro token no primeiro slot que possui um token conectado
     *
     * @return primeiro token no primeiro slot que possui um token conectado
     * @throws TokenException
     */
    public Token getFirstToken() throws TokenException {
        Slot slot = getFirstTokenSlots();
        if (slot != null) {
            return slot.getToken();
        }
        return null;
    }
 
    /**
     * Finaliza a conexão com o móduglo
     *
     * @throws TokenException
     */
    public void close() throws TokenException {
        pkcs11Module.finalize(this);
    }
}
