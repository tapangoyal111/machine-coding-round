package com.ioprep.parking_lot;

import com.ioprep.parking_lot.dto.ParkingGrid;
import com.ioprep.parking_lot.dto.Ticket;
import com.ioprep.parking_lot.dto.VehicleType;
import com.ioprep.parking_lot.service.ParkingGridService;
import com.ioprep.parking_lot.service.ParkingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ParkingLotApplication {





	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ParkingLotApplication.class, args);



		ParkingManager parkingManager = context.getBean(ParkingManager.class);



		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome of Parking Lot Service \n Here's a Parking facility of 3 floors with 15 Parking spot each");


		String[] inputList;


		System.out.println("Please input");
//
		Input:
//		park CAR KA-01-HH-1234
//		park TRUCK KA-01-HH-9999
//		unpark TICKET_1
//		display

		while(true){
			inputList = sc.nextLine().split(" ");
			if (inputList.length==3){
				Ticket ticket=parkingManager.parkVehicle(VehicleType.valueOf(inputList[1]),inputList[2]);
				if(ticket!=null){
					System.out.println(ticket);
				}

				ParkingGridService.showGrid();
			}
			else{
				System.out.println(parkingManager.unparkVehicle(inputList[1]));
				ParkingGridService.showGrid();
			}
		}




	}

}
