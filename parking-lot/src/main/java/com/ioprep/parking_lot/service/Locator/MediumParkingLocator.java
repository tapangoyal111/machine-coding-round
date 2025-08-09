package com.ioprep.parking_lot.service.Locator;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.Factory.ParkingLocatorFactory;
import com.ioprep.parking_lot.service.ParkingGridService;
import org.springframework.stereotype.Service;

@Service
public class MediumParkingLocator extends ParkingLocator {

    public MediumParkingLocator(){
        super();
        this.nextlocator = ParkingLocatorFactory.getLargeParkingLocator();;
    }
    @Override
    public ParkingSpot findAavilableSpot(Vehicle vehicle){

        ParkingGrid grid = ParkingGridService.globalParkingGrid;

        for(Floor floor:grid.getFloorList()){
            for(ParkingSpot spot:floor.getParkingSpotList()){
                if(spot.getSpotType()== SpotType.MEDIUM && spot.getStatus()==SpotStatus.AVAILABLE){
                    return spot;
                }
            }
        }
        return null;

    }

}
