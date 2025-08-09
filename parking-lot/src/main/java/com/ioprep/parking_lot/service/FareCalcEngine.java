package com.ioprep.parking_lot.service;

import com.ioprep.parking_lot.dto.Ticket;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class FareCalcEngine {
    public double calcFare(Ticket ticket){
        return ticket.getFare() + ticket.getAdditionalCharge() * (Duration.between(ticket.getEntryTime() , ticket.getExitTime()).toHours());
    }

}
