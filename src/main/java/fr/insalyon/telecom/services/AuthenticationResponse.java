package fr.insalyon.telecom.services;

public class AuthenticationResponse {

    private boolean success;

    public AuthenticationResponse() {}

    public AuthenticationResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
