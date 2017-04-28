package by.stail.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the application.
 * This class starts embedded TomCat server under the hood
 * and deploys application to it
 *
 * @autor Arthur Kushner
 * @since 4/11/17
 */
@SpringBootApplication
public class ZipCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipCodeApplication.class, args);
	}
}
