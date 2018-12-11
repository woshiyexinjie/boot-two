package com.helloxin.multi.configure;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.helloxin.multi.configure.bean.OperatorBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		Binder binder = Binder.get(context.getEnvironment());

		// 绑定简单配置
		OperatorBean bean = binder.bind("com.helloxin", Bindable.of(OperatorBean.class)).get();
		log.info(bean.toString());
	}
	
	@Bean
    public DataLoader dataLoader() {
        return new DataLoader();
    }

    @Slf4j
    static class DataLoader implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            log.info("Loading data...");
        }
    }


}
