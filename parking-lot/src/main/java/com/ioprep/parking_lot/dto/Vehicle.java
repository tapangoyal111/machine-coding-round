package com.ioprep.parking_lot.dto;

import com.ioprep.parking_lot.service.Parking.ParkingStrategy;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngine;
import lombok.Data;


@Data
public abstract class  Vehicle {

    public ParkingStrategy parkingStrategy;

    public TicketEngine ticketEngine;

    public String vehicleNumber;
    public VehicleSize type;

}
