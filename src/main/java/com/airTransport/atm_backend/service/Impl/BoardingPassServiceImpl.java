package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BoardingPassDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BoardingPassRepository;
import com.airTransport.atm_backend.repository.BookingRepository;  // Assuming you have a BookingRepository
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {

    @Autowired
    private BoardingPassRepository boardingPassRepository;

    @Autowired
    private BookingRepository bookingRepository;  // Inject the BookingRepository

    private BoardingPassDTO toDTO(BoardingPass boardingPass) {
        BoardingPassDTO boardingPassDTO = new BoardingPassDTO();
        boardingPassDTO.setId(boardingPass.getId());
        boardingPassDTO.setGate(boardingPass.getGate());
        boardingPassDTO.setSeatNumber(boardingPass.getSeatNumber());
        boardingPassDTO.setBookingId(boardingPass.getBooking().getId());  // Use only bookingId
        return boardingPassDTO;
    }

    private BoardingPass toEntity(BoardingPassDTO boardingPassDTO) {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setGate(boardingPassDTO.getGate());
        boardingPass.setSeatNumber(boardingPassDTO.getSeatNumber());

        // Fetch the Booking entity using bookingId
        Booking booking = bookingRepository.findById(boardingPassDTO.getBookingId())
                .orElseThrow(() -> new NotFoundException("Booking not found with ID: " + boardingPassDTO.getBookingId()));

        boardingPass.setBooking(booking);  // Set the booking entity in BoardingPass

        return boardingPass;
    }

    @Override
    public BoardingPassDTO generateBoardingPass(BoardingPassDTO boardingPassDTO) {
        BoardingPass boardingPass = toEntity(boardingPassDTO);
        boardingPass = boardingPassRepository.save(boardingPass);
        return toDTO(boardingPass);
    }

    @Override
    public BoardingPassDTO getBoardingPassById(Long id) {
        BoardingPass boardingPass = boardingPassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Boarding Pass not found with ID: " + id));
        return toDTO(boardingPass);
    }

    @Override
    public List<BoardingPassDTO> getAllBoardingPasses() {
        return boardingPassRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoardingPassDTO updateBoardingPass(Long id, BoardingPassDTO updatedBoardingPassDTO) {
        BoardingPass existingBoardingPass = boardingPassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Boarding Pass not found with ID: " + id));
        existingBoardingPass.setGate(updatedBoardingPassDTO.getGate());
        existingBoardingPass.setSeatNumber(updatedBoardingPassDTO.getSeatNumber());

        // Fetch the Booking entity and update it in the existing BoardingPass
        Booking booking = bookingRepository.findById(updatedBoardingPassDTO.getBookingId())
                .orElseThrow(() -> new NotFoundException("Booking not found with ID: " + updatedBoardingPassDTO.getBookingId()));

        existingBoardingPass.setBooking(booking);
        boardingPassRepository.save(existingBoardingPass);
        return toDTO(existingBoardingPass);
    }

    @Override
    public void deleteBoardingPass(Long id) {
        BoardingPass boardingPass = boardingPassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Boarding Pass not found with ID: " + id));
        boardingPassRepository.delete(boardingPass);
    }
}
