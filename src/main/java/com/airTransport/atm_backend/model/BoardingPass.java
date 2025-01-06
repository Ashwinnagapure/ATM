package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.File;

@Entity


public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardingPassId;

    private String boardingTime;
    private String boardingDate;
    private String boardingGate;
    private String seat;

    @OneToOne
    @JoinColumn(name = "paymentId",referencedColumnName = "paymentId",nullable = false)
    private Payment payment;

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

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public File downloadBoardingPass(String params) {
        // Implementation logic for downloading boarding pass
        return null;
    }

    public void showBoardingDetails(String params) {
        // Implementation logic for showing boarding details
    }
}
