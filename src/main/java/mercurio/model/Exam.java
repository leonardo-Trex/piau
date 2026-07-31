package mercurio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import mercurio.model.enums.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Exam extends Commitment {

    private Status status;

    @OneToMany(mappedBy = "exam")
    private final List<Topic> topics = new ArrayList<>();

    public Exam() {}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Topic> getTopics() {
        return Collections.unmodifiableList(this.topics);
    }
}
