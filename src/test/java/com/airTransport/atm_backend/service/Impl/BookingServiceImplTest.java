/*
package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.enums.VehicleType;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.CharterRepository;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.service.Impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private CharterRepository charterRepository;

    private Passenger passenger;
    private Flight flight;
    private Charter charter;
    private Booking booking;
    private BookingDTO bookingDTO;

    @BeforeEach
    void setUp() {


        passenger = new Passenger();
        passenger.setId(1L);
        passenger.setUsername("JohnDoe");

        flight = new Flight();
        flight.setFlightId(1L);
        flight.setFlightName("Flight-101");

        charter = new Charter();
        charter.setCharterId(1L);
        charter.setVehicleType(VehicleType.HELICOPTER);

        booking = new Booking();
        booking.setId(1L);
        booking.setPassenger(passenger);
        booking.setFlight(flight);
        booking.setBookingDate(LocalDate.now().atStartOfDay());
        booking.setTravelDate(LocalDate.now().plusDays(7).atStartOfDay());
        booking.setStatus("PENDING");

        bookingDTO = new BookingDTO(
                booking.getId(),
                passenger.getUsername(),
                flight.getFlightName(),
                booking.getBookingDate(),
                booking.getTravelDate(),
                booking.getStatus()
        );
    }

    @Test
    void getAllBookings_ShouldReturnBookingList() {
        when(bookingRepository.findAll()).thenReturn(List.of(booking));

        List<BookingDTO> result = bookingService.getAllBookings();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Flight-101", result.get(0).getFlightName());
        verify(bookingRepository, times(1)).findAll();
    }

//    @Test
//    void getAllBookings_ShouldReturnNull_WhenBookingDoesNotExist() {
//        when(bookingRepository.findAll()).thenReturn(List.of());
//
//        List<BookingDTO> result = bookingService.getAllBookings();
//
//        assertNull(result);
//        verify(bookingRepository, times(1)).findAll();
//    }
//
//    @Test
//    void getAllBookings_ShouldHandleNullOptionalGracefully() {
//        when(bookingRepository.findAll()).thenReturn(null); // Simulating unexpected null from repository.
//
//        Exception exception = assertThrows(NullPointerException.class,
//                () -> bookingService.getAllBookings());
//
//        assertEquals("Booking not found", exception.getMessage());
//        verify(bookingRepository, times(1)).findById(1L);
//    }

    @Test
    void getBookingById_ShouldReturnBooking_WhenBookingExists() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        BookingDTO result = bookingService.getBookingById(1L);

        assertNotNull(result);
        assertEquals("JohnDoe", result.getPassengerName());
        verify(bookingRepository, times(1)).findById(1L);
    }

    @Test
    void getBookingById_ShouldReturnNull_WhenBookingDoesNotExist() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        BookingDTO result = bookingService.getBookingById(1L);

        assertNull(result);
        verify(bookingRepository, times(1)).findById(1L);
    }

//    @Test
//    void getBookingById_ShouldHandleNullOptionalGracefully() {
//        when(bookingRepository.findById(1L)).thenReturn(null); // Simulating unexpected null from repository.
//
//        Exception exception = assertThrows(NullPointerException.class,
//                () -> bookingService.getBookingById(1L));
//
//        assertEquals("Booking not found", exception.getMessage());
//        verify(bookingRepository, times(1)).findById(1L);
//    }

    @Test
    void createBooking_ShouldSaveBooking_WhenValidInput() {
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        BookingDTO result = bookingService.createBooking(bookingDTO, 1L, 1L);

        assertNotNull(result);
        assertEquals("PENDING", result.getStatus());
        verify(passengerRepository, times(1)).findById(1L);
        verify(flightRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void createBooking_ShouldThrowException_WhenPassengerNotFound() {
        when(passengerRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class,
                () -> bookingService.createBooking(bookingDTO, 1L, 1L));

        assertEquals("Passenger not found", exception.getMessage());
        verify(passengerRepository, times(1)).findById(1L);
    }

    @Test
    void createBooking_ShouldThrowException_WhenFlightNotFound() {
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
        when(flightRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class,
                () -> bookingService.createBooking(bookingDTO, 1L, 1L));

        assertEquals("Flight not found", exception.getMessage());
        verify(passengerRepository, times(1)).findById(1L);
        verify(flightRepository, times(1)).findById(1L);
    }

//    @Test
//    void createBooking_ShouldThrowException_WhenTravelDateIsBeforeBookingDate() {
//        bookingDTO.setTravelDate(bookingDTO.getBookingDate().minusDays(1));
//
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createBooking(bookingDTO, 1L, 1L));
//
//        assertEquals("Travel date cannot be before booking date", exception.getMessage());
//        verify(passengerRepository, never()).findById(anyLong());
//        verify(flightRepository, never()).findById(anyLong());
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
//    @Test
//    void createBooking_ShouldThrowException_WhenBookingDateIsNull() {
//        bookingDTO.setBookingDate(null);
//
//        Exception exception = assertThrows(NullPointerException.class,
//                () -> bookingService.createBooking(bookingDTO, 1L, 1L));
//
//        assertEquals("Booking date cannot be null", exception.getMessage());
//        verify(passengerRepository, never()).findById(anyLong());
//        verify(flightRepository, never()).findById(anyLong());
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
//
//    @Test
//    void createBooking_ShouldThrowException_WhenBookingDateIsInPast() {
//        // Arrange
//        bookingDTO.setBookingDate(LocalDate.now().minusDays(1).atStartOfDay());
//        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
//        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
//
//        // Act & Assert
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createBooking(bookingDTO, 1L, 1L));
//        assertEquals("Booking date cannot be in the past", exception.getMessage());
//        verify(passengerRepository, times(1)).findById(1L);
//        verify(flightRepository, times(1)).findById(1L);
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
//    @Test
//    void createBooking_ShouldThrowException_WhenPassengerIdIsNull() {
//        // Act & Assert
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createBooking(bookingDTO, null, 1L));
//        assertEquals("Passenger ID cannot be null", exception.getMessage());
//        verify(passengerRepository, never()).findById(anyLong());
//        verify(flightRepository, never()).findById(anyLong());
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
//
//    @Test
//    void createBooking_ShouldThrowException_WhenFlightIdIsNull() {
//        // Act & Assert
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createBooking(bookingDTO, 1L, null));
//        assertEquals("Flight ID cannot be null", exception.getMessage());
//        verify(passengerRepository, never()).findById(anyLong());
//        verify(flightRepository, never()).findById(anyLong());
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
//



//    @Test
//    void createCharterBooking_ShouldSaveCharterBooking_WhenValidInput() {
//        // Arrange
//        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
//        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));
//        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
//
//        // Act
//        BookingDTO result = bookingService.createCharterBooking(bookingDTO, 1L, 1L);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("PENDING", result.getStatus());
//        assertEquals("Charter-101", result.getFlightName());
//        verify(passengerRepository, times(1)).findById(1L);
//        verify(charterRepository, times(1)).findById(1L);
//        verify(bookingRepository, times(1)).save(any(Booking.class));
//    }
//
//    @Test
//    void createCharterBooking_ShouldThrowException_WhenTravelDateIsNull() {
//        // Arrange
//        bookingDTO.setTravelDate(null);
//        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
//        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));
//
//        // Act & Assert
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createCharterBooking(bookingDTO, 1L, 1L));
//        assertEquals("Travel date cannot be null", exception.getMessage());
//        verify(passengerRepository, times(1)).findById(1L);
//        verify(charterRepository, times(1)).findById(1L);
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }
    @Test
    void createCharterBooking_ShouldThrowException_WhenPassengerNotFound() {
        // Arrange
        when(passengerRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class,
                () -> bookingService.createCharterBooking(bookingDTO, 1L, 1L));
        assertEquals("Passenger not found", exception.getMessage());
        verify(passengerRepository, times(1)).findById(1L);
        verify(charterRepository, never()).findById(anyLong());
        verify(bookingRepository, never()).save(any(Booking.class));
    }

    @Test
    void createCharterBooking_ShouldThrowException_WhenCharterNotFound() {
        // Arrange
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
        when(charterRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class,
                () -> bookingService.createCharterBooking(bookingDTO, 1L, 1L));
        assertEquals("Charter not found", exception.getMessage());
        verify(passengerRepository, times(1)).findById(1L);
        verify(charterRepository, times(1)).findById(1L);
        verify(bookingRepository, never()).save(any(Booking.class));
    }

//    @Test
//    void createCharterBooking_ShouldThrowException_WhenTravelDateIsTooFarInFuture() {
//        bookingDTO.setTravelDate(LocalDate.now().plusYears(10).atStartOfDay());
//
//        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));
//        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));
//
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> bookingService.createCharterBooking(bookingDTO, 1L, 1L));
//
//        assertEquals("Travel date cannot be more than 5 years in the future", exception.getMessage());
//        verify(passengerRepository, times(1)).findById(1L);
//        verify(charterRepository, times(1)).findById(1L);
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }


    @Test
    void confirmBooking_ShouldUpdateStatus_WhenBookingExists() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        boolean result = bookingService.confirmBooking(1L);

        assertTrue(result);
        assertEquals("CONFIRMED", booking.getStatus());
        verify(bookingRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void confirmBooking_ShouldReturnFalse_WhenBookingDoesNotExist() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        boolean result = bookingService.confirmBooking(1L);

        assertFalse(result);
        verify(bookingRepository, times(1)).findById(1L);
        verify(bookingRepository, never()).save(any(Booking.class));
    }
//    @Test
//    void confirmBooking_ShouldNotUpdateStatus_WhenBookingIsAlreadyConfirmed() {
//        booking.setStatus("CONFIRMED");
//
//        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
//
//        boolean result = bookingService.confirmBooking(1L);
//
//        assertFalse(result);
//        assertEquals("CONFIRMED", booking.getStatus());
//        verify(bookingRepository, times(1)).findById(1L);
//        verify(bookingRepository, never()).save(any(Booking.class));
//    }

    @Test
    void deleteBooking_ShouldDeleteBooking_WhenBookingExists() {
        when(bookingRepository.existsById(1L)).thenReturn(true);

        boolean result = bookingService.deleteBooking(1L);

        assertTrue(result);
        verify(bookingRepository, times(1)).existsById(1L);
        verify(bookingRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteBooking_ShouldReturnFalse_WhenBookingDoesNotExist() {
        when(bookingRepository.existsById(1L)).thenReturn(false);

        boolean result = bookingService.deleteBooking(1L);

        assertFalse(result);
        verify(bookingRepository, times(1)).existsById(1L);
        verify(bookingRepository, never()).deleteById(1L);
    }
    @Test
    void deleteBooking_ShouldThrowException_WhenDeletionFailsUnexpectedly() {
        when(bookingRepository.existsById(1L)).thenReturn(true);
        doThrow(new RuntimeException("Database error during deletion"))
                .when(bookingRepository).deleteById(1L);

        Exception exception = assertThrows(RuntimeException.class,
                () -> bookingService.deleteBooking(1L));

        assertEquals("Database error during deletion", exception.getMessage());
        verify(bookingRepository, times(1)).existsById(1L);
        verify(bookingRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteBooking_ShouldHandleConcurrentDeletion_WhenBookingDoesNotExist() {
        // Arrange
        when(bookingRepository.existsById(1L)).thenReturn(true).thenReturn(false);

        // Act
        boolean resultFirstAttempt = bookingService.deleteBooking(1L);
        boolean resultSecondAttempt = bookingService.deleteBooking(1L);

        // Assert
        assertTrue(resultFirstAttempt);
        assertFalse(resultSecondAttempt);
        verify(bookingRepository, times(2)).existsById(1L);
        verify(bookingRepository, times(1)).deleteById(1L);
    }
}

*/
