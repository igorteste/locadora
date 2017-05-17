/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Filmes;
import modelo.Generos;
import modelo.Usuario;
import persistencia.FilmesDAO;
import utilidades.PersonalizarMsgErro;


/**
 *
 * @author sala304b
 */
@WebServlet(name = "CadastrarFilmesServlet", urlPatterns = {"/CadastrarFilmes"})
public class CadastrarFilmesServlet extends HttpServlet {

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
        String titulo = request.getParameter("txtTitulo");
        String codGenero = request.getParameter("Genero");
        String sinopse = request.getParameter("txtSinopse");
        String diretor = request.getParameter("txtDiretor");
        String anoLancamento = request.getParameter("txtLancamento");
        String status = request.getParameter("status");

        
        
        Filmes filme = new Filmes();
        if(titulo.equals("")){
           msgErro = "Campo titulo está vazio!!! ";
        }else if(codGenero.equals("")){
           msgErro = "Um filme não pode ser cadastrado sem o genero !!! ";     
        }else if(sinopse.equals("")){
           msgErro = "Campo sinopse está vazio !!! ";  
        }else if(diretor.equals("")){
           msgErro = "Campo diretor está vazio!!! ";   
        }else if(anoLancamento.equals("")){
           msgErro = "Campo lancamento está vazio!!! ";   
        }
        
        filme.setTitulo(titulo);
       
        
        
        Generos genero = new Generos();
        genero.setCodigo(Integer.parseInt(codGenero));
        
        filme.setGenero(genero);
        filme.setSinopse(sinopse);
        filme.setDiretor(diretor);
        filme.setAnoLancamento(Integer.parseInt(anoLancamento));
        filme.setStatus(status);
        filme.setDatahoraCadastro( new Date());
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioAutenticado");
        filme.setUsuarioCadastro(usuario);
                                      
            try {
            FilmesDAO f = new FilmesDAO();  
            f.inserirFilmes(filme);        
              
            response.sendRedirect("PainelControle.jsp");    
            
            return;
            
            } catch (Exception e) {
              msgErro = PersonalizarMsgErro.getMensagem(e.getMessage()); 
                
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
            out.println("<h3>Login ou Senha Incorretos!</h3>");
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
