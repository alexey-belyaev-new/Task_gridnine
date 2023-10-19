package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface InterfaceFilterFlight {
    void departureToCurrentMoment(List<Flight> listFlight);
    void arrivalBeforeDeparture(List<Flight> listFlight);
    void timeOnEarthExceedsTwoHours(List<Flight> listFlight);
}
