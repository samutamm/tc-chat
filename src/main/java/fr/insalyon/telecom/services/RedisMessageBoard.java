package fr.insalyon.telecom.services;

import fr.insalyon.telecom.model.Post;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RedisMessageBoard implements MessageBoard {

    private Jedis instance;
    private String listID = "message-board";

    public RedisMessageBoard() {
        instance = new Jedis("localhost");
    }

    @Override
    public List<Post> getPosts() {
        List<String> list = instance.lrange(listID, 0 ,20);
        return list.stream().map((post) -> {
            return new Post(post.split(":")[0], post.split(":")[1]);
        }).collect(Collectors.toList());
    }

    @Override
    public void post(Post post) {
        instance.lpush(listID, post.getAuthor() + ":" + post.getMessage());
    }
}
