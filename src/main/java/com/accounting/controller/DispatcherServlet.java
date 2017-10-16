package com.accounting.controller;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.Command;
import com.accounting.command.CommandList;
import com.accounting.command.CommandProvider;
import com.accounting.command.PageList;
import com.accounting.command.exception.CommandException;

public class DispatcherServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher rd = getServletContext().getRequestDispatcher(process(req, resp));
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath() + process(req, resp));
  }

  private String process(HttpServletRequest request, HttpServletResponse response) {
    CommandProvider provider = CommandProvider.getInstance();
    String cmdName = request.getParameter(CommandList.CMD);
    try {
      Command command = provider.getCommand(cmdName);
      return command.execute(request, response);
    } catch (CommandException e) {
      e.printStackTrace();
      return PageList.ERROR;
    }
  }
}

