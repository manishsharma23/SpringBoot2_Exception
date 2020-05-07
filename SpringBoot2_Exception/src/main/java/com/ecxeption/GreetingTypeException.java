package com.ecxeption;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GreetingTypeException extends Exception {

  private static final long serialVersionUID = -189365452227508599L;

  public GreetingTypeException(String message) {
    super(message);
  }

  public GreetingTypeException(Throwable cause) {
    super(cause);
  }

  public GreetingTypeException(String message, Throwable cause) 
  {
    super(message, cause);
  }
}