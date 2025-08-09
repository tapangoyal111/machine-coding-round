package com.ioprep.parking_lot.service.Factory;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.Parking.CarParkingStrategy;
import com.ioprep.parking_lot.service.Parking.MotorParkingStrategy;
import org.springframework.stereotype.Service;

@Service
public class VehicleFactory {

    public static Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType){
        return switch (vehicleType){
            case CAR -> new Car(vehicleNumber, ParkingStrategyFactory.getCarParkingStrategy());
            case TRUCK ->  new Truck(vehicleNumber, ParkingStrategyFactory.getTruckParkingStrategy());
            case MOTORCYCLE -> new MotorCyle(vehicleNumber, ParkingStrategyFactory.getMotorParkingStrategy());
        };

    }

}
