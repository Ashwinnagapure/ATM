//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.CrewManagement;
//import com.airTransport.atm_backend.model.enums.Role;
//import com.airTransport.atm_backend.repository.CrewManagementRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class CrewManagementRepositoryTest {
//
//    @Autowired
//    private CrewManagementRepository crewRepository;
//
//    private CrewManagement crew;
//
//    @BeforeEach
//    void setUp() {
//        crew = new CrewManagement();
//        crew.setName("John Doe");
//        crew.setRole(Role.PILOT);
//        crew.setAvailability(true);
//    }
//
//    @Test
//    void testFindByRole() {
//        crewRepository.save(crew);
//
//        List<CrewManagement> crewList = crewRepository.findByRole(Role.PILOT);
//        assertFalse(crewList.isEmpty());
//        assertEquals("John Doe", crewList.get(0).getName());
//    }
//
//    @Test
//    void testFindByAvailability() {
//        crewRepository.save(crew);
//
//        List<CrewManagement> availableCrew = crewRepository.findByAvailability(true);
//        assertFalse(availableCrew.isEmpty());
//        assertEquals("John Doe", availableCrew.get(0).getName());
//    }
//}
