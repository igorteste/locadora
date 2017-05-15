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
        <h1>Cadastro de Usuários</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
                
        <form style="background-color: #ffff66" action="CadastrarUsuario" method="post">
            <label>Nome:</label> 
            <input type="text" name="txtNome" size="30"><br><br>
            <label>Login:</label> 
            <input type="text" name="txtLogin" size="30" minlength="5"><br><br>
            <label>Senha:</label> 
            <input type="password" name="txtSenha" maxlength="6"><br><br>
            <label>Perfil:</label> 
            <select name="Perfil">
                <option>Administrador</option>
                <option>Funcionario</option>
            </select><br><br>
            <label>Status:</label><br>
            <input type="radio" name="Status" value="Ativo" checked="checked" />
            <label>Ativo</label><br>
            
            <input type="radio" name="status" value="Inativo"/>
            <label>Inativo</label><br><br>                 
           
            <input type="submit" value="Salvar">            
        </form>
    </body>
</html>