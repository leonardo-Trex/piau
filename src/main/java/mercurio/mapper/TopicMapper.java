package mercurio.mapper;

import mercurio.dto.topic.TopicCreateDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.model.Topic;
import mercurio.model.enums.Proficiency;

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

    public static Topic toEntity(TopicCreateDTO dto) {
        if (dto == null)
            return null;

        Topic t = new Topic();

        t.setDescription(dto.description());
//        TODO Fix this gambiarra
        t.setProficiency(Proficiency.KNOW_NOTHING);

        return t;
    }
}
