package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.SampleDataGenerator;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * This service would query the API using restTemplate or retrofit API.
 * For the exercise just return hardcoded values.
 */
@Service
public class ExternalApiClientService {

    private RestTemplate restTemplate;

    public List<CrazyAirResponse> callCrazyAir(CrazyAirRequest crazyAirRequest) {
        CrazyAirResponse crazyAirResponse1 = SampleDataGenerator.createCrazyAirResponseSample("Airline1", "30/01/2018", "CabinClass1",
                "dairport1",
                "01/01/2018", "destAir1", 300.0);
        CrazyAirResponse crazyAirResponse2 = SampleDataGenerator.createCrazyAirResponseSample("Airline2", "30/01/2018", "CabinClass2",
                "dairport2",
                "01/01/2018", "destAir2", 200.0);
        CrazyAirResponse crazyAirResponse3 = SampleDataGenerator.createCrazyAirResponseSample("Airline3", "30/01/2018", "CabinClass3",
                "dairport3",
                "01/01/2018", "destAir3", 300.0);

        return Arrays.asList(crazyAirResponse1, crazyAirResponse2, crazyAirResponse3);
    }

    public List<ToughJetResponse> callToughJet(ToughJetRequest toughJetRequest) {
        ToughJetResponse toughResponseSample1 = SampleDataGenerator.createToughResponseSample(
                "Airline1", "30/01/2018", "dairport1", "01/01/2018", "destAir1", 100.0, 0.1, 20.0);
        ToughJetResponse toughResponseSample2 = SampleDataGenerator.createToughResponseSample(
                "Airline1", "30/01/2018", "dairport1", "01/01/2018", "destAir1", 200.0, 0.2, 30.0);
        ToughJetResponse toughResponseSample3 = SampleDataGenerator.createToughResponseSample(
                "Airline1", "30/01/2018", "dairport1", "01/01/2018", "destAir1", 300.0, 0.1, 10.0);

        return Arrays.asList(toughResponseSample1, toughResponseSample2, toughResponseSample3);
    }
}
