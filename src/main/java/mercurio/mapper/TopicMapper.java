package mercurio.mapper;

import mercurio.dto.topic.TopicCreateDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.model.Topic;

public class TopicMapper {

    public static TopicResponseDTO toResponse(Topic topic) {
        if (topic == null)
            return null;

        return new TopicResponseDTO(
                topic.getId(),
                topic.getDescription(),
                topic.getProficiency(),
                topic.getExam()
        );
    }
}
