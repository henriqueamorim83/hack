<%@page import="br.com.hntecnologia.view.controleAcesso.LoginBean"%>
<%@page import="br.com.hntecnologia.view.EntidadeViewMB"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%  
LoginBean.sairSistema();
response.sendRedirect("auth/login.jsf");%>