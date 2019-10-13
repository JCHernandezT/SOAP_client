package com.example.soap.consuming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.soap.consuming.service.CountryClient;
import com.example.soap.consuming.wsdl.GetCountryResponse;

@SpringBootApplication
public class ConsumingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
