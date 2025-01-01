package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.File;

@Entity
@Data

public class BoardingPass {

    public Long getBoardingPassId() {
        return boardingPassId;
    }

    public void setBoardingPassId(Long boardingPassId) {
        this.boardingPassId = boardingPassId;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getBoardingDate() {
        return boardingDate;
    }

    public void setBoardingDate(String boardingDate) {
        this.boardingDate = boardingDate;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardingPassId;

    private String boardingTime;
    private String boardingDate;
    private String boardingGate;
    private String seat;

    public File downloadBoardingPass(String params) {
        // Implementation logic for downloading boarding pass
        return null;
    }

    public void showBoardingDetails(String params) {
        // Implementation logic for showing boarding details
    }
}
