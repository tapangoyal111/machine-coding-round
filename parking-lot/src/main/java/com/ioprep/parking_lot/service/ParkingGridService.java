package com.ioprep.parking_lot.service;

import com.ioprep.parking_lot.dto.*;
import com.ioprep.parking_lot.service.Locator.ParkingLocator;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Service
public class ParkingGridService {

    public static ParkingGrid globalParkingGrid;

    @PostConstruct
    public void initializeGrid(){

        System.out.println("Initializing Parking Grid");

        globalParkingGrid = new ParkingGrid();
        Floor floor0= new Floor(0,new ArrayList<>());
        Floor floor1= new Floor(1,new ArrayList<>());
        Floor floor2= new Floor(2,new ArrayList<>());


        for(int i=0;i<1;i++){
            for(SpotType spotType: SpotType.values()){
                floor0.getParkingSpotList().add(new ParkingSpot(SpotStatus.AVAILABLE,"FLOOR_0_"+"SPOT_"+spotType.name()+"_"+i,new SpotLocation(0,3*i + spotType.ordinal()),spotType));
            }
        }

        for(int i=0;i<1;i++){
            for(SpotType spotType: SpotType.values()){
                floor1.getParkingSpotList().add(new ParkingSpot(SpotStatus.AVAILABLE,"FLOOR_1_"+"SPOT_"+spotType.name()+"_"+i,new SpotLocation(1,3*i + spotType.ordinal()),spotType));
            }
        }

        for(int i=0;i<1;i++){
            for(SpotType spotType: SpotType.values()){
                floor2.getParkingSpotList().add(new ParkingSpot(SpotStatus.AVAILABLE,"FLOOR_2_"+"SPOT_"+spotType.name()+"_"+i,new SpotLocation(2,3*i + spotType.ordinal()),spotType));
            }
        }

        globalParkingGrid.setFloorList(Arrays.asList(floor0,floor1,floor2));

        System.out.println("Parking Grid initialized");

        showGrid();




    }

    public static void showGrid(){
        for(Floor floor: globalParkingGrid.getFloorList()){
            for(ParkingSpot spot : floor.getParkingSpotList()){
                System.out.print(spot.toString()+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
