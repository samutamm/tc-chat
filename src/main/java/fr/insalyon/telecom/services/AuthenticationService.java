package fr.insalyon.telecom.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationService {

    @Value("${authServiceUrl}")
    private String authServiceUrl;

    public boolean authenticate(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();
        AuthenticationResponse response = restTemplate.postForObject(
                authServiceUrl,
                new AuthenticationRequest(login, password),
                AuthenticationResponse.class);
        return response.isSuccess();
    }
}