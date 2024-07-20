package com.example.notificationservice.service;

import com.example.notificationservice.events.BalanceChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @KafkaListener(topics = "balances", groupId = "notification-service")
    public void listenBalanceChange(BalanceChangeEvent event) {
        if (event.getNewBalance() < 100) {
            sendNotification(String.valueOf(event.getAccountId()), "Your balance is below 100 EUR.");
        }
    }

    private void sendNotification(String accountId, String message) {
        System.out.println("Notification sent to account " + accountId + ": " + message);
        logger.info("User with account Id :" + accountId + ": has a low balance with following message : " + message);
        //logger.info("User with account Id : %s has a low balance of %.2f EURO \n", accountId, "100.00");
        // Implementation of actual notification mechanism (e.g., email, SMS, push notification) goes here
    }
}
