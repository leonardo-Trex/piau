package mercurio.dto.topic;

import mercurio.model.enums.Proficiency;

public record TopicCreateDTO(
        Long proficiencyId,
        String description
) {
}
