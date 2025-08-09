package com.ioprep.parking_lot.service.Utility;

import java.util.UUID;

public class TicketIdGenerator {

    public static String generateRandomTicketId(){
        return UUID.randomUUID().toString().substring(0,5);
    }
}
