package mercurio.mapper;

import mercurio.dto.exam.ExamCreateDTO;
import mercurio.dto.exam.ExamResponseDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.model.Exam;
import mercurio.model.Topic;
import mercurio.model.enums.Status;

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

    public static Exam toEntity(ExamCreateDTO dto) {
        Exam exam = new Exam();
        Status status = Status.of(dto.statusId());

        exam.setStatus(status);
        exam.setDescription(dto.description());
        exam.setDeadline(dto.deadline());

        return exam;
    }
}
