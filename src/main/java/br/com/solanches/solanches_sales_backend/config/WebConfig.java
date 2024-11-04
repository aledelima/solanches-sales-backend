package br.com.solanches.solanches_sales_backend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);


    @Value("${ALLOWED_CORS_ORIGINS:http://localhost:3000}")
    private String[] allowedCorsOrigins;

    public void addCorsMappings(CorsRegistry registry) {
        logger.info("Allowed Origins: {}", (Object) allowedCorsOrigins);
        registry.addMapping("/**")
                .allowedOrigins(allowedCorsOrigins)
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
