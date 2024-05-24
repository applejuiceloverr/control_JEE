package ma.formations.jpa.tp8_jpa.presentation.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "*.do")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String loginURI = httpRequest.getContextPath() + "/login.do";
        String registerURI = httpRequest.getContextPath() + "/register.do";

        boolean loggedIn = httpRequest.getSession().getAttribute("username") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);

        if (loggedIn || loginRequest || registerRequest) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
    }
}
