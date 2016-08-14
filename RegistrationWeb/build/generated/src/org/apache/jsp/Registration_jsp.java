package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Registration Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Please register a user.</h1>\n");
      out.write("        <form name=\"register\" action=\"Control\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"origin\" value=\"Registration\"/>\n");
      out.write("            <label>Name: </label><br>\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"\" /><br>\n");
      out.write("            <label>Id: </label><br>\n");
      out.write("            <input type=\"text\" name=\"id\" value=\"\" /><br>\n");
      out.write("            <label>Password: </label><br>\n");
      out.write("            <input type=\"password\" name=\"pwd\" value=\"\" /><br>\n");
      out.write("            <label>Age: </label><br>\n");
      out.write("            <input type=\"text\" name=\"age\" value=\"\" /><br>\n");
      out.write("            <label>Gender: </label><br>\n");
      out.write("            <select name=\"gender\">\n");
      out.write("                <option>Male</option>\n");
      out.write("                <option>Female</option>\n");
      out.write("            </select><br>\n");
      out.write("            <label>Country: </label><br>    \n");
      out.write("            <select name=\"country\">\n");
      out.write("                <option>Danmark</option>\n");
      out.write("                <option>Tyskland</option>\n");
      out.write("                <option>England</option>\n");
      out.write("                <option>Sverige</option>\n");
      out.write("                <option>Norge</option>\n");
      out.write("            </select><br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"Submit\" /><br>\n");
      out.write("            <a href=\"Control?origin=ListUsers\">List all users</a><br>\n");
      out.write("            <a href=\"Control?origin=ShowUsers\">Show all users</a>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
