package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airTransport.atm_backend.model.Baggage;

import com.airTransport.atm_backend.repository.BaggageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaggageServiceImpl implements BaggageService {

    @Autowired
    private BaggageRepository baggageRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BaggageDTO> getBaggageByBookingId(Long bookingId) {
        return baggageRepository.findByBookingId(bookingId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BaggageDTO addBaggageToBooking(Long bookingId, BaggageDTO baggageDTO) {
        // Fetch the booking by ID
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        // Convert DTO to entity and set the booking
        Baggage baggage = convertToEntity(baggageDTO);
        baggage.setBooking(booking);

        // Save the baggage and return the DTO
        Baggage savedBaggage = baggageRepository.save(baggage);
        return convertToDTO(savedBaggage);
    }


    @Override
    public BaggageDTO updateBaggage(Long baggageId, BaggageDTO baggageDTO) {
        Baggage baggage = baggageRepository.findById(baggageId)
                .orElseThrow(() -> new RuntimeException("Baggage not found"));
        baggage.setWeight(baggageDTO.getWeight());
        baggage.setBagCount(baggageDTO.getBagCount());
        Baggage updatedBaggage = baggageRepository.save(baggage);
        return convertToDTO(updatedBaggage);
    }

    @Override
    public void deleteBaggage(Long baggageId) {
        baggageRepository.deleteById(baggageId);
    }

    private BaggageDTO convertToDTO(Baggage baggage) {
        BaggageDTO dto = new BaggageDTO();
        dto.setId(baggage.getId());
        dto.setWeight(baggage.getWeight());
        dto.setBagCount(baggage.getBagCount());
        dto.setBookingId(baggage.getBooking().getId()); // Use the booking's ID
        return dto;
    }


    private Baggage convertToEntity(BaggageDTO dto) {
        Baggage baggage = new Baggage();
        baggage.setId(dto.getId());
        baggage.setWeight(dto.getWeight());
        baggage.setBagCount(dto.getBagCount());
        // The booking is set separately in the addBaggageToBooking method
        return baggage;
    }

}
