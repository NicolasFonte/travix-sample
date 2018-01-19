package com.travix.medusa.busyflights.service.mapper;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.travix.TravixFlightRequest;
import com.travix.medusa.busyflights.domain.travix.TravixFlightResponse;

public class DataMapper {

    public static CrazyAirRequest mapCrazyAirRequest(TravixFlightRequest request) {
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setDepartureDate(request.getDepartureDate());
        crazyAirRequest.setDestination(request.getDestination());
        crazyAirRequest.setOrigin(request.getOrigin());
        crazyAirRequest.setPassengerCount(request.getPassengerCount());
        crazyAirRequest.setReturnDate(request.getReturnDate());

        return crazyAirRequest;
    }

    public static TravixFlightResponse mapCrazyAirResponse(CrazyAirResponse crazyAirResponse) {
        TravixFlightResponse travixFlightResponse = new TravixFlightResponse();
        travixFlightResponse.setAirline(crazyAirResponse.getAirline());
        travixFlightResponse.setArrivalDate(crazyAirResponse.getArrivalDate());
        travixFlightResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
        travixFlightResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        travixFlightResponse.setPrice(crazyAirResponse.getPrice());

        return travixFlightResponse;
    }

    public static TravixFlightResponse mapToughJetResponse(ToughJetResponse tjResponse) {
        TravixFlightResponse travixFlightResponse = new TravixFlightResponse();
        travixFlightResponse.setAirline(tjResponse.getCarrier());
        travixFlightResponse.setArrivalDate(tjResponse.getOutboundDateTime());
        travixFlightResponse.setDepartureAirportCode(tjResponse.getDepartureAirportName());
        travixFlightResponse.setDestinationAirportCode(tjResponse.getArrivalAirportName());
        double price = tjResponse.getBasePrice() * tjResponse.getDiscount() + tjResponse.getTax();
        travixFlightResponse.setPrice(price);

        return travixFlightResponse;


    }

    public static ToughJetRequest mapToughAirRequest(TravixFlightRequest request) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(request.getOrigin());
        toughJetRequest.setInboundDate(request.getDepartureDate());
        toughJetRequest.setNumberOfAdults(request.getPassengerCount());
        toughJetRequest.setTo(request.getDestination());
        toughJetRequest.setOutboundDate(request.getReturnDate());

        return toughJetRequest;
    }

}
