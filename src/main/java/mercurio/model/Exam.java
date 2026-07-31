package mercurio.model;

import jakarta.persistence.Entity;

@Entity
public class Exam extends Commitment {
    private String status;
}
