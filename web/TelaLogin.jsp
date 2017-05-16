<%-- 
    Document   : PainelDeLogin
    Created on : 16/05/2017, 09:55:44
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Locadora - Loster</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
        <form action="Autenticar" method="post">
            Login: <input type="text" name="txtLogin"><br>
            Senha: <input type="password" name="txtSenha"><br><br>
            <input type="submit" value="Logar">            
        </form>
    
    
    </body>
</html>
