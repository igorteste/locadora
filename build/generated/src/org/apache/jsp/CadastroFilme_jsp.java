package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastroFilme_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cadastro de Filmes</h1>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"javascript:history.back()\">Voltar</a><br><br>\n");
      out.write("       \n");
      out.write("        <form action=\"CadastrarUsuario\" method=\"post\">\n");
      out.write("            <label>Titulo:</label> \n");
      out.write("            <input type=\"text\" name=\"txtTitulo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.login}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br><br>\n");
      out.write("            <label>Genero:</label> \n");
      out.write("            <select name=\"Genero\">\n");
      out.write("                <option>Ação</option>\n");
      out.write("                <option>Suspense</option>\n");
      out.write("                <option>Romance</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            <label>Sinopse:</label> \n");
      out.write("            <textarea name=\"Sinopse\" rows=\"4\" cols=\"20\" readonly=\"readonly\">\n");
      out.write("            </textarea><br><br> \n");
      out.write("            <label>Diretor:</label> \n");
      out.write("            <input type=\"text\" name=\"txtDiretor\"><br><br>\n");
      out.write("            <label>Ano de Lançamento:</label> \n");
      out.write("            <input type=\"text\" name=\"txtLancamento\"><br><br>\n");
      out.write("            <label>Status:</label> \n");
      out.write("            <input type=\"text\" name=\"txtStatus\"><br><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Salvar\">            \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
