package com.ioprep.parking_lot.service.TicketEngine;

import com.ioprep.parking_lot.dto.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketEngineResolver {

    private Map<VehicleType, TicketEngine> ticketEngineMap;

    @Autowired
    public TicketEngineResolver(List<TicketEngine> ticketEngineList){
        ticketEngineMap = new HashMap<>();
        for(TicketEngine engine: ticketEngineList){
            if(engine instanceof CarTicketingEngine){
                ticketEngineMap.put(VehicleType.CAR,engine);
            }
            else if(engine instanceof TruckTicketingEngine){
                ticketEngineMap.put(VehicleType.TRUCK,engine);
            }
            else if(engine instanceof MotorCycleTicketingEngine){
                ticketEngineMap.put(VehicleType.MOTORCYCLE,engine);
            }
            else{
                System.out.println("We are not support other vehicles");
            }
        }
    }

    public TicketEngine getTicketEngineByType(VehicleType type){
        return ticketEngineMap.get(type);
    }

}
