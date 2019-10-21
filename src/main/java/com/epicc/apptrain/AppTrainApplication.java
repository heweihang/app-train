package com.epicc.apptrain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.epicc.apptrain.system.dao")
public class AppTrainApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppTrainApplication.class, args);
	}

}
