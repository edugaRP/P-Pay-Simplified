package com.simBank.service;

import com.simBank.domain.user.User;
import com.simBank.controller.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

//        ResponseEntity<String> response = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify)", notificationRequest, String.class);
//
//        if (!(response.getStatusCode() == HttpStatus.OK)){
//            System.out.println("error sending notification");
//            throw new Exception("Notification Service Error");
//        }

        System.out.println("Notification sent");
    }
}