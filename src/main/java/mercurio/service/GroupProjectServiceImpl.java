package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mercurio.dto.group_project.GroupProjectResponseDTO;
import mercurio.mapper.GroupProjectMapper;
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
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
