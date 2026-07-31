package mercurio.dto.exam;

import mercurio.model.Topic;
import mercurio.model.enums.Status;

import java.time.LocalDate;
import java.util.List;

public record ExamCreateDTO(
        LocalDate deadline,
        String description,
        Long statusId,
        List<Long> topicIds
) {
}
