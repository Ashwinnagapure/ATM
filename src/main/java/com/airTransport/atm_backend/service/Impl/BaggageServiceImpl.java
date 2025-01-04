package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.model.Baggage;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BaggageRepository;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BaggageServiceImpl implements BaggageService {

    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Existing methods...

    @Override
    @Transactional
    public boolean getBaggageLimit(Long baggageId) {
        Optional<Baggage> baggageOptional = baggageRepository.findById(baggageId);
        if (baggageOptional.isPresent()) {
            Baggage baggage = baggageOptional.get();

            // Return baggage limit status
            return baggage.getBaggageLimit();
        }
        return false;
    }


    @Override
    @Transactional
    public boolean reportLostBaggage(Long baggageId, String feedback) {
        Optional<Baggage> baggageOptional = baggageRepository.findById(baggageId);
        if (baggageOptional.isPresent()) {
            Baggage baggage = baggageOptional.get();
            baggage.setFeedback(feedback);
            baggageRepository.save(baggage);
            return true;
        }
        return false;
    }



    @Override
    @Transactional
    public BaggageDTO getBaggageById(Long baggageId) {
        Optional<Baggage> baggageOptional = baggageRepository.findById(baggageId);
        return baggageOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    @Transactional
    public List<BaggageDTO> getBaggageByBookingId(Long bookingId) {
        List<Baggage> baggages = baggageRepository.findByBookingId(bookingId);
        return baggages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    @Transactional
    @Override
    public BaggageDTO createBaggageFromParams(Long bookingId, boolean baggageLimit, double weight, int luggageCount) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        Baggage baggage = new Baggage();
        baggage.setBaggageLimit(baggageLimit);
        baggage.setWeight(weight);
        baggage.setLuggageCount(luggageCount);
        baggage.setBooking(booking);
        Baggage savedBaggage = baggageRepository.save(baggage);
        return convertToDTO(savedBaggage);
    }

    private BaggageDTO convertToDTO(Baggage baggage) {
        return new BaggageDTO(
                baggage.getBaggageId(),
                baggage.getBooking().getId(),
                baggage.getBaggageLimit(),
                baggage.getWeight(),
                baggage.getLuggageCount(),
                baggage.getFeedback() // Add the feedback field here
        );
    }

}
