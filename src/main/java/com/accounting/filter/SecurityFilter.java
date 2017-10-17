package com.accounting.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.AttributeList;
import com.accounting.command.CommandList;
import com.accounting.command.PageList;
import com.accounting.model.Employee;

public class SecurityFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    Employee employee = (Employee) request.getSession().getAttribute(AttributeList.ATTR_USER);

    String page = null;
    String command = request.getParameter(CommandList.CMD);
    if (isAdminCommand(command) && (employee == null || !employee.isAdmin())) {
        page = PageList.SIGN_IN;
    }

    if (page != null) {
      response.sendRedirect(request.getContextPath() + page);
    } else {
      chain.doFilter(req, res);
    }
  }

  private boolean isAdminCommand(String command) {
    return CommandList.GET_ALL_USERS.equals(command);
  }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig fConfig) throws ServletException {}

}
