package mercurio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import mercurio.converter.StatusConverter;
import mercurio.model.enums.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam extends Commitment {

    @Convert(converter = StatusConverter.class)
    private Status status;

    @OneToMany(mappedBy = "exam")
    @JsonIgnore
    private final List<Topic> topics = new ArrayList<>(); // FIXME maybe a Set?

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

    public void addTopics(List<Topic> topics) {
        this.topics.addAll(topics); // Thanks standard library
    }
}
