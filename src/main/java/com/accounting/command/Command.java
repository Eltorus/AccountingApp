package com.accounting.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.exception.CommandException;

public interface Command {
  String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException;
}
