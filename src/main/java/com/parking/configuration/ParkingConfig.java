package com.parking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.parking.service.ParkingLot;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.parking")
public class ParkingConfig {
	@Autowired
	Environment env;

	@Bean
	public ParkingLot getparlingLot() {

		int numberofLevels = env.getRequiredProperty("numberOfLevels",
				Integer.class);
		int numberOfSpots = env.getRequiredProperty("numberOfSpots",
				Integer.class);
		int perLargeAndSmall = env.getRequiredProperty(
				"percentageOfLargeandMoteorCycletypes", Integer.class);
		int parkingSpotsPerRow = env.getRequiredProperty("numberofSpotsPerRow",
				Integer.class);
		ParkingLot lot = new ParkingLot(numberofLevels, numberOfSpots,
				perLargeAndSmall, parkingSpotsPerRow);
		return lot;

	}

}
