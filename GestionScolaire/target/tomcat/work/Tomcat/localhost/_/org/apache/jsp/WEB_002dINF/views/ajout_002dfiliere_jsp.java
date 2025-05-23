/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2025-05-08 15:24:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sn.isep.dbe.model.Filiere;
import java.util.ArrayList;

public final class ajout_002dfiliere_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/styles.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("    <h1>Système de gestion scolaire</h1>\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"/accueil\">Accueil</a></li>\r\n");
      out.write("            <li><a href=\"\">Etudiants</a></li>\r\n");
      out.write("            <li><a href=\"\">Cours</a></li>\r\n");
      out.write("            <li><a href=\"\" class=\"active\">Filières</a></li>\r\n");
      out.write("            <li><a href=\"\">Notes</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<main>\r\n");
      out.write("    <section class=\"form-container\">\r\n");
      out.write("        <h2>Ajouter une nouvelle filière</h2>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/filieres/ajouter\" method=\"post\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"code\">Code</label>\r\n");
      out.write("                <input type=\"text\" name=\"code\" id=\"code\" placeholder=\"Code\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"nom\">Nom</label>\r\n");
      out.write("                <input type=\"text\" name=\"nom\" id=\"nom\" placeholder=\"Nom\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"nom\">Département</label>\r\n");
      out.write("                <select id=\"departement\" name=\"departement\">\r\n");
      out.write("                    <option value=\"TIC\">TIC</option>\r\n");
      out.write("                    <option value=\"AUTO\">Automobile</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"nomResponsable\">Nom</label>\r\n");
      out.write("                <input type=\"text\" name=\"nomResponsable\" id=\"nomResponsable\" placeholder=\"nomResponsable\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"prenomResponsable\">Prénom</label>\r\n");
      out.write("                <input type=\"text\" name=\"prenomResponsable\" id=\"prenomResponsable\" placeholder=\"prenomResponsable\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"capacite\">Capacité</label>\r\n");
      out.write("                <input type=\"number\" name=\"capacite\" id=\"capacite\" placeholder=\"capacite\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-buttons\">\r\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Ajouter</button>\r\n");
      out.write("                <a class=\"btn btn-secondary\">Annuler</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </section>\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
