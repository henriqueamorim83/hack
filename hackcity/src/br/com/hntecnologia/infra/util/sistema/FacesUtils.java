package br.com.hntecnologia.infra.util.sistema;

import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hntecnologia.infra.util.Util;

@Component
public class FacesUtils {

	
	private FacesContext facesContext ;
//aqui eu informo o contexto a ser construido
	
	@Autowired
	public FacesUtils(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public void adicionaMensagemDeErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public void adicionaMensagemDeAlerta(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}

	public void adicionaMensagemDeInformacao(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public void adicionaMensagemDeErro(List<String> mensagens) {
		if(Util.isListNaoNulaNaoVazia(mensagens)){
			for(String mensagem :mensagens){
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				facesContext.addMessage(null, facesMessage);
			}
		}
		
	}
	
	public void adicionaMensagemDeAlerta(List<String> mensagens) {
		if(Util.isListNaoNulaNaoVazia(mensagens)){
			for(String mensagem :mensagens){
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				facesContext.addMessage(null, facesMessage);
			}
		}
		
	}

	public void adicionaMensagemDeInformacao(List<String> mensagens) {
		if(Util.isListNaoNulaNaoVazia(mensagens)){
			for(String mensagem :mensagens){
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				facesContext.addMessage(null, facesMessage);
			}
		}
		
	}
	

	/**
	 * Limpa os dados dos componentes de edição e de seus filhos,
	 * recursivamente. Checa se o componente é instância de
	 * EditableValueHolder e 'reseta' suas propriedades.
	 * <p>
	 * Quando este método, por algum motivo, não funcionar, parta para
	 * ignorância e limpe o componente assim:
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * component.getChildren().clear()
	 * </pre>
	 * 
	 * </blockquote> :-)
	 */
	public void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		if (component.getChildCount() > 0) {
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}

	public void cleanSubmittedValues(String componentName) {
		UIComponent component = facesContext.getViewRoot().findComponent(componentName);
		if (component != null)
			cleanSubmittedValues(component);
	}
	
	 public static final String FILE_DOWNLOAD_TOKEN = "xpert.download";

	    /**
	     * Generates a file to download.
	     *
	     * This method put a cookie named 'fileDownloadToken', this cookie can be
	     * used to control the downloaded file by the "javax.faces.ViewState" (wich
	     * is a param submited in JSF forms)
	     *
	     * @param bytes
	     * @param contentType
	     * @param fileName
	     */
	    public  void download(byte[] bytes, String contentType, String fileName) {
	        download(bytes, contentType, fileName, true);
	    }

	    /**
	     *
	     * Generates a file to download.
	     *
	     * This method put a cookie named 'fileDownloadToken', this cookie can be
	     * used to control the downloaded file by the "javax.faces.ViewState" (wich
	     * is a param submited in JSF forms)
	     *
	     * @param bytes
	     * @param contentType
	     * @param fileName
	     * @param attachment indicates attachment in header
	     */
	    public  void download(byte[] bytes, String contentType, String fileName, boolean attachment) {

	        FacesContext.getCurrentInstance().responseComplete();
	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	        try {
	            addCookie(FILE_DOWNLOAD_TOKEN, request.getParameter("javax.faces.ViewState"));
	            response.setContentType(contentType);
	            if (attachment) {
	                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+"\"");
	            }
	            response.setContentLength(bytes.length);
	            response.getOutputStream().write(bytes);
	        } catch (IOException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

	    /**
	     * Generates a file to download.
	     *
	     * This method put a cookie named 'fileDownloadToken', this cookie can be
	     * used to control the downloaded file by the "javax.faces.ViewState" (wich
	     * is a param submited in JSF forms)
	     *
	     * @param inputStream
	     * @param contentType
	     * @param fileName
	     */
	    public  void download(InputStream inputStream, String contentType, String fileName) {
	        download(inputStreamToByte(inputStream), contentType, fileName);
	    }

	    /**
	     * Generates a file to download.
	     *
	     * This method put a cookie named 'fileDownloadToken', this cookie can be
	     * used to control the downloaded file by the "javax.faces.ViewState" (wich
	     * is a param submited in JSF forms)
	     *
	     * @param inputStream
	     * @param contentType
	     * @param fileName
	     * @param attachment
	     */
	    public  void download(InputStream inputStream, String contentType, String fileName, boolean attachment) {
	        download(inputStream, contentType, fileName, attachment);
	    }

	    private  byte[] inputStreamToByte(InputStream inputStream) {
	        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	        int nRead;
	        byte[] data = new byte[16384];

	        try {
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                buffer.write(data, 0, nRead);
	            }
	            buffer.flush();
	        } catch (IOException ex) {
	            throw new RuntimeException(ex);
	        }
	        return buffer.toByteArray();
	    }
	    /**
	     * Add Cookie no HttpServletResponse
	     *
	     * @param name
	     * @param value
	     */
	    public static void addCookie(String name, String value) {
	        Cookie cookie = new Cookie(name, value);
	        cookie.setPath("/");
	        cookie.setMaxAge(2592000);
	        // NOTE: If cookie version is set to 1, cookie values will be quoted.
	        cookie.setVersion(0);
	        HttpServletResponse response = getResponse();
	        response.addCookie(cookie);
	    }
	    /**
	     * Get the current Http request from JSF "ExternalContext"
	     *
	     * @return HttpServletRequest get from JSF
	     */
	    public static HttpServletRequest getRequest() {
	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        if (externalContext != null) {
	            return (HttpServletRequest) externalContext.getRequest();
	        }
	        return null;
	    }

	    /**
	     * Get the current Http response from JSF "ExternalContext"
	     *
	     * @return HttpServletResponse get from JSF
	     */
	    public static HttpServletResponse getResponse() {
	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	        return response;
	    }
}
