package br.com.hntecnologia.infra.util;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import br.com.hntecnologia.infra.util.constantes.Constantes;
  
/** 
*Esta classe obtem as informações contidas no arquivo de configuração do 
*sistema representadas num arquivo "properties". 
*Este arquivo é definido como "constantes.properties" e é responsavel pelas variáveis do 
*sistema, como caminhos de diretórios, drive's de bando de dados 
*  
*  
*/  
  
public class PropertiesUtil {  
  
    private static ResourceBundle _bundle = null;  
  
      
    /** 
     * Obtem o arquivo de configurações no formato de leitura com a classe  
     * ResourceBundle 
     * @return ResourceBundle configurado com o properties "constantes.properties" 
     */  
    private static ResourceBundle getResource() {  
        if (_bundle == null){  
            _bundle = ResourceBundle.getBundle(Constantes.MENSAGENS_PROPERTIES,Locale.getDefault(),PropertiesUtil.class.getClassLoader());  
        }  
        return _bundle;  
    }  
  
      
    /** 
     * Obtém o valor de chave no arquivo properties.  
     * Obs.: Neste arquivo a forma de representação dos dados 
     * é feita como "key=value". 
     * @param key chave com o valor para ser pesquisado no properties 
     * @return string com o valor contido no arquivo 
     */  
    public static String getString(String key) {  
        try {  
            return getResource().getString(key);  
        } catch (Exception e) {  
            System.err.print(e.getMessage());  
            //SegurancaLog.registrarError(new PropriedadesMd() ,e.getMessage());  
        }  
        return null;  
    }  
  
    /** 
     * Obtém o valor de chave no arquivo properties. Com uma função definida, 
     * o retorno da valor é formatado com um StringTokenizer, separando este 
     * valor um um array de String's pelo token ",". 
     *  
     * Com este exemplo definido no properties de um value assim: 
     * Exemplo: key=value, value2, value3 
     * O retorno será de um array: 
     * {"value", "value2", "value3"} 
     *  
     * Obs.: Neste arquivo a forma de representação dos dados 
     * é feita como "key=value". 
     * @param key chave com o valor para ser pesquisado no properties 
     * @return string com o valor contido no arquivo 
     */  
    public static String[] getStringArray(String key) {  
        String[] retorno = null;  
        try {  
            String array = getResource().getString(key);  
            StringTokenizer st = new StringTokenizer(array, ",");  
            int tokens = st.countTokens();  
            retorno = new String[tokens];  
  
            for (int i = 0; i < tokens; i++) {  
                retorno[i] = st.nextToken();  
            }  
              
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
            //SegurancaLog.registrarError(new PropriedadesMd() ,e.getMessage());  
            retorno =  null;  
        }  
        return retorno;  
    }  
  
    /** 
     * Obtém o valor de chave no arquivo properties no formato de um integer.  
     * Obs.: Neste arquivo a forma de representação dos dados 
     * é feita como "key=value". 
     * @param key chave com o valor para ser pesquisado no properties 
     * @return int com o valor contido no arquivo e convertido para integer 
     */  
    public static int getInt(String key) {  
        try {  
            return new Integer(getResource().getString(key)).intValue();  
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
            //SegurancaLog.registrarError(new PropriedadesMd() ,e.getMessage());  
        }  
        return 0;  
    }  
  
    /** 
     * Obtém o valor de chave no arquivo properties no formato booleano.  
     * Obs.: Neste arquivo a forma de representação dos dados 
     * é feita como "key=value". 
     * @param key chave com o valor para ser pesquisado no properties 
     * @return boolean com o valor contido no arquivo e convertido para boolean, 
     *  "true" ou "false" 
     */  
    public boolean getBoolean(String key) {  
        try {  
            return new Boolean(getResource().getString(key)).booleanValue();  
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
            //SegurancaLog.registrarError(new PropriedadesMd() ,e.getMessage());  
        }  
        return false;  
    }  
  
} 