package com.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class InsurancePortalApplication {

	//private static final Logger logger = LoggerFactory.getLogger(InsurancePortalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InsurancePortalApplication.class, args);
	}

}
