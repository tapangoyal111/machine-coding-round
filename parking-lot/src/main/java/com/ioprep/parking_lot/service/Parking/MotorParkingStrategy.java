package com.ioprep.parking_lot.service.Parking;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.SpotStatus;
import com.ioprep.parking_lot.dto.Ticket;
import com.ioprep.parking_lot.dto.Vehicle;
import com.ioprep.parking_lot.service.Factory.ParkingLocatorFactory;
import com.ioprep.parking_lot.service.Locator.ParkingLocator;
import com.ioprep.parking_lot.service.Locator.SmallParkingLocator;
import com.ioprep.parking_lot.service.ParkingGridService;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngine;
import org.springframework.stereotype.Service;

@Service
public class MotorParkingStrategy implements ParkingStrategy{

    private ParkingLocator parkingLocator;


    public MotorParkingStrategy(){
        this.parkingLocator= ParkingLocatorFactory.getSmallParkingLocator();
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
