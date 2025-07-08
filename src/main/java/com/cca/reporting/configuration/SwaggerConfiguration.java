package com.cca.reporting.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder().group("Api").pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                    new Info()
                        .title("REPORTING API")
                        .description("Bomyr Kamguia Research & Analytics")
                        .version("1.0"));
    }
}