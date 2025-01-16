package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CrewManagementRepositoryTest {

    @Autowired
    private CrewManagementRepository crewRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void testFindByRole() {
        Admin admin = new Admin();
        admin.setName("Admin Test");
        admin.setEmail("admin@test.com");
        admin.setPassword("password123");
        adminRepository.save(admin);

        CrewManagement crewMember = new CrewManagement();
        crewMember.setName("John Doe");
        crewMember.setRole(Role.PILOT);
        crewMember.setAvailability(true);
        crewMember.setAdmin(admin);
        crewRepository.save(crewMember);

        List<CrewManagement> crewList = crewRepository.findByRole(Role.PILOT);
        assertEquals(1, crewList.size());
        assertEquals("John Doe", crewList.get(0).getName());
    }

    @Test
    void testFindByAvailability() {
        Admin admin = new Admin();
        admin.setName("Admin Test");
        admin.setEmail("admin@test.com");
        admin.setPassword("password123");
        adminRepository.save(admin);

        CrewManagement crewMember = new CrewManagement();
        crewMember.setName("Jane Doe");
        crewMember.setRole(Role.CABIN_CREW);
        crewMember.setAvailability(true);
        crewMember.setAdmin(admin);
        crewRepository.save(crewMember);

        List<CrewManagement> availableCrew = crewRepository.findByAvailability(true);
        assertEquals(1, availableCrew.size());
        assertTrue(availableCrew.get(0).isAvailability());
        assertEquals("Jane Doe", availableCrew.get(0).getName());
    }

    @Test
    void testFindByAdminId() {
        Admin admin = new Admin();
        admin.setName("Admin Test");
        admin.setEmail("admin@test.com");
        admin.setPassword("password123");
        adminRepository.save(admin);

        CrewManagement crewMember = new CrewManagement();
        crewMember.setName("John Smith");
        crewMember.setRole(Role.PILOT);
        crewMember.setAvailability(false);
        crewMember.setAdmin(admin);
        crewRepository.save(crewMember);

        List<CrewManagement> crewByAdmin = crewRepository.findByAdmin_Id(admin.getId());
        assertEquals(1, crewByAdmin.size());
        assertEquals("John Smith", crewByAdmin.get(0).getName());
        assertEquals(Role.PILOT, crewByAdmin.get(0).getRole());
    }

    @Test
    void testFindAll() {
        Admin admin = new Admin();
        admin.setName("Admin Test");
        admin.setEmail("admin@test.com");
        admin.setPassword("password123");
        adminRepository.save(admin);

        CrewManagement crew1 = new CrewManagement();
        crew1.setName("Alice Brown");
        crew1.setRole(Role.PILOT);
        crew1.setAvailability(true);
        crew1.setAdmin(admin);
        crewRepository.save(crew1);

        CrewManagement crew2 = new CrewManagement();
        crew2.setName("Bob White");
        crew2.setRole(Role.CABIN_CREW);
        crew2.setAvailability(false);
        crew2.setAdmin(admin);
        crewRepository.save(crew2);

        List<CrewManagement> allCrew = crewRepository.findAll();
        assertEquals(2, allCrew.size());
    }
}