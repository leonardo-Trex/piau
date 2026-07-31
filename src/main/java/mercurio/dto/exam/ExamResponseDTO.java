package mercurio.dto.exam;

import mercurio.model.Topic;
import mercurio.model.enums.Status;

import java.time.LocalDate;
import java.util.List;

public record ExamResponseDTO(
        Long id,
        LocalDate deadline,
        String description,
        Status status,
        List<Topic> topics
) {
}
