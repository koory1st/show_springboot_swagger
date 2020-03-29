package com.koory1st.springboot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ResourceBundle;

@Configuration
public class MessageSourceConfig {
  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource source = new ResourceBundleMessageSource() {
      @Override
      protected String getStringOrNull(ResourceBundle bundle, String key) {
        String rt = super.getStringOrNull(bundle, key);

        if (rt == null) {
          return null;
        }

        return rt.replaceAll("'", "''");
      }
    };

    source.setBasenames("message.error", "message.field");
    source.setDefaultEncoding("UTF-8");

    return source;
  }
}
