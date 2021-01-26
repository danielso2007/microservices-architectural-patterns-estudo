package com.acme.ecom.product;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = {"com.acme.ecom.product.feing", "com.acme.ecom.product.hystrix"})
@ComponentScan(basePackages = {"com.acme.ecom.product"})
@SpringBootApplication
@EnableCircuitBreaker
public class EcomProductWebApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(EcomProductWebApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run();
	}

}
