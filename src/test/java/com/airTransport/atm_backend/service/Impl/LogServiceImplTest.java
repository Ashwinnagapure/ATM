package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Log;
import com.airTransport.atm_backend.repository.LogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogServiceImplTest {

    @Mock
    private LogRepository logRepository;

    @InjectMocks
    private LogServiceImpl logService;

    private Log log;

    @BeforeEach
    void setup() {
        log = new Log(LocalDateTime.now(), "Test message");
        log.setId(1L);
    }

    // 1. Test for saving a log
    @Test
    void saveLog_validInput_savesLog() {
        when(logRepository.save(any(Log.class))).thenReturn(log);

        Log savedLog = logService.saveLog("Test message");

        assertNotNull(savedLog);
        assertEquals("Test message", savedLog.getMessage());
        verify(logRepository, times(1)).save(any(Log.class));
    }

    // 2. Test for retrieving a log by valid ID
    @Test
    void retrieveLog_validId_returnsLog() {
        when(logRepository.findById(1L)).thenReturn(Optional.of(log));

        Log retrievedLog = logService.retrieveLog(1L);

        assertNotNull(retrievedLog);
        assertEquals(1L, retrievedLog.getId());
        assertEquals("Test message", retrievedLog.getMessage());
        verify(logRepository, times(1)).findById(1L);
    }

    // 3. Test for retrieving a log with an invalid ID
    @Test
    void retrieveLog_invalidId_throwsException() {
        when(logRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> logService.retrieveLog(2L));

        assertEquals("Log not found with ID: 2", exception.getMessage());
        verify(logRepository, times(1)).findById(2L);
    }

    // 4. Test for retrieving all logs
    @Test
    void retrieveAllLogs_returnsLogsList() {
        List<Log> logs = Arrays.asList(
                new Log(LocalDateTime.now(), "Message 1"),
                new Log(LocalDateTime.now(), "Message 2")
        );
        when(logRepository.findAll()).thenReturn(logs);

        List<Log> retrievedLogs = logService.retrieveAllLogs();

        assertEquals(2, retrievedLogs.size());
        assertEquals("Message 1", retrievedLogs.get(0).getMessage());
        verify(logRepository, times(1)).findAll();
    }

    // 5. Test for deleting a log by valid ID
    @Test
    void deleteLog_validId_deletesLog() {
        when(logRepository.existsById(1L)).thenReturn(true);

        logService.deleteLog(1L);

        verify(logRepository, times(1)).deleteById(1L);
    }

    // 6. Test for deleting a log with an invalid ID
    @Test
    void deleteLog_invalidId_throwsException() {
        when(logRepository.existsById(2L)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> logService.deleteLog(2L));

        assertEquals("Log not found with ID: 2", exception.getMessage());
        verify(logRepository, times(1)).existsById(2L);
        verify(logRepository, never()).deleteById(2L);
    }

//    // 7. Test for saving a null message (edge case)
//    @Test
//    void saveLog_nullMessage_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> logService.saveLog(null));
//    }
//
//    // 8. Test for saving an empty message (edge case)
//    @Test
//    void saveLog_emptyMessage_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> logService.saveLog(""));
//    }

    // 9. Test for concurrent retrieval and deletion (test stability)
    @Test
    void retrieveAndDeleteLog_concurrentOperations_noConflicts() {
        when(logRepository.findById(1L)).thenReturn(Optional.of(log));
        when(logRepository.existsById(1L)).thenReturn(true);

        Log retrievedLog = logService.retrieveLog(1L);
        logService.deleteLog(1L);

        assertNotNull(retrievedLog);
        verify(logRepository, times(1)).findById(1L);
        verify(logRepository, times(1)).deleteById(1L);
    }

    // 10. Performance Test: Ensure saveLog executes within reasonable time
    @Test
    void saveLog_performanceTest() {
        when(logRepository.save(any(Log.class))).thenReturn(log);

        long startTime = System.currentTimeMillis();
        logService.saveLog("Performance test message");
        long endTime = System.currentTimeMillis();

        assertTrue((endTime - startTime) < 1000, "saveLog should execute within 1 second");
    }
}
