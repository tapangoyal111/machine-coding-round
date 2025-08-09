package com.ioprep.parking_lot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingSpot {

    private SpotStatus status;
    private String spotId;
    private SpotLocation location;
    private SpotType spotType;

    @Override
    public String toString(){
        return (spotType.toString().charAt(0)+"_"+location.getSpotNumber()+"_"+status.toString().substring(0,2));
    }

}
