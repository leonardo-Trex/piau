package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.mapper.TopicMapper;
import mercurio.model.Topic;
import mercurio.repository.TopicRepository;
import mercurio.service.interfaces.TopicService;

import java.util.List;

@ApplicationScoped
public class TopicServiceImpl implements TopicService {

    @Inject
    TopicRepository repository;

    @Override
    public TopicResponseDTO findById(Long id) {
        Topic t = repository.findById(id);
        return TopicMapper.toResponse(t);
    }

    @Override
    public List<TopicResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(TopicMapper::toResponse)
                .toList();
    }
}
