package com.accounting.command.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.Command;
import com.accounting.command.PageList;
import com.accounting.command.exception.CommandException;

public class LogOutCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    req.getSession().invalidate();

    return PageList.PROFILE;
  }

}
