package com.koory1st.springboot.swagger.exception.handler;

import com.koory1st.springboot.swagger.exception.ErrorCodeVo;
import com.koory1st.springboot.swagger.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
  @Autowired
  private MessageSource messageSource;

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

    String code = "E00001";
    String errorMessage = ex.getBindingResult().getAllErrors().stream()
      .map(error -> getArgMessageByError(code, error))
      .collect(Collectors.joining(","));

    return new ErrorCodeVo(code, errorMessage);
  }

  private String getArgMessageByError(String code, ObjectError error) {
    String field = error.getDefaultMessage();
    if (field != null) {
      field = messageSource.getMessage(field, null, LocaleContextHolder.getLocale());
    }
    return messageSource.getMessage(
      code,
      new String[] {field, getLastArg(error.getArguments())},
      LocaleContextHolder.getLocale());
  }

  private String getLastArg(Object[] args) {
    return args != null && args.length > 0 ? args[args.length - 1].toString() : null;

  }

}
