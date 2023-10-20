package com.gridnine.testing;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FlightBuilder.createFlights().forEach(System.out::println);
        System.out.println("Результаты:");
        FilterFlight filter = new FilterFlight();
        System.out.println("Исключены сегменты с датой вылета до текущего момента времени");
        filter.departureToCurrentMoment(FlightBuilder.createFlights(), LocalDateTime.now());
        //filter.departureToCurrentMoment(FlightBuilder.createFlights(), LocalDateTime.now().plusDays(4));
        System.out.println("Исключены сегменты с датой прилёта раньше даты вылета");
        filter.arrivalBeforeDeparture(FlightBuilder.createFlights());
        System.out.println("Cегменты, общее время которых на земле превышает два часа ");
        filter.timeOnEarthExceedsTwoHours(FlightBuilder.createFlights(), 2);
    }
}