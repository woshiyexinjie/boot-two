package com.helloxin.webflux;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientTest {
    public static void main(String[] args) {
//    	 Mono<String> resp = WebClient.create()
//                 .method(HttpMethod.GET)
//                 .uri("http://boneage-nmpa-2.beta.yitu-med.info/boneage_api/getConclusion?seriesUuid=123")
//                 .cookie("token","xxxx")
//                 .cookie("JSESSIONID","XXXX")
//                 .retrieve()
//                 .bodyToMono(String.class);

		WebClient webClient = WebClient.create();

		Mono<String> mono = webClient
				.get() // GET 请求
				.uri("http://jsonplaceholder.typicode.com/posts/1")  // 请求路径
				.retrieve() // 获取响应体
				.bodyToMono(String.class); //响应数据类型转换

		System.out.println(mono.block());
    	     	
	}
}
