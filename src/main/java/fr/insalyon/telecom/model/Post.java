package fr.insalyon.telecom.model;

import java.io.Serializable;

public class Post implements Serializable {

    private String author;
    private String message;

    public Post(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (!getAuthor().equals(post.getAuthor())) return false;
        return getMessage().equals(post.getMessage());

    }

    @Override
    public int hashCode() {
        int result = getAuthor().hashCode();
        result = 31 * result + getMessage().hashCode();
        return result;
    }
}
