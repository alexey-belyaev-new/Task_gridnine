package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        for(Flight it: FlightBuilder.createFlights()){
            System.out.println(it.toString());
        }
        FilterFlight filter = new FilterFlight();
        filter.departureToCurrentMoment(FlightBuilder.createFlights());
        filter.arrivalBeforeDeparture(FlightBuilder.createFlights());
        filter.timeOnEarthExceedsTwoHours(FlightBuilder.createFlights());
    }
}