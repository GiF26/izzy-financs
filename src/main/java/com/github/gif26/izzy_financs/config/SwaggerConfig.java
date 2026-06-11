package com.github.gif26.izzy_financs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Izzy Financs API")
                        .version("1.0.0")
                        .description("API REST para gestão financeira pessoal. Desenvolvido como projeto de portfólio.")
                        .contact(new Contact()
                                .name("Giovanna Ferreira de Sousa")
                                .url("https://github.com/gif26")
                                .email("giovannaferreira2603@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
