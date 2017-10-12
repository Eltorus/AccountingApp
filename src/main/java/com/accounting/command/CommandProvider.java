package com.accounting.command;

import java.util.HashMap;
import java.util.Map;
import com.accounting.command.employee.DeleteUserCommand;
import com.accounting.command.employee.GetAllUsersCommand;
import com.accounting.command.employee.LogOutCommand;
import com.accounting.command.employee.SignInCommand;
import com.accounting.command.employee.SignUpCommand;
import com.accounting.command.employee.UpdateUserCommand;
import com.accounting.command.exception.CommandException;

public class CommandProvider {

  private static final Map<String, Command> commands = new HashMap<>();
  private static volatile CommandProvider instance;

  private CommandProvider() {
    commands.put(CommandList.SIGN_IN, new SignInCommand());
    commands.put(CommandList.SIGN_UP, new SignUpCommand());
    commands.put(CommandList.LOG_OUT, new LogOutCommand());
    commands.put(CommandList.GET_ALL_USERS, new GetAllUsersCommand());
    commands.put(CommandList.UPDATE_USER, new UpdateUserCommand());
    commands.put(CommandList.DELETE_USER, new DeleteUserCommand());
  }

  public Command getCommand(String cmdName) throws CommandException {
    Command command = commands.get(cmdName);
    if (command != null) {
      return command;
    } else {
      throw new CommandException("Couldnt find command");
    }
  }

  public static CommandProvider getInstance() {
    CommandProvider localInstance = instance;
    if (localInstance == null) {
      synchronized (CommandProvider.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = new CommandProvider();
        }
      }
    }
    return localInstance;
  }

}
