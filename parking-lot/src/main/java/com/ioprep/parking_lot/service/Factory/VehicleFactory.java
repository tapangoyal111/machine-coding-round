package com.ioprep.parking_lot.service.Factory;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.Parking.*;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngine;
import com.ioprep.parking_lot.service.TicketEngine.TicketEngineResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleFactory {

    private static  ParkingStrategyResolver parkingStrategyResolver;

    private static TicketEngineResolver ticketEngineResolver;

    @Autowired
    public VehicleFactory(ParkingStrategyResolver parkingStrategyResolver, TicketEngineResolver ticketEngineResolver){
        this.parkingStrategyResolver=parkingStrategyResolver;
        this.ticketEngineResolver=ticketEngineResolver;
    }

    public static Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType){

        return switch (vehicleType){
            case CAR -> new Car(vehicleNumber, parkingStrategyResolver.getStrategybyType(vehicleType),ticketEngineResolver.getTicketEngineByType(vehicleType));
            case TRUCK ->  new Truck(vehicleNumber, parkingStrategyResolver.getStrategybyType(vehicleType),ticketEngineResolver.getTicketEngineByType(vehicleType));
            case MOTORCYCLE -> new MotorCyle(vehicleNumber, parkingStrategyResolver.getStrategybyType(vehicleType),ticketEngineResolver.getTicketEngineByType(vehicleType));
        };

    }

}
