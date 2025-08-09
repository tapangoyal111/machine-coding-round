package com.ioprep.parking_lot.dto;

import jakarta.websocket.OnError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fare;
    private  double additionalCharge;
    private TicketStatus ticketStatus;

    @Override
    public String toString(){

        return "Ticket with id "+ id + " for vehicle " + vehicle.getVehicleNumber();
    }



}
