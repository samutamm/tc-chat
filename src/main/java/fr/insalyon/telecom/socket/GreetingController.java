package fr.insalyon.telecom.socket;

import fr.insalyon.telecom.services.AuthenticationRequest;
import fr.insalyon.telecom.services.AuthenticationResponse;
import fr.insalyon.telecom.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    private AuthenticationService authenticationService;

    @MessageMapping("/login")
    @SendTo("/topic/greetings")
    public AuthenticationResponse greeting(AuthenticationRequest auth) throws Exception {
        boolean authenticated = authenticationService.authenticate(auth.getLogin(), auth.getPassword());
        return new AuthenticationResponse(authenticated);
    }

}
