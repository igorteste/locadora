/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import persistencia.UsuarioDAO;
import utilidades.PersonalizarMsgErro;


/**
 *
 * @author sala304b
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msgErro = "";
        String nome = request.getParameter("txtNome");
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String perfil = request.getParameter("Perfil");
        String status = request.getParameter("Status");
        if(nome != null && senha !=null){
            
        String senhaCriptografada = DigestUtils.sha512Hex(senha);
        Usuario usuario = new Usuario();
        if(nome.equals("")){
           msgErro = "Nome de usuario não pode ser vazio!!! ";
        }else if(login.contains(" ")){
           msgErro = "Não é permitido espaços no campo login!!! ";     
        }else if(senha.contains(" ")){
           msgErro = "Não é permitido espaços no campo senha!!! ";  
        }else if(senha.equals(nome)  || (senha.equals(login))){
           msgErro = "O campo senha não pode ser igual ao login nem igual ao nome!!! ";
        }else{   
        
         usuario.setNome(nome);
         usuario.setLogin(login);
         usuario.setSenha(senhaCriptografada);
         usuario.setPerfil(perfil);
         usuario.setStatus(status);
         
         
         
            try {
            UsuarioDAO u = new UsuarioDAO();  
            u.inserirUsuario(usuario);
            } catch (Exception ex) {
                request.setAttribute("msgErro", "Occoreu um erro ao salvar o usuário!!!! " + PersonalizarMsgErro.getMensagem(ex.getMessage()));
                
                request.setAttribute("usuario", usuario);
                
                RequestDispatcher rd = request.getRequestDispatcher("CadastroUsuario.jsp");
                rd.forward(request, response);
               //throw new ServletException(ex);
            }
        

               
                // Redireciona para uma pagina logada
               // response.sendRedirect("PainelUsuario.jsp");
                
                return;
             
               }   
            
            }
            
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AutenticarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Autenticação</h1>");
            out.println("<hr>");
            out.println("<a href=\"javascript:history.back()\">Voltar</a><br>");
            out.println("<h3>"+ msgErro + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
}
