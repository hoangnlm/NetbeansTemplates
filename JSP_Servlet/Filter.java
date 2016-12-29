<#if package?? && package != "">
package ${package};
</#if>

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @created on ${date}, ${time}
 * @author ${user}
 */
<#if classAnnotation??>
${classAnnotation}
</#if>
public class ${name} implements Filter {

    private static final boolean DEBUG = true;

    public ${name}() {
    } 

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
	throws IOException, ServletException {
	if (DEBUG) {
                        Logger.getLogger(TestFilter.class.getName()).log(Level.INFO, "\"${name}:DoBeforeProcessing\"");
                    }

//	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
//	    String name = (String)en.nextElement();
//	    String values[] = request.getParameterValues(name);
//	    int n = values.length;
//	    StringBuffer buf = new StringBuffer();
//	    buf.append(name);
//	    buf.append("=");
//	    for(int i=0; i < n; i++) {
//	        buf.append(values[i]);
//	        if (i < n-1)
//	            buf.append(",");
//	    }
//                        Logger.getLogger(TestFilter.class.getName()).log(Level.INFO, buf.toString());
//	}
    } 

    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
	if (DEBUG) {
                        Logger.getLogger(TestFilter.class.getName()).log(Level.INFO, "\"${name}:DoAfterProcessing\"");
                    }

//	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements();) {
//	    String name = (String)en.nextElement();
//	    Object value = request.getAttribute(name);
//	    Logger.getLogger(TestFilter.class.getName()).log(Level.INFO, "attribute: " + name + "=" + value.toString());
//	}
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	if (DEBUG) {
                        Logger.getLogger(TestFilter.class.getName()).log(Level.INFO, "${name}:doFilter()");
                    }

	doBeforeProcessing(request, response);
                    chain.doFilter(request, response);
	doAfterProcessing(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
