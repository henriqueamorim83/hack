package br.com.hntecnologia.view;


import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import javax.faces.bean.SessionScoped;  
import javax.servlet.ServletException;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

/** 
* 
* @author Henrique Amorim 
*/  
@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})  
@SessionScoped  
public class DownloadServlet extends HttpServlet {                   
        
  
	private static final long serialVersionUID = 1712918261264190204L;

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      ServletOutputStream ouputStream = null;  

        
      try{                           
            
              HttpSession session = request.getSession(true);   
                      
              response.setContentType("application/octet-stream");   
              response.addHeader("Content-Disposition", "attachment; filename=\"" + session.getAttribute("nomeFile") + "\";");   
              response.setContentType((String) session.getAttribute("formato")); //Tipo do Arquivo   
                       
                                         
              //Recuperando os parÃ¢metros enviados  
              ByteArrayOutputStream file = (ByteArrayOutputStream)session.getAttribute("arquivo");  

              byte bytes[] = null;  
                
              bytes = file.toByteArray();   
              response.setContentLength(bytes.length);                                  
              ouputStream = response.getOutputStream();    
              ouputStream.write(bytes, 0, bytes.length);                              
              ouputStream.flush();  

             
       }catch(Exception e){  
           e.printStackTrace();           
       }finally {  
            
          if (ouputStream != null)  
              ouputStream.close();  
            
       }  
        
  }  

  @Override  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)  
          throws ServletException, IOException {  
      processRequest(request, response);  
  }  

  @Override  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)  
          throws ServletException, IOException {  
      processRequest(request, response);  
  }  
    
  @Override  
  public String getServletInfo() {  
      return "Short description";  
  }// </editor-fold>  

}    