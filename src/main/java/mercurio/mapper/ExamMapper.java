package mercurio.mapper;

import mercurio.dto.exam.ExamResponseDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.model.Exam;
import mercurio.model.Topic;

public class ExamMapper {

    public static ExamResponseDTO toResponse(Exam exam) {
        if (exam == null)
            return null;

        return new ExamResponseDTO(
                exam.getId(),
                exam.getDeadline(),
                exam.getDescription(),
                exam.getStatus(),
                exam.getTopics()
        );
    }
}
