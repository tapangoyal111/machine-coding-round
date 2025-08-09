package com.ioprep.parking_lot.service.Locator;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.Vehicle;

public abstract class ParkingLocator {

    ParkingLocator nextlocator;

    public ParkingSpot locateParking(Vehicle vehicle){
        ParkingSpot parkingSpot = findAavilableSpot(vehicle);
        if(parkingSpot!=null){
            return parkingSpot;
        }
        else if (nextlocator!=null){
            return nextlocator.locateParking(vehicle);
        }
        else{
            return  null;
        }
    }

    public abstract  ParkingSpot findAavilableSpot(Vehicle vehicle);

}
