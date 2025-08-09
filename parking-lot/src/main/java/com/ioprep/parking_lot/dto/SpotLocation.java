package com.ioprep.parking_lot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpotLocation {

    private int floorNumber;
    private int spotNumber;

}
