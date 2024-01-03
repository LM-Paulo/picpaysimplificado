package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.Users;
import com.picpaysimplificado.dto.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(Users users, String message) throws Exception{
        String email = users.getEmail();
        NotificationDto notificationRequest = new NotificationDto(email, message);

        //ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

        //if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
        //System.out.println("erro ao enviar notificacao");
        //throw new Exception("Serviço de notificação está fora do ar");
        //}

        System.out.println("Notificacao enviada para o o usuario");
    }
}
