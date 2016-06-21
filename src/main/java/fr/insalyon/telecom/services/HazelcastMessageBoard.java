package fr.insalyon.telecom.services;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import fr.insalyon.telecom.model.Post;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class HazelcastMessageBoard implements MessageBoard{

    @Value("@{hazelcastListID}")
    private String listID;
    private final HazelcastInstance instance;

    public HazelcastMessageBoard() {
        Config config = new Config();
        instance = Hazelcast.newHazelcastInstance(config);
    }

    public List<Post> getPosts() {
        return getList();
    }

    private IList<Post> getList() {
        return instance.getList("message-board");
    }

    public void post(Post post) {
        getList().add(0, post);
    }
}
