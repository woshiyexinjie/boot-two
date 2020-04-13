package com.helloxin;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.securityContexts(securityContexts())
				.securitySchemes(securitySchemes());
	}

	private List<ApiKey> securitySchemes() {
		return Collections.singletonList(
				new ApiKey("Authorization", "Authorization", "header"));
	}

	private List<SecurityContext> securityContexts() {
		return Lists.newArrayList(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!login).*$"))
						.build()
		);
	}

	List<SecurityReference> defaultAuth() {
		return Lists.newArrayList(
				new SecurityReference("Authorization", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")}));
	}
}