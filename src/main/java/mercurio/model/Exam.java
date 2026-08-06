package mercurio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private final List<Topic> topics = new ArrayList<>(); // maybe a set?

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

        topics.forEach(t -> {
            t.setExam(this);
        });
        this.topics.addAll(topics); // Thanks standard library
    }
}
