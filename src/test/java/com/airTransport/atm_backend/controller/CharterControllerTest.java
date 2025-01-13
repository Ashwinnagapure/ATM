//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.model.Charter;
//import com.airTransport.atm_backend.service.CharterService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.http.HttpStatus.OK;
//
//
//class CharterControllerTest {
//
//    @Mock
//    private CharterService charterService;
//
//    @InjectMocks
//    private CharterController charterController;
//
//    @Test
//    void testAddCharter() {
//        Charter charter = new Charter();
//        charter.setId(1L);
//
//        when(charterService.addCharter(charter)).thenReturn(charter);
//
//        ResponseEntity<Charter> response = charterController.addCharter(charter);
//
//        assertEquals(OK, response.getStatusCode());
//        verify(charterService, times(1)).addCharter(charter);
//    }
//
//    @Test
//    void testGetCharterById() {
//        Charter charter = new Charter();
//        charter.setId(1L);
//
//        when(charterService.getCharterById(1L)).thenReturn(charter);
//
//        ResponseEntity<Charter> response = charterController.getCharterById(1L);
//
//        assertEquals(OK, response.getStatusCode());
//        assertEquals(1L, response.getBody().getId());
//    }
//
//    @Test
//    void testGetAllCharters() {
//        Charter charter1 = new Charter();
//        Charter charter2 = new Charter();
//
//        when(charterService.getAllCharters()).thenReturn(Arrays.asList(charter1, charter2));
//
//        ResponseEntity<List<Charter>> response = charterController.getAllCharters();
//
//        assertEquals(OK, response.getStatusCode());
//        assertEquals(2, response.getBody().size());
//    }
//
//    @Test
//    void testUpdateCharter() {
//        Charter updatedCharter = new Charter();
//        updatedCharter.setId(1L);
//
//        when(charterService.updateCharter(1L, updatedCharter)).thenReturn(updatedCharter);
//
//        ResponseEntity<Charter> response = charterController.updateCharter(1L, updatedCharter);
//
//        assertEquals(OK, response.getStatusCode());
//        assertEquals(1L, response.getBody().getId());
//    }
//
//    @Test
//    void testDeleteCharter() {
//        doNothing().when(charterService).deleteCharter(1L);
//
//        ResponseEntity<Void> response = charterController.deleteCharter(1L);
//
//        assertEquals(204, response.getStatusCodeValue());
//        verify(charterService, times(1)).deleteCharter(1L);
//    }
//}
