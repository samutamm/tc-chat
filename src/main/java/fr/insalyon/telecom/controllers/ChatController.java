package fr.insalyon.telecom.controllers;

import fr.insalyon.telecom.model.Post;
import fr.insalyon.telecom.services.AuthenticationService;
import fr.insalyon.telecom.services.GistService;
import fr.insalyon.telecom.services.RedisMessageBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private RedisMessageBoard messageBoard;
    @Autowired
    private GistService gistService;


    @RequestMapping("/")
    public ModelAndView index(HttpSession session) {
        if (session.getAttribute("login") == null) {
            return new ModelAndView("login");
        }
        ModelAndView modelAndView = new ModelAndView("main")
                .addObject("posts", messageBoard.getPosts())
                .addObject("user", session.getAttribute("login"));
        Object message = session.getAttribute("message");
        if (message != null) {
            modelAndView.addObject("message", message);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            HttpSession session,
            @RequestParam("login") String login,
            @RequestParam("password") String password) {
        if (authenticationService.authenticate(login, password)) {
            session.setAttribute("login", login);
        }
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(HttpSession session, @RequestParam("message") String message) {
        String author = (String) session.getAttribute("login");
        messageBoard.post(new Post(author, message));
        return "redirect:/";
    }

    @RequestMapping(value = "/gists", method = RequestMethod.POST)
    public String sendGists(HttpSession session) {
        List<Post> posts = messageBoard.getPosts();
        if (posts != null && posts.size() > 1) {
            String message = gistService.sendPostsToGist(posts);
            session.setAttribute("message", message);
        }
        return "redirect:/";
    }
}
