package com.ioprep.parking_lot.service;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.Factory.VehicleFactory;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngine;
import com.ioprep.parking_lot.service.TicketEngine.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingManager {

    @Autowired
    FareCalcEngine fareCalcEngine;


    public Ticket parkVehicle(VehicleType vehicleType , String vehicleId){

        Vehicle vehicle= VehicleFactory.getVehicle(vehicleId,vehicleType);
        ParkingSpot parkingSpot=vehicle.getParkingStrategy().parkVehicle(vehicle);

        if(parkingSpot!=null){
            Ticket ticket = vehicle.getTicketEngine().createTicket(vehicle,parkingSpot);
            return ticket;
        }
        return null;
    }

    public double unparkVehicle(String ticketId){
        Ticket ticket= TicketRepo.ticketMap.get(ticketId);
        ParkingSpot spot = ticket.getParkingSpot();
        spot.setStatus(SpotStatus.AVAILABLE);
        ticket.setExitTime(LocalDateTime.now());
        ticket.setTicketStatus(TicketStatus.CLOSED);

        return fareCalcEngine.calcFare(TicketRepo.ticketMap.get(ticketId));

    }

}
