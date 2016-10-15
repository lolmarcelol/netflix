<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : ListaVideos
    Created on : 15/10/2016, 10:37:03
    Author     : Usuario
--%>
<%@page import="model.Video"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Lista de Videos Disponiveis </h1>
        
        <c:forEach var="video"
                   items="${videos}">
            <div>
                <h2> ${video.titulo} </h2>
                <a href = "video_detalhe/?id =${video.id}">
                <img src="Imagens/${video.titulo}.jpg" 
                     alt ="/WEB-INF/jsp/detalhe.jsp" />
                </a>
            </div>
        </c:forEach>    
       
      
    </body>
</html>
