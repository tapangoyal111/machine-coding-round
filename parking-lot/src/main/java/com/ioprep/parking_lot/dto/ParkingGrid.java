package com.ioprep.parking_lot.dto;

import lombok.Data;

import java.util.List;

@Data
public class ParkingGrid {

    private int gridId;
    private List<Floor> floorList;

}
