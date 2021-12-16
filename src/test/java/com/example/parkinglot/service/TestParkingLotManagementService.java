package com.example.parkinglot.service;


import com.example.parkinglot.entity.ParkingLot;
import com.example.parkinglot.enumconstants.BookingConstant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestParkingLotManagementService {

    @Test
    public void testEnterParkingLot() {
        ParkingManagementService parkingService = new ParkingManagementService();
        ParkingLot parkingLot = parkingService.createParkingLot(2);
        parkingService.enterParkingLot(1);
        assertEquals(parkingLot.getPositionVsStatusMap().get(1), BookingConstant.BOOKED);
        assertEquals(parkingLot.getPositionVsStatusMap().get(2), BookingConstant.AVAILABLE);
    }

    @Test
    public void testEnterAndExitParkingLot() {
        ParkingManagementService parkingService = new ParkingManagementService();
        ParkingLot parkingLot = parkingService.createParkingLot(2);
        parkingService.enterParkingLot(1);
        parkingService.exitParkingLot(1);
        assertNotEquals(parkingLot.getPositionVsStatusMap().get(1), BookingConstant.BOOKED);
        assertEquals(parkingLot.getPositionVsStatusMap().get(1), BookingConstant.AVAILABLE);
    }

    @Test
    public void testExitWithoutEnteringParkingLot() {
        ParkingManagementService parkingService = new ParkingManagementService();
        ParkingLot parkingLot = parkingService.createParkingLot(2);
        parkingService.exitParkingLot(1);
        assertNotEquals(parkingLot.getPositionVsStatusMap().get(1), BookingConstant.BOOKED);
        assertEquals(parkingLot.getPositionVsStatusMap().get(1), BookingConstant.AVAILABLE);
    }
}
