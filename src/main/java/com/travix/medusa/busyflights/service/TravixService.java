package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.Supplier;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.travix.TravixFlightRequest;
import com.travix.medusa.busyflights.domain.travix.TravixFlightResponse;
import com.travix.medusa.busyflights.exception.ClientException;
import com.travix.medusa.busyflights.service.mapper.DataMapper;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class TravixService {

    private final ExternalApiClientService externalApiClientService;

    public TravixService(ExternalApiClientService externalApiClientService) {
        this.externalApiClientService = externalApiClientService;
    }

    public List<TravixFlightResponse> aggregateFlights(TravixFlightRequest request) throws ClientException {

        return Stream.of(Supplier.values())
                .map(supplier -> mapper(supplier, request))
                .flatMap(List::stream)
                .sorted(Comparator.comparing(TravixFlightResponse::getPrice))
                .collect(Collectors.toList());

    }

    private List<TravixFlightResponse> mapper(Supplier supplier, TravixFlightRequest request) {

        if (Supplier.CRAZYAIR == supplier) {
            CrazyAirRequest crazyAirRequest = DataMapper.mapCrazyAirRequest(request);
            List<CrazyAirResponse> crazyAirResponses = externalApiClientService.callCrazyAir(crazyAirRequest);
            return crazyAirResponses.stream()
                    .map(DataMapper::mapCrazyAirResponse)
                    .collect(Collectors.toList());
        }

        if (Supplier.TOUGHJET == supplier) {
            ToughJetRequest toughJetRequest = DataMapper.mapToughAirRequest(request);
            List<ToughJetResponse> toughJetResponses = externalApiClientService.callToughJet(toughJetRequest);
            return toughJetResponses.stream()
                    .map(DataMapper::mapToughJetResponse)
                    .collect(Collectors.toList());
        }

        throw new IllegalStateException("Invalid supplier");
    }

}
