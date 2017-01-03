package language.learning.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import language.learning.dto.Token;

/**
 * Created by Cristi on 1/3/2017.
 */

public class SecurityFilter implements Filter {
    @Inject
    private Session session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        System.out.println("A new request arrived from IP [" + request.getRemoteAddr() + "]");

        String hash = servletRequest.getHeader("Authorization");
        // User user = session.getUserByKey(token);
        // if (token == null || user == null) {
        if (hash == null) {
            System.out.println("There is token from IP [" + request.getRemoteAddr() + "]");
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setStatus(401);
            resp.sendError(401, "You are not authorized to acces resource");
        } else {
            Token token = session.getTokenByKey(hash);
            HttpServletResponse resp = (HttpServletResponse) response;
            if (token == null) {
                System.out.println("There is no valid token from IP [" + request.getRemoteAddr() + "]");
                resp.setStatus(401);
                resp.sendError(401, "You are not authorized to acces resource");
            } else {
                String ip = request.getRemoteAddr();
                if (!ip.equals(token.getIp())) {
                    System.out.println("The request comes from annother IP [" + request.getRemoteAddr() + "]");
                    resp.setStatus(401);
                    resp.sendError(401, "You are not authorized to acces resource");
                } else {
                    System.out.println("The request come from user [" + token.getUserDTO().getEmail() + "]");
                    chain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
