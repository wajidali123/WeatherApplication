/**
 * 
 */
package org.forcast.app.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${swagger.definition.title}")
	private String swaggerTitle;

	@Value("${swagger.definition.description}")
	private String description;

	@Value("${swagger.definition.version}")
	private String version;

	@Value("${swagger.contact.name}")
	private String contactName;

	@Value("${swagger.contact.site}")
	private String site;

	@Value("${swagger.contact.email}")
	private String email;

	private ApiInfo apiInfo() {
		return new ApiInfo(swaggerTitle, description, version, "", new Contact(contactName, site, email),
				"License of API", "API license URL", Collections.emptyList());
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
	}
}
