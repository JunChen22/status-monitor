package com.junchen.statusmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StatusMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatusMonitorApplication.class, args);
	}
}