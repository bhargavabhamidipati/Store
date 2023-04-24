package com.example.StoreBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"com.example.StoreBackend"})
public class StoreBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(StoreBackendApplication.class, args);
	}

}
