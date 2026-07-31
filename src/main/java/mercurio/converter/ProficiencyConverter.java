package mercurio.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import mercurio.model.enums.Proficiency;

@Converter(autoApply = true)
public class ProficiencyConverter implements AttributeConverter<Proficiency, Long> {

    @Override
    public Long convertToDatabaseColumn(Proficiency attribute) {
        return attribute.getId();
    }

    @Override
    public Proficiency convertToEntityAttribute(Long dbData) {
        return Proficiency.of(dbData);
    }
}
