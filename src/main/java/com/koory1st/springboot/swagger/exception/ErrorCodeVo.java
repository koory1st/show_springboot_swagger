package com.koory1st.springboot.swagger.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCodeVo {
  private String code;
  private String message;
}
