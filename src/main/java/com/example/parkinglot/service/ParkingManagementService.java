package com.example.parkinglot.service;

import com.example.parkinglot.enumconstants.BookingConstant;
import com.example.parkinglot.entity.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingManagementService {

    public static void enterParkingLot(ParkingLot parkingLot, int carNo) {
        Map<Integer, BookingConstant> positionVsStatus = parkingLot.getPositionVsStatusMap();
        boolean booked=false;
        for (Map.Entry<Integer, BookingConstant> positionStatus: positionVsStatus.entrySet()){
            if(positionStatus.getValue().equals(BookingConstant.AVAILABLE)) {
                booked=true;
                BookingManagementService.createBooking(carNo,positionStatus.getKey());
                positionVsStatus.put(positionStatus.getKey(),BookingConstant.BOOKED);
                parkingLot.setPositionVsStatusMap(positionVsStatus);
                break;
            }
        }
        if(booked) {
            System.out.println("booking done for "+carNo);
        }
        else {
            System.out.println("No position available ");
        }
    }

    public static void exitParkingLot(ParkingLot parkinglot, int carNo) {
        try {
            int position = BookingManagementService.getPosition(carNo);
            Map<Integer, BookingConstant> positionStatus= parkinglot.getPositionVsStatusMap();
            positionStatus.put(position, BookingConstant.AVAILABLE);
            parkinglot.setPositionVsStatusMap(positionStatus);
            System.out.println("exiting carNo: "+carNo);
        }
        catch (Exception e){
            System.out.println("No booking found ");
        }
    }

    public static ParkingLot createParkingLot(int positionNo) {
        Map<Integer, BookingConstant> positionStatus=new HashMap<>();
        for(int countPosition=0;countPosition<positionNo;countPosition++){
            positionStatus.put(countPosition+1,BookingConstant.AVAILABLE);
        }
        System.out.println(positionStatus);
        return new ParkingLot(positionStatus);
    }

}
