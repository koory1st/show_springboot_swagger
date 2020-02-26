package com.koory1st.springboot.swagger.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket configSwagger() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()//<4>
      .apis(RequestHandlerSelectors.any())//<5>
      .paths(Predicates.not(PathSelectors.regex("/error.*")))//<6>, regex must be in double quotes.
      .build()
      .protocols(Stream.of("http").collect(Collectors.toSet()));
  }
}
