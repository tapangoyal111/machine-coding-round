package com.ioprep.parking_lot.service.Parking;

import com.ioprep.parking_lot.dto.ParkingGrid;
import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.Ticket;
import com.ioprep.parking_lot.dto.Vehicle;
import com.ioprep.parking_lot.service.ParkingGridService;

public interface ParkingStrategy {

    public  ParkingSpot parkVehicle(Vehicle vehicle);



}
