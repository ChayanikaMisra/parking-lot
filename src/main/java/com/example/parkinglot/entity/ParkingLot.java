package com.example.parkinglot.entity;

import com.example.parkinglot.enumconstants.BookingConstant;

import java.util.Map;

public class ParkingLot {
    Map<Integer, BookingConstant> positionVsStatusMap;

    public ParkingLot(Map<Integer, BookingConstant> positionVsStatusMap) {
        this.positionVsStatusMap = positionVsStatusMap;
    }

    public Map<Integer, BookingConstant> getPositionVsStatusMap() {
        return positionVsStatusMap;
    }

    public void setPositionVsStatusMap(Map<Integer, BookingConstant> positionVsStatusMap) {
        this.positionVsStatusMap = positionVsStatusMap;
    }
}
