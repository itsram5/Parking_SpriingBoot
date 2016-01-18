package com.parking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.parking.configuration.ParkingConfig;
import com.parking.service.ParkingLot;
import com.parking.vechiletypes.Bus;
import com.parking.vechiletypes.Car;
import com.parking.vechiletypes.Motorcycle;

@SpringBootApplication
public class ParkingApplication {
	private static final Logger logger = LoggerFactory.getLogger(ParkingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(ParkingConfig.class);
		 ParkingLot lot= context.getBean(ParkingLot.class);
		
		 //Occupied parking spot indicated by upper case alphabets car(1 parking spot->C), motor cycle(1 parking spot->M)  , bus(3 parking spot->B)
		 //Free parking spots  indicated lower case alphabets:: car->c, motorcycle->m, bus->b
		 
		 Car carVechile=new Car();
		 Car carVechile1=new Car();
		 Motorcycle motorcycle =new Motorcycle();
		 Bus bus=new Bus();
		 lot.parkVehicle(carVechile);
		 lot.parkVehicle(carVechile1);
		 lot.parkVehicle(motorcycle);
		 lot.parkVehicle(bus);
		 logger.info("Displaying the parking slots\n"
		 		+ "Vechiles parked indicated by Upper case alphabets::\n"
		 		+ "car->C.\n"
		 		+ "MotorCycle->M\n"
		 		+ "Bus->B\n"
		 		+ " Free parking spaces is indicated by lower case alphabetes.");
		 
		  lot.print();
		  logger.info("::::::::::::::::::::::::::::::::::::::::\n"
		  		+ "Un park the car vechile ");
		 
		 lot.clearSpots(carVechile);
		 lot.print();
	
	}
	
	
	
}
