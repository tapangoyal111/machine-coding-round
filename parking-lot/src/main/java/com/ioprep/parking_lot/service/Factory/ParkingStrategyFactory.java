package com.ioprep.parking_lot.service.Factory;

import com.ioprep.parking_lot.service.Parking.CarParkingStrategy;
import com.ioprep.parking_lot.service.Parking.MotorParkingStrategy;
import com.ioprep.parking_lot.service.Parking.TruckParkingStrategy;

public class ParkingStrategyFactory {

    private static CarParkingStrategy carParkingStrategy;
    private static TruckParkingStrategy truckParkingStrategy;
    private static MotorParkingStrategy motorParkingStrategy;



    public static CarParkingStrategy getCarParkingStrategy(){
        if(carParkingStrategy==null){
            carParkingStrategy=new CarParkingStrategy();
        }
        return carParkingStrategy;
    }

    public static TruckParkingStrategy getTruckParkingStrategy(){
        if(truckParkingStrategy==null){
            truckParkingStrategy=new TruckParkingStrategy();
        }
        return truckParkingStrategy;
    }

    public static MotorParkingStrategy getMotorParkingStrategy(){
        if(motorParkingStrategy==null){
            motorParkingStrategy=new MotorParkingStrategy();
        }
        return motorParkingStrategy;
    }


}
