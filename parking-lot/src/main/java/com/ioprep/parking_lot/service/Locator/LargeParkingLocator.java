package com.ioprep.parking_lot.service.Locator;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.ParkingGridService;
import org.springframework.stereotype.Service;

@Service
public class LargeParkingLocator extends ParkingLocator {
    @Override
    public ParkingSpot findAavilableSpot(Vehicle vehicle){
        ParkingGrid grid = ParkingGridService.globalParkingGrid;

        for(Floor floor:grid.getFloorList()){
            for(ParkingSpot spot:floor.getParkingSpotList()){
                if(spot.getSpotType()== SpotType.LARGE && spot.getStatus()==SpotStatus.AVAILABLE){
                    return spot;
                }
            }
        }
        return null;

    }
}
