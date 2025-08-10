package com.ioprep.parking_lot.dto;


import lombok.Data;

import java.util.List;

@Data
public class Floor {

    private int floorNumber;
    private List<ParkingSpot> parkingSpotList;

    public Floor(int floorNumber,List<ParkingSpot> list){
        this.floorNumber=floorNumber;
        this.parkingSpotList=list;
    }

}
