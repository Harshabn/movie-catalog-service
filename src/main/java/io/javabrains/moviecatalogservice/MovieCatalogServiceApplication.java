package io.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerClientAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "ratings-data-service", configuration = RibbonConfiguration.class)
public class MovieCatalogServiceApplication {

	//Calls the service discovery to get the actual URI and then calls the actual service ,
	//these things will happen in the background with 2 hops/calls so the name client side discovery
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	//WebClient is from Reactive
	/*@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}*/
	
	/*public ReactorLoadBalancerExchangeFilterFunction getReactiveLoadBalancer() {
		    return new ReactorLoadBalancerExchangeFilterFunction(null);
	}*/
	public static void main(final String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}
}
