package com.accounting.util.exception;

public class UtilException extends Exception {

  public UtilException() {
    super();
  }

  public UtilException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public UtilException(String message, Throwable cause) {
    super(message, cause);
  }

  public UtilException(String message) {
    super(message);
  }

  public UtilException(Throwable cause) {
    super(cause);
  }

}
