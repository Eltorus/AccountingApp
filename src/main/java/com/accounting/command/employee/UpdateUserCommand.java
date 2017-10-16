package com.accounting.command.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.AttributeList;
import com.accounting.command.Command;
import com.accounting.command.EmployeeValidation;
import com.accounting.command.PageList;
import com.accounting.command.ParameterList;
import com.accounting.command.exception.CommandException;
import com.accounting.model.Employee;
import com.accounting.service.EmployeeService;
import com.accounting.service.ServiceFactory;
import com.accounting.service.exception.ServiceException;

public class UpdateUserCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();

    String id = req.getParameter(ParameterList.ID);
    Employee employee = (Employee) req.getSession().getAttribute(AttributeList.ATTR_USER);

    if (EmployeeValidation.isStringEmpty(id)) {
      return PageList.WRONG_INPUT;
    }

    try {
      if (Long.toString(employee.getId()).equals(id)) {
        employeeService.updateEmployee(employee);
        return PageList.PROFILE;
      } else if (employee.isAdmin()) {
        Employee processedEmployee = new Employee();
        processedEmployee.setId(Long.parseLong(id));
        processedEmployee = employeeService.getEmployeeById(processedEmployee);

        String position = req.getParameter(ParameterList.POSITION);
        processedEmployee.setPosition(position);
        employeeService.updateEmployee(processedEmployee);

        return PageList.ADMIN_PAGE;
      } else {
        return PageList.WRONG_INPUT;
      }
    } catch (ServiceException e) {
      System.err.println(e);
      throw new CommandException("Error during updating user", e);
    }
  }

}
