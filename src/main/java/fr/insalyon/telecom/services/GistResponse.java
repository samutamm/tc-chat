package fr.insalyon.telecom.services;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class GistResponse {

    private String git_pull_url;

    public String getGit_pull_url() {
        return git_pull_url;
    }

    public void setGit_pull_url(String git_pull_url) {
        this.git_pull_url = git_pull_url;
    }
}
