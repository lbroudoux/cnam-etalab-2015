package fr.covea.hackdds.web;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple filter for enabling CORS on http request. See https://spring.io/guides/gs/rest-service-cors/.
 * @author laurent
 */
@Component
public class SimpleCORSFilter implements Filter {

   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
      HttpServletResponse response = (HttpServletResponse) res;
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
      chain.doFilter(req, res);
   }

   public void init(FilterConfig filterConfig) {}

   public void destroy() {}
}