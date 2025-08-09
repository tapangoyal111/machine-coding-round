package com.ioprep.parking_lot.service.Factory;

import com.ioprep.parking_lot.service.TicketEngine.CarTicketingEngine;
import com.ioprep.parking_lot.service.TicketEngine.MotorCycleTicketingEngine;
import com.ioprep.parking_lot.service.TicketEngine.TruckTicketingEngine;

public class TicketEngineFactory {

    private static CarTicketingEngine carTicketingEngine;

    private static MotorCycleTicketingEngine motorCycleTicketingEngine;

    private static  TruckTicketingEngine truckTicketingEngine;

    public static CarTicketingEngine getCarTicketingEngine(){
        if(carTicketingEngine==null){
            carTicketingEngine=new CarTicketingEngine();
        }
        return carTicketingEngine;
    }

    public static TruckTicketingEngine getTruckTicketingEngine(){
        if(truckTicketingEngine==null){
            truckTicketingEngine=new TruckTicketingEngine();
        }
        return truckTicketingEngine;
    }
    public static MotorCycleTicketingEngine getMotorCycleTicketingEngine(){
        if(motorCycleTicketingEngine==null){
            motorCycleTicketingEngine=new MotorCycleTicketingEngine();
        }
        return motorCycleTicketingEngine;
    }




}
