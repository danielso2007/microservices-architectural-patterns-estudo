package com.acme.ecom.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    public ObjectMapper objectMapperBuilder() {
        ObjectMapper builder = new ObjectMapper();
        builder.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        builder.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        builder.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return builder;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.useRegisteredExtensionsOnly(Boolean.TRUE).defaultContentType(MediaType.APPLICATION_JSON);
    }
}
