package com.ioprep.parking_lot.dto;

import com.ioprep.parking_lot.service.Factory.TicketEngineFactory;
import com.ioprep.parking_lot.service.Parking.ParkingStrategy;
import com.ioprep.parking_lot.service.TicketEngine.CarTicketingEngine;
import org.springframework.beans.factory.annotation.Autowired;

public class Car extends Vehicle{


    public Car(String vehicleNumber, ParkingStrategy parkingStrategy){
        this.vehicleNumber=vehicleNumber;
        this.type= VehicleSize.MEDIUM;
        this.parkingStrategy=parkingStrategy;
        this.ticketEngine= TicketEngineFactory.getCarTicketingEngine();

    }

}
