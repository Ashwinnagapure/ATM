/*
package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class FlightRepositoryTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightRepositoryTest flightRepositoryTest;

    private Admin admin;
    private Flight flight1, flight2, flight3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        admin = new Admin();
        admin.setId(1L);

        flight1 = new Flight();
        flight1.setFlightId(1L);
        flight1.setFlightName("Flight 1");
        flight1.setDeparture(LocalDateTime.now());
        flight1.setArrival(LocalDateTime.now().plusHours(2));
        flight1.setStatus(FlightStatus.ON_TIME);
        flight1.setSource("New York");
        flight1.setDestination("Los Angeles");
        flight1.setPrice(500.00);
        flight1.setAirline("Airline A");
        flight1.setFlightClass("Economy");
        flight1.setAdmin(admin);

        flight2 = new Flight();
        flight2.setFlightId(2L);
        flight2.setFlightName("Flight 2");
        flight2.setDeparture(LocalDateTime.now());
        flight2.setArrival(LocalDateTime.now().plusHours(3));
        flight2.setStatus(FlightStatus.DELAYED);
        flight2.setSource("Chicago");
        flight2.setDestination("San Francisco");
        flight2.setPrice(600.00);
        flight2.setAirline("Airline B");
        flight2.setFlightClass("Business");
        flight2.setAdmin(admin);

        flight3 = new Flight();
        flight3.setFlightId(3L);
        flight3.setFlightName("Flight 3");
        flight3.setDeparture(LocalDateTime.now());
        flight3.setArrival(LocalDateTime.now().plusHours(1));
        flight3.setStatus(FlightStatus.CANCELLED);
        flight3.setSource("Dallas");
        flight3.setDestination("Miami");
        flight3.setPrice(400.00);
        flight3.setAirline("Airline C");
        flight3.setFlightClass("First Class");
        flight3.setAdmin(admin);
    }

    @AfterEach
    void tearDown() {
        Mockito.clearInvocations(flightRepository);    }

    @Test
    void findAllByOrderByPriceAsc() {
        when(flightRepository.findAllByOrderByPriceAsc()).thenReturn(Arrays.asList(flight3, flight1, flight2));

        List<Flight> sortedFlights = flightRepository.findAllByOrderByPriceAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights.size()).isEqualTo(3);
        assertThat(sortedFlights.get(0).getPrice()).isEqualTo(400.00); // The lowest price
        assertThat(sortedFlights.get(1).getPrice()).isEqualTo(500.00);
        assertThat(sortedFlights.get(2).getPrice()).isEqualTo(600.00); // The highest price
    }

    @Test
    void findAllByOrderByPriceAsc_NoFlights() {
        when(flightRepository.findAllByOrderByPriceAsc()).thenReturn(Arrays.asList());

        List<Flight> sortedFlights = flightRepository.findAllByOrderByPriceAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights).isEmpty();
    }


    @Test
    void findAllByOrderByAirlineAsc() {
        when(flightRepository.findAllByOrderByAirlineAsc()).thenReturn(Arrays.asList(flight1, flight2, flight3));

        List<Flight> sortedFlights = flightRepository.findAllByOrderByAirlineAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights.size()).isEqualTo(3);
        assertThat(sortedFlights.get(0).getAirline()).isEqualTo("Airline A");
        assertThat(sortedFlights.get(1).getAirline()).isEqualTo("Airline B");
        assertThat(sortedFlights.get(2).getAirline()).isEqualTo("Airline C");
    }
    @Test
    void findAllByOrderByAirlineAsc_NoFlights() {
        when(flightRepository.findAllByOrderByAirlineAsc()).thenReturn(Arrays.asList());
        List<Flight> sortedFlights = flightRepository.findAllByOrderByAirlineAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights).isEmpty();
    }


    @Test
    void findAllByOrderByFlightClassAsc() {
        when(flightRepository.findAllByOrderByFlightClassAsc()).thenReturn(Arrays.asList(flight3, flight1, flight2));
        List<Flight> sortedFlights = flightRepository.findAllByOrderByFlightClassAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights.size()).isEqualTo(3);
        assertThat(sortedFlights.get(0).getFlightClass()).isEqualTo("First Class");
        assertThat(sortedFlights.get(1).getFlightClass()).isEqualTo("Economy");
        assertThat(sortedFlights.get(2).getFlightClass()).isEqualTo("Business");
    }

    @Test
    void findAllByOrderByFlightClassAsc_NoFlights() {
        when(flightRepository.findAllByOrderByFlightClassAsc()).thenReturn(Arrays.asList());
        List<Flight> sortedFlights = flightRepository.findAllByOrderByFlightClassAsc();
        assertThat(sortedFlights).isNotNull();
        assertThat(sortedFlights).isEmpty();
    }



}
*/
