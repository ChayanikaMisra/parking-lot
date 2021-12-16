package com.example.parkinglot;

import com.example.parkinglot.service.ParkingManagementService;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Parking Lot");
        System.out.println("Number of positions");
        int numberofPositions = sc.nextInt();
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

        ParkingManagementService parkingService=new ParkingManagementService();
        parkingService.createParkingLot(numberofPositions);
        parkingService.enterParkingLot(carNo1);
        parkingService.enterParkingLot(carNo2);
        parkingService.enterParkingLot(carNo3);
        parkingService.enterParkingLot(carNo4);
        parkingService.enterParkingLot(carNo5);
        parkingService.exitParkingLot(carNo1);
        parkingService.exitParkingLot(carNo2);
        parkingService.exitParkingLot(carNo3);
        parkingService.exitParkingLot(carNo4);


    }
}
