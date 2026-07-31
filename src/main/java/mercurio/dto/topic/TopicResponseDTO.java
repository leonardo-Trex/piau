package mercurio.dto.topic;

import mercurio.model.Exam;
import mercurio.model.enums.Proficiency;

import java.time.LocalDate;

public record TopicResponseDTO(
        Long id,
        String description,
        Proficiency proficiency,
        Exam exam // TODO talvez esse cara não seja tão útil?
) {
}
