package com.airTransport.atm_backend.model;
import java.util.List;

public class Admin extends User implements Log,CrewManagement,FlightManagemnt,UserManagement {

    private long adminId ;

    private Flight flight;
    private EmergencyAlert emergencyAlert;
    private Notification notification;

    @Override
    public List<String> pilot() {
        return List.of();
    }

    @Override
    public List<String> cabinCrew() {
        return List.of();
    }

    @Override
    public List<String> groundStaff() {
        return List.of();
    }

    @Override
    public Enum trackFlightStatus() {
        return null;
    }

    @Override
    public boolean scheduleFlights() {
        return false;
    }

    @Override
    public boolean cancelFlights() {
        return false;
    }

    @Override
    public Boolean saveLog(String params) {
        return null;
    }

    @Override
    public String retrieveLog(String params) {
        return "";
    }

    @Override
    public Boolean deleteUserAccount(String paramas) {
        return null;
    }

    @Override
    public boolean createUserAccount(String params) {
        return false;
    }

    @Override
    public boolean deactivateUserAccount(String params) {
        return false;
    }

    @Override
    public List<String> getallUsers() {
        return List.of();
    }
}
