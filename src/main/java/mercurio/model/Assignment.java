package mercurio.model;

import jakarta.persistence.Entity;
import mercurio.model.enums.Status;

@Entity
public class Assignment extends Commitment {
    private String myRole;
    private Status status;

    public Assignment() {}

    public String getMyRole() {
        return myRole;
    }

    public void setMyRole(String myRole) {
        this.myRole = myRole;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
