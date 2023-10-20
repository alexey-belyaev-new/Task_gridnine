package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class FilterFlight implements InterfaceFilterFlight {
    boolean flag = false;
    @Override
    public void departureToCurrentMoment(List<Flight> listFlight, LocalDateTime timeNow) {
        List<Flight> fl = new LinkedList<>();
        for(Flight item: listFlight){
            for(Segment seg: item.getSegments()){
                flag = seg.getDepartureDate().isBefore(timeNow);
            }
            if(!flag){
                fl.add(item);
            }
        }
        fl.forEach(System.out::println);
        flag = false;
    }

    @Override
    public void arrivalBeforeDeparture(List<Flight> listFlight) {
        List<Flight> fl = new LinkedList<>();
        for(Flight item: listFlight){
            for(Segment seg: item.getSegments()) {
                flag = seg.getArrivalDate().isBefore(seg.getDepartureDate());
            }
            if(!flag){
                fl.add(item);
            }
        }
        fl.forEach(System.out::println);
        flag = false;
    }

    @Override
    public void timeOnEarthExceedsTwoHours(List<Flight> listFlight, int hours) {
        List<Flight> fl = new LinkedList<>();
        for(Flight item: listFlight){
            int sizeFlight= item.getSegments().size();
            for (int i = 1; i < sizeFlight - 1; i++) {
                flag = item.getSegments().get(i).
                        getArrivalDate().
                        plusHours(hours).
                        isBefore(item.getSegments().get(i + 1).getDepartureDate());
            }
            if(!flag){
                fl.add(item);
            }
        }
        fl.forEach(System.out::println);
        flag = false;
    }
}
