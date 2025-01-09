package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Baggage;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BaggageRepository;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaggageServiceImpl implements BaggageService {

    private final BaggageRepository baggageRepository;
    private final BookingRepository bookingRepository;

    public BaggageServiceImpl(BaggageRepository baggageRepository, BookingRepository bookingRepository) {
        this.baggageRepository = baggageRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Baggage> getBaggageByBookingId(Long bookingId) {
        return baggageRepository.findByBookingId(bookingId);
    }

    @Override
    public Baggage addBaggageToBooking(Long bookingId, Baggage baggage) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        baggage.setBooking(booking); // Associate baggage with the booking
        return baggageRepository.save(baggage);
    }

    @Override
    public Baggage updateBaggage(Long baggageId, Baggage baggageDetails) {
        Baggage existingBaggage = baggageRepository.findById(baggageId)
                .orElseThrow(() -> new RuntimeException("Baggage not found with ID: " + baggageId));

        existingBaggage.setWeight(baggageDetails.getWeight());
        existingBaggage.setIsOverweight(baggageDetails.getIsOverweight());

        return baggageRepository.save(existingBaggage);
    }

    @Override
    public void deleteBaggage(Long baggageId) {
        baggageRepository.deleteById(baggageId);
    }
}
