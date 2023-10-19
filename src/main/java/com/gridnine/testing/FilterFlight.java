package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilterFlight implements InterfaceFilterFlight {
    DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    public void departureToCurrentMoment(List<Flight> listFlight) {
        LocalDateTime timeNow = LocalDateTime.now();
        for(Flight item: listFlight){
            for(Segment seg: item.getSegments()){
                if(seg.getDepartureDate().isBefore(timeNow)){
                    System.out.println("Вылет до текущего момента времени " +
                                seg.getDepartureDate().format(fmt));
                }
            }
        }
    }

    @Override
    public void arrivalBeforeDeparture(List<Flight> listFlight) {
        for(Flight item: listFlight){
            for(Segment seg: item.getSegments()){
                if(seg.getArrivalDate().isBefore(seg.getDepartureDate())){
                    System.out.println("Cегменты с датой прилёта раньше даты вылета " +
                                seg.getArrivalDate().format(fmt) + " | " +
                                seg.getDepartureDate().format(fmt));
                }
            }
        }
    }

    @Override
    public void timeOnEarthExceedsTwoHours(List<Flight> listFlight) {
        int size = listFlight.size();
        for(Flight item: listFlight){
            for(Segment seg: item.getSegments()){
                if(seg.getArrivalDate().plusHours(2).isBefore(seg.getDepartureDate())){
                    System.out.println("Cегменты, общее время которых на земле превышает два часа " +
                            seg.getArrivalDate().format(fmt) + " | " +
                            seg.getDepartureDate().format(fmt));
                }
            }
        }
    }
}
