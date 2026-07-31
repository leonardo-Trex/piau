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

//        Eu vou aceitar valores null.
        Proficiency p = Proficiency.of(dto.proficiencyId());
        Topic t = new Topic();

        t.setDescription(dto.description());
        t.setProficiency(p);

        return t;
    }
}
