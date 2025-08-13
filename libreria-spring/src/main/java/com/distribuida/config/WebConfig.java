package com.distribuida.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry corsRegistry){
                corsRegistry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/portadas/**")
                .addResourceLocations("file:uploads/portadas/");
    }
}
