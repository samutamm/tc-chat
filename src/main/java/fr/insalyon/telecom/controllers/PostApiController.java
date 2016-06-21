package fr.insalyon.telecom.controllers;

import fr.insalyon.telecom.model.Post;
import fr.insalyon.telecom.services.RedisMessageBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostApiController {

    @Autowired
    private RedisMessageBoard messageBoard;

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public List<Post> shareMessages() {
        return messageBoard.getPosts();
    }
}
