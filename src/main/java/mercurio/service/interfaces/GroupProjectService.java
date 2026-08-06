package mercurio.service.interfaces;

import mercurio.dto.group_project.GroupProjectCreateDTO;
import mercurio.dto.group_project.GroupProjectResponseDTO;

import java.util.List;

public interface GroupProjectService {

    GroupProjectResponseDTO findById(Long id);

    List<GroupProjectResponseDTO> findAll();

    GroupProjectResponseDTO create(GroupProjectCreateDTO dto);

    void update(GroupProjectCreateDTO dto, Long id);

    void deleteById(Long id);

}
