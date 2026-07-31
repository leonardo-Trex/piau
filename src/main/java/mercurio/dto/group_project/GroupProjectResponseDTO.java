package mercurio.dto.group_project;

import java.time.LocalDate;

public record GroupProjectResponseDTO(
        Long id,
        LocalDate deadline,
        String description,
        String myRole,
        String status
) {
}
