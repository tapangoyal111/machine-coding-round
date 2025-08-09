package com.ioprep.parking_lot.service.TicketEngine;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.Ticket;
import com.ioprep.parking_lot.dto.TicketStatus;
import com.ioprep.parking_lot.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


public interface TicketEngine {

    public abstract Ticket createTicket(Vehicle vehicle, ParkingSpot parkingSpot);


}
