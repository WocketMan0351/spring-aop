package com.worthen.cody.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.worthen.cody.springaop.business.Business1;
import com.worthen.cody.springaop.business.Business2;

/**
 * An aspect is a modularization of a concern that cuts across multiple classes
 * and/or layers of an application (i.e. the web, business logic, and data
 * layers).
 */

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Business1 business1;

	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	// we can get the beans through the CommandLineRunner interface instead of the
	// application context we get from spring boot's auto config
	public void run(String... args) throws Exception {
		LOGGER.info(business1.calculateSomething());
		LOGGER.info(business2.calculateSomething());
	}

}
