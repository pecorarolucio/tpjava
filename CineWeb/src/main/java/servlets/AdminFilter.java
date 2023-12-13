package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Persona;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter({ "/AdminFilter", "/Admin/*" })
public class AdminFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
		
        HttpSession session = httpRequest.getSession(false);
        
        if (session!=null && session.getAttribute("usuario")!=null) {
        	String userClass = ((Persona) session.getAttribute("usuario")).getTipo();
        	if ("Admin".equals(userClass)) {
        		chain.doFilter(request, response);
        	} else {
        		httpResponse.sendRedirect(httpRequest.getContextPath()+"/Unauthorized.jsp");
        	}
        } else {
        	httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.html");
        }
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
