package com.koory1st.spring_boot_swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {
    @Bean
    public CommonsRequestLoggingFilter filter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

        filter.setBeforeMessagePrefix("request start:");
        filter.setAfterMessagePrefix("request end:");
        filter.setIncludeClientInfo(true);
        filter.setIncludeHeaders(false);
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(1000);

        return filter;
    }
}
