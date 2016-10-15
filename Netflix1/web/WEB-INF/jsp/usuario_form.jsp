<%-- 
    Document   : VideoForm
    Created on : 15/10/2016, 09:13:07
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Cliente</h1>
        <form action="cadastro" method="POST">
            <!--ADICIONAR COM JQUERY OBRIGATORIEDADE E MASCARA PARA CPF-->           
            <label for="nome">Nome:</label> 
            <input type="text" name="nome" id="nome"> 
            
            <label for="cpf">CPF:</label> 
            <input type="text" name="cpf" id="cpf"> 
            
            <label for="dataNascimento">Data Nascimento:</label> 
            <input type="date" name="dataNascimento" id="dataNascimento"> 
            
            <label for="login">Login:</label> 
            <input type="text" name="Login" id="login"> 
            
            <label for="password">Senha: </label>
            <input type="password" name="password" id="password">
            
            <input type="Submit" value="Salvar">
        </form>
    </body>
</html>
