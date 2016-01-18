package com.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parking.configuration.ParkingConfig;
import com.parking.service.ParkingLot;
import com.parking.vechiletypes.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ParkingApplication.class)
public class ParkingApplicationTests {
	@Autowired
	ParkingLot lot;
	@Autowired
	ParkingConfig config;
	
	
	@Test
	public void addVechile(){
		//Maximum allowed car slots as per configuration defined in configuration file is =115
		//Number of levels =5
		//Number of spots each level =30
		//Number of larger+ Compact is =115 Till 115 expected to allocate
		//116 expected reeturn false as car is not avilable
		//Similarly 35 slots motorcycles are allowed to park hence returns true
		//36 slot return flase;
		
		
		for(int i=1;i<=115;i++){
			//car is not allowed park , hence returns false.
			if(i==116){
				assertFalse(lot.parkVehicle(new Car()));
				
			}	
		// cars are parked in 115 slots 
		   assertTrue (lot.parkVehicle(new Car()));
				
		}
		lot.print();
	}

}
