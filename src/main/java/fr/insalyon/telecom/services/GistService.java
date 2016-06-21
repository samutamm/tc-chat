package fr.insalyon.telecom.services;

import fr.insalyon.telecom.model.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GistService {

    @Value("${gistServiceUrl}")
    private String gistUrl;

    public String sendPostsToGist(List<Post> posts) {
        RestTemplate restTemplate = new RestTemplate();
        GistRequest request = createRequest(posts);

        GistResponse response = restTemplate.postForObject(
                gistUrl,
                request,
                GistResponse.class);
        return response.getGit_pull_url();
    }

    private GistRequest createRequest(List<Post> posts) {
        GistRequest request = new GistRequest();
        request.setDescription("All recent posts:");
        request.setPublic(true);
        Map<String,GistFile> files = new HashMap<>();
        StringBuilder stb = new StringBuilder();
        for(Post p: posts) {
            stb.append(p.toString() + "\n");
        }
        files.put("posts", new GistFile(stb.toString()));
        request.setFiles(files);
        return request;
    }
}
