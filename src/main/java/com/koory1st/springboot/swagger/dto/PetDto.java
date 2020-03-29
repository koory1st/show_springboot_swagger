package com.koory1st.springboot.swagger.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class PetDto {
  @NotBlank(message = "name")
  private String name;
  @Max(value = 150, message = "age")
  private Integer age;
  @Max(value = 8, message = "legCount")
  private Integer legCount;
  @Max(value = 8, message = "eyeCount")
  private Integer eyeCount;
}
