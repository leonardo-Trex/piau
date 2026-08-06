package mercurio.mapper;

import mercurio.dto.exam.ExamResponseDTO;
import mercurio.dto.group_project.GroupProjectCreateDTO;
import mercurio.dto.group_project.GroupProjectResponseDTO;
import mercurio.model.Exam;
import mercurio.model.GroupProject;
import mercurio.model.enums.Status;

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

    public static GroupProject toEntity(GroupProjectCreateDTO dto) {
        GroupProject gp = new GroupProject();

        gp.setStatus(Status.GUARANTEED); // FIXME
        gp.setDeadline(dto.deadline());
        gp.setMyRole(dto.myRole());
        gp.setDescription(dto.description());
        return gp;
    }
}
