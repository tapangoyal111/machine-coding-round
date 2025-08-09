package com.ioprep.parking_lot.service.TicketEngine;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.Ticket;
import com.ioprep.parking_lot.dto.TicketStatus;
import com.ioprep.parking_lot.dto.Vehicle;
import com.ioprep.parking_lot.service.Utility.TicketIdGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.ioprep.parking_lot.service.Utility.Constants.*;
@Service
public class CarTicketingEngine implements TicketEngine {
    @Override
    public Ticket createTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket(TicketIdGenerator.generateRandomTicketId(),vehicle,parkingSpot, LocalDateTime.now(),null, CAR_FARE,CAR_ADDITIONAL_FARE_PER_HOUR, TicketStatus.OPEN);
        TicketRepo.ticketMap.put(ticket.getId(),ticket);
        return ticket;
    }

}
