package com.ioprep.parking_lot.service.TicketEngine;

import com.ioprep.parking_lot.dto.Ticket;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TicketRepo {

    public static Map<String, Ticket> ticketMap;

    @PostConstruct
    public void initializeMap(){
        ticketMap=new HashMap<>();
    }

}
