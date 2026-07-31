package mercurio.model;

import jakarta.persistence.Entity;
import mercurio.model.enums.Status;

@Entity
public class Exam extends Commitment {
    private Status status;
}
