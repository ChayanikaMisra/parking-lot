package com.example.parkinglot.service;

import com.example.parkinglot.entity.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingManagementService {
    static List<Booking> bookings = new ArrayList<>();

    public static Booking createBooking(int carNo, int position){
        Booking b=new Booking();
        b.setCarNo(carNo);
        b.setPosition(position);
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(LocalDateTime.now().plusHours(1));
        bookings.add(b);
        return b;
    }
    public static int getPosition(int carNo) throws Exception {
        for(Booking b: bookings){
            if(b.getCarNo()==carNo)
                return b.getPosition();
        }
        throw new Exception("No booking found");
    }

}
