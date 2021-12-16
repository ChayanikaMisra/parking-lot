package com.example.parkinglot.service;

import com.example.parkinglot.entity.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBookingService {
    @Test
    public void testCreatingBookings() {
        Booking booking1 = BookingManagementService.createBooking(1, 2);
        assertEquals(booking1.getCarNo(), 1);
        assertEquals(booking1.getPosition(), 2);

    }

    @Test
    public void testGetPosition() throws Exception {
        BookingManagementService.createBooking(1, 2);
        int position = BookingManagementService.getPosition(1);
        assertEquals(position, 2);
    }

    @Test
    public void testGetPositionException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            BookingManagementService.getPosition(2);
        });
        assertTrue("No booking found".contains(exception.getMessage()));
    }


}
