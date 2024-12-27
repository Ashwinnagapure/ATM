package com.airTransport.atm_backend.model;

public abstract class User {
    protected long userId;
    protected String name;
    protected String email;
    protected String password;
    protected Enum userType;

    public boolean signUp(String params) {
        // Implementation
        return true;
    }

    public boolean login(String params) {
        // Implementation
        return true;
    }

    public boolean logout(String params) {
        // Implementation
        return true;
    }

    public boolean changePassword(String oldPass, String newPass) {
        // Implementation
        return true;
    }

    public boolean updateProfile(String params) {
        // Implementation
        return true;
    }

    public boolean resetPassword(String params) {
        // Implementation
        return true;
    }
}
