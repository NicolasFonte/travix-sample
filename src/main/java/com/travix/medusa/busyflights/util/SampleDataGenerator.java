package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class SampleDataGenerator {

    public static CrazyAirResponse createCrazyAirResponseSample(String airline, String arrivalDate, String cabin,
            String departureAirport,
            String departureDate, String destinationAirport, double price) {
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline(airline);
        crazyAirResponse.setArrivalDate(arrivalDate);
        crazyAirResponse.setCabinclass(cabin);
        crazyAirResponse.setDepartureAirportCode(departureAirport);
        crazyAirResponse.setDepartureDate(departureDate);
        crazyAirResponse.setDestinationAirportCode(destinationAirport);
        crazyAirResponse.setPrice(price);
        return crazyAirResponse;
    }

    public static ToughJetResponse createToughResponseSample(String airline, String arrivalDate,
            String departureAirport,
            String departureDate, String destinationAirport, double basePrice, double discount, double tax) {
        ToughJetResponse toughJetResponse = new ToughJetResponse();
        toughJetResponse.setCarrier(airline);
        toughJetResponse.setInboundDateTime(arrivalDate);
        toughJetResponse.setDepartureAirportName(departureAirport);
        toughJetResponse.setOutboundDateTime(departureDate);
        toughJetResponse.setArrivalAirportName(destinationAirport);
        toughJetResponse.setBasePrice(basePrice);
        toughJetResponse.setDiscount(discount);
        toughJetResponse.setTax(tax);

        return toughJetResponse;
    }
}
