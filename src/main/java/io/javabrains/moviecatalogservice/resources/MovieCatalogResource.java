// MovieCatalogResource.java - (insert one line description here)
// (C) Copyright 2020 Hewlett Packard Enterprise Development LP

package io.javabrains.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerClientAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.model.clientdto.Movie;
import io.javabrains.moviecatalogservice.model.clientdto.Rating;
import io.javabrains.moviecatalogservice.model.clientdto.UserRating;
import io.javabrains.moviecatalogservice.models.CatalogItem;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource
{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	/*@Autowired
	private ReactorLoadBalancerExchangeFilterFunction lbFunction;*/
	
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") final String userId)
    {
    	/*RestTemplate restTemplate = new RestTemplate(); create bean instead*/ 
    	/*List<Rating> ratings = new ArrayList<Rating>();
    	ratings.add(new Rating("1234", 4));
    	ratings.add(new Rating("5678", 3));*/
    	//UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
    	UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
    	/*UserRating ratings = webClientBuilder.build().get().uri("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class)
    			.retrieve().bodyToMono(UserRating.class).block();*/
    	/*UserRating ratings = WebClient.builder().baseUrl("http://ratings-data-service")
    			.filter(lbFunction)
    			.build().get()
    			.uri("/ratingsdata/users/"+userId, UserRating.class)
    			.retrieve().bodyToMono(UserRating.class).block();*/
    	/*UserRating ratings = WebClient.builder()
    			.filter(lbFunction)
    			.build().get()
    			.uri("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class)
    			.retrieve().bodyToMono(UserRating.class).block();*/

    	return ratings.getRatings().stream().map(rating -> {
    		 //Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
    		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
    		/*Movie movie = WebClient.builder().baseUrl("http://movie-info-service")
    				.filter(lbFunction)
    				.build().get()
    				.uri("/movies/"+rating.getMovieId(), Movie.class)
    				.retrieve().bodyToMono(Movie.class).block();*/
    		/*Movie movie = WebClient.builder()
    				.filter(lbFunction)
    				.build().get()
    				.uri("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class)
    				.retrieve().bodyToMono(Movie.class).block();*/
    		/*Movie movie = webClientBuilder.build().get().uri("http:///movie-info-service/movies/"+rating.getMovieId())
    			.retrieve().bodyToMono(Movie.class).block(); //use of reactive asynchronos calls
*/    		return new CatalogItem(movie.getName(), "Dummy Desc Test", rating.getRating());
    	}).collect(Collectors.toList());
    	//bodyToMono : telling framework that in future am going to get this type of Object as response.
    	//block : you telling the framework that you need to block untill the operation is completed.
    	//Bolcking the execution till the mono is fulfilled.
    	//URI should be dynamic, 
        /*return Collections.singletonList(
                new CatalogItem("Transformers", "Test", 4));*/
    }
}
