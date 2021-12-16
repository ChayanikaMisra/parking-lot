package com.example.parkinglot.service;

import com.example.parkinglot.enumconstants.BookingConstant;
import com.example.parkinglot.entity.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingManagementService {

    ParkingLot parkingLot;

    public void enterParkingLot(int carNo) {
        Map<Integer, BookingConstant> positionVsStatus = this.parkingLot.getPositionVsStatusMap();
        boolean booked = false;
        for (Map.Entry<Integer, BookingConstant> positionStatus : positionVsStatus.entrySet()) {
            if (positionStatus.getValue().equals(BookingConstant.AVAILABLE)) {
                booked = true;
                BookingManagementService.createBooking(carNo, positionStatus.getKey());
                positionVsStatus.put(positionStatus.getKey(), BookingConstant.BOOKED);
                this.parkingLot.setPositionVsStatusMap(positionVsStatus);
                break;
            }
        }
        if (booked) {
            System.out.println("booking done for " + carNo);
        } else {
            System.out.println("No position available ");
        }
    }

    public void exitParkingLot(int carNo) {
        try {
            int position = BookingManagementService.getPosition(carNo);
            Map<Integer, BookingConstant> positionStatus = this.parkingLot.getPositionVsStatusMap();
            positionStatus.put(position, BookingConstant.AVAILABLE);
            this.parkingLot.setPositionVsStatusMap(positionStatus);
            System.out.println("exiting carNo: " + carNo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ParkingLot createParkingLot(int positionNo) {
        Map<Integer, BookingConstant> positionStatus = new HashMap<>();
        for (int countPosition = 0; countPosition < positionNo; countPosition++) {
            positionStatus.put(countPosition + 1, BookingConstant.AVAILABLE);
        }
        System.out.println(positionStatus);
        this.parkingLot = new ParkingLot(positionStatus);
        return this.parkingLot;
    }

}
