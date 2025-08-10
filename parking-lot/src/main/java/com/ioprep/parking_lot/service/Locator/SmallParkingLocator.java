package com.ioprep.parking_lot.service.Locator;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.ParkingGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class SmallParkingLocator extends ParkingLocator {


    @Autowired
    public SmallParkingLocator(@Qualifier("mediumParkingLocator") ParkingLocator nextLocator){
        super();
        this.nextLocator = nextLocator;
    }

    @Override
    public ParkingSpot findAavilableSpot(Vehicle vehicle){

        ParkingGrid grid = ParkingGridService.globalParkingGrid;

        for(Floor floor:grid.getFloorList()){
            for(ParkingSpot spot:floor.getParkingSpotList()){
                if(spot.getSpotType()== SpotType.SMALL && spot.getStatus()==SpotStatus.AVAILABLE){
                    return spot;
                }
            }
        }
        return null;

    }

}
