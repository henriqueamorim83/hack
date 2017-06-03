package br.com.hntecnologia.view;

import java.io.File;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

import br.com.hntecnologia.infra.util.Util;

public class ImagemView {

	
	
	private String currentImageName;
	private CroppedImage croppedImage;
	private String newImageName;
	private String imagem;
	
	
	public String getCurrentImageName() {
		return currentImageName;
	}
	public void setCurrentImageName(String currentImageName) {
		this.currentImageName = currentImageName;
	}
	public CroppedImage getCroppedImage() {
		return croppedImage;
	}
	public void setCroppedImage(CroppedImage croppedImage) {
		this.croppedImage = croppedImage;
	}
	public String getNewImageName() {
		return newImageName;
	}
	public void setNewImageName(String newImageName) {
		this.newImageName = newImageName;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
public void fileUploadListener(FileUploadEvent event) throws IOException{		
		
		Util.salvarArquivos(event.getFile().getContents(),event.getFile().getFileName());
		setCurrentImageName(event.getFile().getFileName());
       
	}



public void crop() {
    if(getCroppedImage() == null) {
        return;
    }
     
    setNewImageName(Util.getRandomImageName() +".jpg");
    setImagem(getNewImageName());   
    String newFileName =getContext() + File.separator + "resources" + File.separator + "images" + File.separator + getNewImageName();
    Util.salvarArquivos(new File(newFileName), getCroppedImage().getBytes(), getCroppedImage().getBytes().length);
     
}
public String getContext(){
	 ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	 
	 
	return servletContext.getRealPath("");
}

}
