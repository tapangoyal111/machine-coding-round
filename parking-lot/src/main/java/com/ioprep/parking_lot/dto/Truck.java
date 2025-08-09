package com.ioprep.parking_lot.dto;

import com.ioprep.parking_lot.service.Factory.TicketEngineFactory;
import com.ioprep.parking_lot.service.Parking.ParkingStrategy;
import com.ioprep.parking_lot.service.TicketEngine.TruckTicketingEngine;

public class Truck extends Vehicle{

    public Truck(String vehicleNumber , ParkingStrategy parkingStrategy){
        this.vehicleNumber=vehicleNumber;
        this.type= VehicleSize.MEDIUM;
        this.parkingStrategy=parkingStrategy;
        this.ticketEngine= TicketEngineFactory.getTruckTicketingEngine();
    }

}


