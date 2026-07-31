package mercurio.service.interfaces;

import mercurio.dto.group_project.GroupProjectResponseDTO;

import java.util.List;

public interface GroupProjectService {

    GroupProjectResponseDTO findById(Long id);

    List<GroupProjectResponseDTO> findAll();

    void deleteById(Long id);
}
