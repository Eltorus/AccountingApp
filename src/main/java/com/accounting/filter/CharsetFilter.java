package com.accounting.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

  private static final String INIT_PARAMETER = "charsetEncoding";
  private String encoding;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    response.setCharacterEncoding(encoding);
    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {
    encoding = fConfig.getInitParameter(INIT_PARAMETER);
  }

  @Override
  public void destroy() {
    encoding = null;
  }

}
