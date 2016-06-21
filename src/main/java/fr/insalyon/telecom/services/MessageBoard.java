package fr.insalyon.telecom.services;

import fr.insalyon.telecom.model.Post;

import java.util.List;

public interface MessageBoard {

    public List<Post> getPosts();
    public void post(Post post);
}
