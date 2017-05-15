<%-- 
    Document   : CadastroUsuario2
    Created on : 12/05/2017, 08:26:32
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
        <h1>Cadastro de Genero</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
       
        <form action="CadastrarGenero" method="post">
            <label>Nome do Genero:</label><br> 
            <input type="text" name="txtGenero" size="30" minlength="4"><br><br>
            <label>Descrição:</label><br> 
            <input type="text" name="txtDescricao" size="30"><br><br>
                 
            <input type="submit" value="Salvar">            
        </form>
    </body>
</html>