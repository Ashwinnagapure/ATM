package com.airTransport.atm_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "travel_preferences")  // Specifies the table name in the database
public class TravelPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key
    private Long travelPreferenceId;

    @Column(nullable = false)
    private Long passengerId;

    @Enumerated(EnumType.STRING)  // Enum will be stored as a string
    private TravelClass travelClass; // Preferred travel class

    @Enumerated(EnumType.STRING)
    private MealPreference mealPreference; // Meal preferences

    @Enumerated(EnumType.STRING)
    private AirlinePreference airlinePreference; // Enum for flight-related preferences

    @Enumerated(EnumType.STRING)
    private DepartureTime departureTime;

    @Enumerated(EnumType.STRING)
    private ArrivalTime arrivalTime;

    // Constructors
    public TravelPreferences() {
    }

    public TravelPreferences(Long passengerId, TravelClass travelClass, MealPreference mealPreference, AirlinePreference airlinePreference, DepartureTime departureTime, ArrivalTime arrivalTime) {
        this.passengerId = passengerId;
        this.travelClass = travelClass;
        this.mealPreference = mealPreference;
        this.airlinePreference = airlinePreference;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters and Setters
    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getTravelPreferenceId() {
        return travelPreferenceId;
    }

    public void setTravelPreferenceId(Long travelPreferenceId) {
        this.travelPreferenceId = travelPreferenceId;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public MealPreference getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(MealPreference mealPreference) {
        this.mealPreference = mealPreference;
    }

    public AirlinePreference getAirlinePreference() {
        return airlinePreference;
    }

    public void setAirlinePreference(AirlinePreference airlinePreference) {
        this.airlinePreference = airlinePreference;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    // Enums for Travel Preferences
    public enum TravelClass {
        ECONOMY,
        PREMIUM_ECONOMY,
        BUSINESS,
        FIRST_CLASS
    }

    public enum MealPreference {
        VEGETARIAN,
        NON_VEGETARIAN,
        VEGAN,
        GLUTEN_FREE,
        DIABETIC,
        LOW_SODIUM
    }

    public enum AirlinePreference {
        AIR_INDIA,
        INDIGO,
        SPICEJET,
        EMIRATES,
        QATAR_AIRWAYS
    }

    public enum DepartureTime {
        MORNING,
        AFTERNOON,
        EVENING,
        NIGHT
    }

    public enum ArrivalTime {
        MORNING,
        AFTERNOON,
        EVENING,
        NIGHT
    }
}
