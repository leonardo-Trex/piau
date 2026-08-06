package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mercurio.dto.group_project.GroupProjectCreateDTO;
import mercurio.dto.group_project.GroupProjectResponseDTO;
import mercurio.mapper.GroupProjectMapper;
import mercurio.model.GroupProject;
import mercurio.repository.GroupProjectRepository;
import mercurio.service.interfaces.GroupProjectService;

import java.util.List;

@ApplicationScoped
public class GroupProjectServiceImpl implements GroupProjectService {

    @Inject
    GroupProjectRepository repository;

    @Override
    public GroupProjectResponseDTO findById(Long id) {
       return GroupProjectMapper
               .toResponse(repository.findById(id));
    }

    @Override
    public List<GroupProjectResponseDTO> findAll() {

        return repository.findAll().stream()
                .map(GroupProjectMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public GroupProjectResponseDTO create(GroupProjectCreateDTO dto) {

        GroupProject gp = GroupProjectMapper.toEntity(dto);
        repository.persist(gp);
        return GroupProjectMapper.toResponse(gp);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
