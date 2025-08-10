package com.ioprep.parking_lot.dto;

import com.ioprep.parking_lot.service.Parking.ParkingStrategy;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngine;

public class MotorCyle extends Vehicle{

    public MotorCyle(String vehicleNumber ,  ParkingStrategy parkingStrategy, TicketEngine ticketEngine){
        this.vehicleNumber=vehicleNumber;
        this.type= VehicleSize.MEDIUM;
        this.parkingStrategy=parkingStrategy;
        this.ticketEngine= ticketEngine;
        ;
    }


}
