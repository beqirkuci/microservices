package com.example.configurationserverarchaius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerArchaiusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerArchaiusApplication.class, args);
	}

}
