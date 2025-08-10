package com.ioprep.parking_lot.service.Parking;

import com.ioprep.parking_lot.dto.ParkingSpot;
import com.ioprep.parking_lot.dto.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingStrategyResolver {

    private Map<VehicleType,ParkingStrategy> strategyMap;

    @Autowired
    public ParkingStrategyResolver(List<ParkingStrategy> parkingStrategies){
        strategyMap=new HashMap<>();
        for(ParkingStrategy type: parkingStrategies){
            if(type instanceof CarParkingStrategy){
                strategyMap.put(VehicleType.CAR,type);
            }
            else if(type instanceof MotorParkingStrategy){
                strategyMap.put(VehicleType.MOTORCYCLE,type);
            }
            else if(type instanceof TruckParkingStrategy){
                strategyMap.put(VehicleType.TRUCK,type);
            }
            else{
                System.out.println("Currently Not supported");
            }
        }
    }

    public ParkingStrategy getStrategybyType(VehicleType type){
        return strategyMap.get(type);
    }


}
