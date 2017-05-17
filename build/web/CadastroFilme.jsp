<%-- 
    Document   : CadastroUsuario2
    Created on : 12/05/2017, 08:26:32
    Author     : sala308b
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="persistencia.GeneroDAO" id="dao"/>       
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
       
        <form action="CadastrarFilmes" method="post">
            <label>Titulo:</label><br> 
            <input type="text" name="txtTitulo" minlength="3"><br><br>
            <label>Genero:</label><br> 
            <select name="Genero">
            <c:forEach items="${dao.listar()}" var="genero">
            <option value="${genero.codigo}">${genero.nome}</option>
            </c:forEach>
            </select><br><br>
            <label>Sinopse:</label><br> 
            <textarea name="txtSinopse" rows="5" cols="25">
            </textarea><br><br> 
            <label>Diretor:</label><br> 
            <input type="text" name="txtDiretor" minlength="5"><br><br>
            <label>Ano de Lançamento:</label><br> 
            <input type="number" name="txtLancamento" min="1895"><br><br>
            <label>Status:</label><br>
            <input type="radio" name="status" value="Ativo" checked="checked" />
            <label>Ativo</label><br>
            
            <input type="radio" name="status" value="Inativo"/>
            <label>Inativo</label><br><br>
            
            <input type="submit" value="Salvar">            
        </form>
    </body>
</html>