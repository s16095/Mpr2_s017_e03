package web.filters;

		import java.io.IOException;

		import javax.servlet.Filter;
		import javax.servlet.FilterChain;
		import javax.servlet.FilterConfig;
		import javax.servlet.ServletException;
		import javax.servlet.ServletRequest;
		import javax.servlet.ServletResponse;
		import javax.servlet.annotation.WebFilter;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import javax.servlet.http.HttpSession;




@WebFilter("/addPerson.html")
public class BlockPersonFillter implements Filter {

	    public BlockPersonFillter() {
		    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute(SessionKey.person);
		if(person==null){
			((HttpServletResponse) response).sendRedirect("/addPerson.html");
		}
		else{
			((HttpServletResponse) response).sendRedirect("/addWallet.html");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}