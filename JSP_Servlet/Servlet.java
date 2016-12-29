<#if package?? && package != "">
package ${package};
</#if>

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
<#if classAnnotation??>
import javax.servlet.annotation.WebServlet;
</#if>
<#if includeInitParams??>
import javax.servlet.annotation.WebInitParam;
</#if>
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @created on ${date}, ${time}
 * @author ${user}
 */
<#if classAnnotation??>
${classAnnotation}
</#if>
public class ${name} extends HttpServlet {

    private static final long serialVersionUID = 1L;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
<#if java17style?? && java17style>
        try (PrintWriter out = response.getWriter()) {
<#else>
        PrintWriter out = response.getWriter();
        try {
</#if>
            out.println("${doctype?j_string}");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ${name}</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ${name} at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
<#if !java17style?? || !java17style>
        } finally {
            out.close();
</#if>
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
