package com.koory1st.springboot.swagger.exception.handler;

import com.koory1st.springboot.swagger.exception.ErrorCodeVo;
import com.koory1st.springboot.swagger.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MyException.class)
  @ResponseBody
  public ErrorCodeVo handleMyException(MyException ex) {

    return new ErrorCodeVo("003", "id is three");
  }
}
