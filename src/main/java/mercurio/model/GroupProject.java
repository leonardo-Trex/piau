package mercurio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mercurio.model.enums.Status;

@Entity
@Table(name = "group_projects")
public class GroupProject extends Commitment {

    @Column(name = "my_role")
    private String myRole;
    private Status status;

    public GroupProject() {}

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
