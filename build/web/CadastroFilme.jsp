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
        <h1>Cadastro de Filmes</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
       
        <form action="CadastrarUsuario" method="post">
            <label>Titulo:</label><br> 
            <input type="text" name="txtTitulo" value="${usuario.login}"><br><br>
            <label>Genero:</label><br> 
            <select name="Genero">
                <option>Ação</option>
                <option>Suspense</option>
                <option>Romance</option>
            </select><br><br>
            <label>Sinopse:</label><br> 
            <textarea name="Sinopse" rows="5" cols="25" readonly="readonly">
            </textarea><br><br> 
            <label>Diretor:</label><br> 
            <input type="text" name="txtDiretor"><br><br>
            <label>Ano de Lançamento:</label><br> 
            <input type="number" name="txtLancamento" min="1895"><br><br>
            <label>Status:</label> <br>
            <input type="text" name="txtStatus"><br><br>
            
            
            
            <input type="submit" value="Salvar">            
        </form>
    </body>
</html>