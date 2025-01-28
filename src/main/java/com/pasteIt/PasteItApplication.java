package com.pasteIt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PasteItApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteItApplication.class, args);
	}

}
