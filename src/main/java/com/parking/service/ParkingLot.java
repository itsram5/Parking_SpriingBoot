package com.parking.service;

import com.parking.vechiletypes.Level;
import com.parking.vechiletypes.Vehicle;

public class ParkingLot {
	private Level[] levels;

	public ParkingLot(int numLevels, int numSpots, int perLargeAndSmall,
			int parkingSpotsPerRow) {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new Level(i, numSpots, perLargeAndSmall,
					parkingSpotsPerRow);
		}
	}

	/* Park the vehicle in a spot (or multiple spots). Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}

	public void clearSpots(Vehicle vechile) {
		// return levels.;
		vechile.clearSpots();
	}

	public int availableSpots(Vehicle vechile) {
		return vechile.availableSpots();
	}

	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
}
