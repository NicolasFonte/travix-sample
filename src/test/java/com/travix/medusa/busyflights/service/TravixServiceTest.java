package com.travix.medusa.busyflights.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.travix.TravixFlightRequest;
import com.travix.medusa.busyflights.domain.travix.TravixFlightResponse;
import com.travix.medusa.busyflights.exception.ClientException;
import com.travix.medusa.busyflights.util.SampleDataGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TravixServiceTest {

    private TravixService travixService;

    @Mock
    private ExternalApiClientService externalApiClientService;

    @Before
    public void setUp() {
        travixService = new TravixService(externalApiClientService);
    }

    @Test
    public void testFlightsCanBeAggregatedFromDifferentSuppliersAndSortedByPrice() throws ClientException {
        CrazyAirResponse cairResponse = SampleDataGenerator
                .createCrazyAirResponseSample("TAM", "30/01/2018", "11A", "GAL", "01/01/2018", "SPO", 100.0);
        CrazyAirResponse cairResponse2 = SampleDataGenerator
                .createCrazyAirResponseSample("TAM", "30/01/2018", "11A", "GAL", "01/01/2018", "SPO", 200.0);

        ToughJetResponse tjResponse1 = SampleDataGenerator
                .createToughResponseSample("TAM", "30/01/2018", "GAL", "01/01/2018", "SPO", 100.0, 0.1, 20.0);

        ToughJetResponse tjResponse2 = SampleDataGenerator
                .createToughResponseSample("TAM", "30/01/2018", "GAL", "01/01/2018", "SPO", 280.0, 0.2, 30.0);

        when(externalApiClientService.callCrazyAir(any()))
                .thenReturn(Arrays.asList(cairResponse, cairResponse2));
        when(externalApiClientService.callToughJet(any()))
                .thenReturn(Arrays.asList(tjResponse1, tjResponse2));

        List<TravixFlightResponse> travixFlightResponses = travixService.aggregateFlights(new TravixFlightRequest());

        assertThat(travixFlightResponses)
                .hasSize(4)
                .extracting("price")
                .containsExactly(30.0, 86.0, 100.0, 200.0);

    }
}