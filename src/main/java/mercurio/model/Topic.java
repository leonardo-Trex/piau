package mercurio.model;

import jakarta.persistence.*;
import mercurio.converter.ProficiencyConverter;
import mercurio.model.enums.Proficiency;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = ProficiencyConverter.class)
    private Proficiency proficiency;

    private String description;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;


    public Topic() {}

    public Long getId() {
        return id;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

}
