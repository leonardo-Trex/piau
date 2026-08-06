package mercurio.dto.group_project;

import java.time.LocalDate;

public record GroupProjectCreateDTO(
        String    myRole,
        LocalDate deadline,
        String    description
) {
}
