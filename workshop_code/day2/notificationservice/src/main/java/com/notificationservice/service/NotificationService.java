package com.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.productapp.dto.OrderPlacedEvent;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Service

public class NotificationService {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
    @KafkaListener(topics = "order-placed", groupId = "notification-service")
    public void sendNotification(OrderPlacedEvent orderPlacedEvent) {
    	System.out.println("------------------------------");
        System.out.println(orderPlacedEvent);
        logger.info("Sending notification to customer {} for order {}",
                orderPlacedEvent.getEmail());
    }
}
	