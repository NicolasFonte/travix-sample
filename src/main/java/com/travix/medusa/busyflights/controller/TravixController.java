package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.travix.TravixFlightResponse;
import com.travix.medusa.busyflights.domain.travix.TravixFlightRequest;
import com.travix.medusa.busyflights.exception.ClientException;
import com.travix.medusa.busyflights.exception.TravixApiException;
import com.travix.medusa.busyflights.service.TravixService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/flights")
public class TravixController {

    private final TravixService travixService;

    public TravixController(TravixService travixService) {
        this.travixService = travixService;
    }

    @GetMapping("/filter")
    public List<TravixFlightResponse> aggregateFlights(
            @RequestParam String origin,
            @RequestParam String departureDate,
            @RequestParam String destination,
            @RequestParam String returnDate,
            @RequestParam int passengerCount)
            throws TravixApiException {
        try {
            TravixFlightRequest flightRequest = TravixFlightRequest.builder()
                    .departureDate(departureDate)
                    .destination(destination)
                    .origin(origin)
                    .passengerCount(passengerCount)
                    .returnDate(returnDate)
                    .build();
            return travixService.aggregateFlights(flightRequest);
        } catch (ClientException e) {
            throw new TravixApiException("Error in aggregate flights");
        }
    }

}
