package com.example.parkinglot.service;


import com.example.parkinglot.entity.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestParkingLotManagementService {

    @Test
    public void testEnterParkingLot() {
        ParkingLot parkingLot = ParkingManagementService.createParkingLot(2);
        ParkingManagementService.enterParkingLot(parkingLot, 1);
        assertEquals(parkingLot.getPositionVsStatusMap().get(1),"Booked");
        assertEquals(parkingLot.getPositionVsStatusMap().get(2),"Available");
    }

    @Test
    public void testEnterAndExitParkingLot() {
        ParkingLot parkingLot = ParkingManagementService.createParkingLot(1);
        ParkingManagementService.enterParkingLot(parkingLot, 1);
        ParkingManagementService.exitParkingLot(parkingLot, 1);
        assertNotEquals(parkingLot.getPositionVsStatusMap().get(1),"Booked");
        assertEquals(parkingLot.getPositionVsStatusMap().get(1),"Available");
    }
    @Test
    public void testExitWithoutEnteringParkingLot() {
        ParkingLot parkingLot = ParkingManagementService.createParkingLot(1);
        ParkingManagementService.exitParkingLot(parkingLot, 1);
        assertNotEquals(parkingLot.getPositionVsStatusMap().get(1),"Booked");
        assertEquals(parkingLot.getPositionVsStatusMap().get(1),"Available");
    }
}
