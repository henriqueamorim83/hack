package br.com.hntecnologia.view.service.webservice;
 



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
 

/**
 * A web service implementation of an endpoint interface.
 * @author www.codejava.net
 *
 */
 
@WebService(endpointInterface = "br.com.hntecnologia.view.service.webservice.FileTransferer")
public class FileTransfererImpl    implements FileTransferer  {

	@Override
	public void salvar(String texto) {
		// TODO Auto-generated method stub
		System.out.println(texto);
	}

	 
	 
 

	 
 

	

	
	
}