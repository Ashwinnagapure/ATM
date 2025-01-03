package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
