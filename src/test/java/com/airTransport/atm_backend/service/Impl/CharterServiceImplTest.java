package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.repository.CharterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharterServiceImplTest {

    @Mock
    private CharterRepository charterRepository;

    @InjectMocks
    private CharterServiceImpl charterService;

    @Test
    void testAddCharter() {
        Charter charter = new Charter();
        charter.setId(1L);
        charter.setVehicleType("Private Jet");
        charter.setPrice(5000.0);

        when(charterRepository.save(charter)).thenReturn(charter);

        Charter result = charterService.addCharter(charter);

        assertNotNull(result);
        assertEquals("Private Jet", result.getVehicleType());
        verify(charterRepository, times(1)).save(charter);
    }

    @Test
    void testGetCharterById_Found() {
        Charter charter = new Charter();
        charter.setId(1L);

        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));

        Charter result = charterService.getCharterById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGetCharterById_NotFound() {
        when(charterRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> charterService.getCharterById(1L));
    }

    @Test
    void testGetAllCharters() {
        Charter charter1 = new Charter();
        Charter charter2 = new Charter();

        when(charterRepository.findAll()).thenReturn(Arrays.asList(charter1, charter2));

        assertEquals(2, charterService.getAllCharters().size());
        verify(charterRepository, times(1)).findAll();
    }

    @Test
    void testUpdateCharter() {
        Charter existingCharter = new Charter();
        existingCharter.setId(1L);
        existingCharter.setVehicleType("Private Jet");

        Charter updatedCharter = new Charter();
        updatedCharter.setVehicleType("Helicopter");

        when(charterRepository.findById(1L)).thenReturn(Optional.of(existingCharter));
        when(charterRepository.save(existingCharter)).thenReturn(existingCharter);

        Charter result = charterService.updateCharter(1L, updatedCharter);

        assertEquals("Helicopter", result.getVehicleType());
    }

    @Test
    void testDeleteCharter() {
        Charter charter = new Charter();
        charter.setId(1L);

        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));

        charterService.deleteCharter(1L);

        verify(charterRepository, times(1)).delete(charter);
    }
}
