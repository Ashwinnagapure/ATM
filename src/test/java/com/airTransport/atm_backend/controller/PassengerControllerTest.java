/*
package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PassengerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private PassengerController passengerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(passengerController).build();
    }

 */
/*   @Test
    void addPassenger() throws Exception {
        Passenger passenger = new Passenger(1L, "John Doe", "john.doe@example.com");

        // Mock the addPassenger method to return a string
        when(passengerService.addPassenger(any(Passenger.class))).thenReturn("Passenger added successfully");

        // Perform POST request to add the passenger
        mockMvc.perform(post("/passenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Passenger added successfully"));

        // Verify the service method was called
        verify(passengerService, times(1)).addPassenger(any(Passenger.class));
    }
*//*



   */
/* @Test
    void getPassengerById() throws Exception {
        Passenger passenger = new Passenger(1L, "John Doe", "john.doe@example.com");

        // Mock the service to return the passenger
        when(passengerService.getPassengerById(1L)).thenReturn(passenger);

        // Perform the test for getting a passenger by ID
        mockMvc.perform(get("/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))  // Expect id to be 1
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));

        // Verify the service method was called once
        verify(passengerService, times(1)).getPassengerById(1L);
    }*//*


    @Test
    void getAllPassengers() throws Exception {
        List<Passenger> passengers = Arrays.asList(
                new Passenger(1L, "John Doe", "john.doe@example.com"),
                new Passenger(2L, "Jane Doe", "jane.doe@example.com")
        );

        // Mock the service to return a list of passengers
        when(passengerService.getAllPassengers()).thenReturn(passengers);

        // Perform the test for getting all passengers
        mockMvc.perform(get("/passenger"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].email").value("jane.doe@example.com"));

        // Verify the service method was called once
        verify(passengerService, times(1)).getAllPassengers();
    }

    @Test
    void updatePassenger() throws Exception {
        // Creating a passenger object to return after the update
        Passenger updatedPassenger = new Passenger(1L, "John Doe Updated", "john.updated@example.com");

        // Mock the service to simulate updating a passenger and return the updated passenger object
        when(passengerService.updatePassenger(any(Passenger.class))).thenReturn(updatedPassenger);

        // Perform the test for updating a passenger
        mockMvc.perform(put("/passenger")
                        .contentType(MediaType.APPLICATION_JSON)  // Ensure that the content type is set to JSON
                        .content("{\"id\":1,\"name\":\"John Doe Updated\",\"email\":\"john.updated@example.com\"}"))
                .andExpect(status().isOk())  // Expect status 200 OK
                .andExpect(jsonPath("$.id").value(1L))  // Check the updated ID
                .andExpect(jsonPath("$.name").value("John Doe Updated"))  // Check the updated name
                .andExpect(jsonPath("$.email").value("john.updated@example.com"));  // Check the updated email

        // Verify the service method was called once
        verify(passengerService, times(1)).updatePassenger(any(Passenger.class));
    }




    @Test
    void deletePassenger() throws Exception {
        // Mock the service to simulate deleting a passenger
        doNothing().when(passengerService).deletePassenger(1L); // This works only if it's a void method

        // Perform the test for deleting a passenger
        mockMvc.perform(delete("/passenger/1"))
                .andExpect(status().isOk())  // Expect status OK
                .andExpect(content().string("Passenger deleted successfully"));

        // Verify the service method was called once
        verify(passengerService, times(1)).deletePassenger(1L);
    }

}
*/
