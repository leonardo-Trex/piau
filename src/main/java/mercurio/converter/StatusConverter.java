package mercurio.converter;

import jakarta.persistence.AttributeConverter;
import mercurio.model.enums.Status;

public class StatusConverter implements AttributeConverter<Status, Long> {
    @Override
    public Long convertToDatabaseColumn(Status attribute) {
        return attribute.getId();
    }

    @Override
    public Status convertToEntityAttribute(Long dbData) {
        return Status.of(dbData);
    }
}
