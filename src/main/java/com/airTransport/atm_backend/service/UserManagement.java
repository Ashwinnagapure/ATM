package com.airTransport.atm_backend.service;
import java.util.List;

public interface UserManagement {
    public Boolean deleteUserAccount(String paramas);
    public boolean createUserAccount(String params);
    public boolean deactivateUserAccount(String params) ;
    public List<String> getallUsers();
}
