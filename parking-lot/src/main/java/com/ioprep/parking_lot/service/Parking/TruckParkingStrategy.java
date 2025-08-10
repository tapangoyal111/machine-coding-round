package com.ioprep.parking_lot.service.Parking;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.SpotStatus;
import com.ioprep.parking_lot.dto.Vehicle;
import com.ioprep.parking_lot.service.Locator.ParkingLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TruckParkingStrategy implements ParkingStrategy{

    private ParkingLocator parkingLocator;

    @Autowired
    public TruckParkingStrategy(@Qualifier("largeParkingLocator") ParkingLocator parkingLocator){
        this.parkingLocator= parkingLocator;
    }

    @Override
    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot availableSpot=parkingLocator.locateParking(vehicle);
        if(availableSpot==null){
            return null;
        }
        availableSpot.setStatus(SpotStatus.OCCUPIED);
        return availableSpot;
    }

}
