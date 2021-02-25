package com.resttemplate.cfg;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {
	
	@Bean
	@LoadBalanced//balanceador de carga
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
