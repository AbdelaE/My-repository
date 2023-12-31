package et.gov.empProfile.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("et.gov.empProfile"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Pfofile  API")
                .description("Swagger documentation for employee profile")
                .termsOfServiceUrl("http://localhost:8182/employeeProfile")
                .license("abdelaebabu001@gmail.com")
                .licenseUrl("http://localhost:8182/employeeProfile").version("1.0").build();
    }
}
