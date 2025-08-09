package com.ioprep.parking_lot.service.Factory;


import com.ioprep.parking_lot.service.Locator.LargeParkingLocator;
import com.ioprep.parking_lot.service.Locator.MediumParkingLocator;
import com.ioprep.parking_lot.service.Locator.SmallParkingLocator;

public class ParkingLocatorFactory {

    private static SmallParkingLocator smallParkingLocator;
    private static MediumParkingLocator mediumParkingLocator;
    private static LargeParkingLocator largeParkingLocator;

    public static SmallParkingLocator getSmallParkingLocator(){
        if(smallParkingLocator==null){
            smallParkingLocator=new SmallParkingLocator();
        }
        return smallParkingLocator;
    }

    public static MediumParkingLocator getMediumParkingLocator(){
        if(mediumParkingLocator==null){
            mediumParkingLocator=new MediumParkingLocator();
        }
        return mediumParkingLocator;
    }

    public static LargeParkingLocator getLargeParkingLocator(){
        if(largeParkingLocator==null){
            largeParkingLocator=new LargeParkingLocator();
        }
        return largeParkingLocator;
    }
}
