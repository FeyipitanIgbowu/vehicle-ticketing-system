package dtos.requests;

public class RegisterOfficerRequest {
    private int officerId;
    private String officerName;
    private String officerRank;
    private String officerUsername;
    private String officerPassword;
    private String officerEmail;

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerRank() {
        return officerRank;
    }

    public void setOfficerRank(String officerRank) {
        this.officerRank = officerRank;
    }

    public String getOfficerUsername() {
        return officerUsername;
    }

    public void setOfficerUsername(String officerUsername) {
        this.officerUsername = officerUsername;
    }

    public String getOfficerPassword() {
        return officerPassword;
    }

    public void setOfficerPassword(String officerPassword) {
        this.officerPassword = officerPassword;
    }

    public String getEmail() {
        return officerEmail;
    }

    public void setEmail(String email) {
        this.officerEmail = email;
    }
}
