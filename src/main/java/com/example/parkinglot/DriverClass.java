package com.example.parkinglot;

import com.example.parkinglot.entity.ParkingLot;
import com.example.parkinglot.service.ParkingManagementService;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Parking Lot");
        System.out.println("Number of positions");
        int numberofPositions = sc.nextInt();
        ParkingLot parkingLot = ParkingManagementService.createParkingLot(numberofPositions);
        System.out.println("Car no entering:");
        int carNo1 = sc.nextInt();
        System.out.println("Car no entering:");
        int carNo2 = sc.nextInt();
        System.out.println("Car no entering:");
        int carNo3 = sc.nextInt();
        System.out.println("Car no entering:");
        int carNo4 = sc.nextInt();
        System.out.println("Car no entering:");
        int carNo5 = sc.nextInt();
        ParkingManagementService.enterParkingLot(parkingLot, carNo1);
        ParkingManagementService.enterParkingLot(parkingLot, carNo2);
        ParkingManagementService.enterParkingLot(parkingLot, carNo3);
        ParkingManagementService.enterParkingLot(parkingLot, carNo4);
        ParkingManagementService.enterParkingLot(parkingLot, carNo5);
        ParkingManagementService.exitParkingLot(parkingLot, carNo1);
        ParkingManagementService.exitParkingLot(parkingLot, carNo2);
        ParkingManagementService.enterParkingLot(parkingLot, carNo3);
        ParkingManagementService.enterParkingLot(parkingLot, carNo4);


    }
}
