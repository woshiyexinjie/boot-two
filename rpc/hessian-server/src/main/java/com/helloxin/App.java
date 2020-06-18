package com.helloxin;

import com.helloxin.service.HelloService;
import com.helloxin.service.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public HelloService helloService(){
        return new HelloServiceImpl();
    }

    @Bean(name = "/helloService")
    public HessianServiceExporter accountService(){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(helloService());
        exporter.setServiceInterface(HelloService.class);
        return exporter;
    }
}
