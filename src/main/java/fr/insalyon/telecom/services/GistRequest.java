package fr.insalyon.telecom.services;

import java.util.Map;

public class GistRequest {

    private String description;
    private boolean isGistPublic;
    private Map<String, GistFile> files;

    public void setPublic(boolean isGistPublic) {
        this.isGistPublic = isGistPublic;
    }
    public boolean getPublic() {
        return isGistPublic;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, GistFile> getFiles() {
        return files;
    }
    public void setFiles(Map<String, GistFile> files) {
        this.files = files;
    }

    // '{"description":"desc", "public":"true", "files": {"file.txt":{"content":"cont"}}}'
}
