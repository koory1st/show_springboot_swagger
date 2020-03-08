package com.koory1st.springboot.swagger.exception.handler;

import com.koory1st.springboot.swagger.exception.ErrorCodeVo;
import com.koory1st.springboot.swagger.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MyException.class)
  @ResponseBody
  public ErrorCodeVo handleMyException(MyException ex) {

    return new ErrorCodeVo("003", "id is three");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ErrorCodeVo handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

    String errorMessage = ex.getBindingResult().getAllErrors().stream()
      .map(error -> getArgMessageByError(error))
      .collect(Collectors.joining(","));

    return new ErrorCodeVo("003", errorMessage);
  }

  private String getArgMessageByError(ObjectError error) {
    if (Objects.equals(error.getCode(), "Max")) {
      return String.format("%s can't be more than %s", error.getDefaultMessage(), getLastArg(error.getArguments()));
    }

    if (Objects.equals(error.getCode(), "NotBlank")) {
      return String.format("%s can't be empty", error.getDefaultMessage());
    }

    return null;
  }

  private String getLastArg(Object[] args) {
    return args != null && args.length > 0 ? args[args.length - 1].toString() : null;

  }

}
