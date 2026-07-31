package mercurio.mapper;

import mercurio.dto.exam.ExamResponseDTO;
import mercurio.dto.group_project.GroupProjectResponseDTO;
import mercurio.model.Exam;
import mercurio.model.GroupProject;

public class GroupProjectMapper {

    public static GroupProjectResponseDTO toResponse(GroupProject groupProject) {
        if (groupProject == null)
            return null;

        return new GroupProjectResponseDTO(
                groupProject.getId(),
                groupProject.getDeadline(),
                groupProject.getDescription(),
                groupProject.getMyRole(),
                groupProject.getStatus().toString() // TODO corrigir essa gambiarra
        );
    }
}
