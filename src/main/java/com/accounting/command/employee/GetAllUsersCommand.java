package com.accounting.command.employee;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.AttributeList;
import com.accounting.command.Command;
import com.accounting.command.PageList;
import com.accounting.command.exception.CommandException;
import com.accounting.model.Employee;
import com.accounting.service.EmployeeService;
import com.accounting.service.ServiceFactory;
import com.accounting.service.exception.ServiceException;

public class GetAllUsersCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();
    Employee employee = (Employee) req.getSession().getAttribute(AttributeList.ATTR_USER);

    try {
      if (employee.isAdmin()) {
        List<Employee> list = employeeService.getAllEmployees();
        req.setAttribute(AttributeList.ATTR_USER_LIST, list);
        return PageList.ADMIN_PAGE;
      } else {
        return PageList.WRONG_INPUT;
      }
    } catch (ServiceException e) {
      throw new CommandException("Error during getting all users", e);
    }
  }

}
