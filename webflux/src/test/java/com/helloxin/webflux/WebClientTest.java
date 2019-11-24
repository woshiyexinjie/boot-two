package com.helloxin.webflux;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientTest {
    public static void main(String[] args) {
    	 Mono<String> resp = WebClient.create()
                 .method(HttpMethod.GET)
                 .uri("http://boneage-nmpa-2.beta.yitu-med.info/boneage_api/getConclusion?seriesUuid=123")
                 .cookie("token","xxxx")
                 .cookie("JSESSIONID","XXXX")
                 .retrieve()
                 .bodyToMono(String.class);
    	     	
	}
}
