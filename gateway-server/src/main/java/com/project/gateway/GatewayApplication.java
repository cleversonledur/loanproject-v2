package com.project.gateway;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


@SpringBootApplication
@EnableZuulProxy

public class GatewayApplication {
	@Bean
	public Filter logFilter() {
		// TODO: Extract bean-def to Util-component!
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(5120);
		return filter;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	

}
