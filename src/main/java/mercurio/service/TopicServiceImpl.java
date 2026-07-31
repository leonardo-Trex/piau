package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mercurio.dto.topic.TopicCreateDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.mapper.TopicMapper;
import mercurio.model.Topic;
import mercurio.model.enums.Proficiency;
import mercurio.repository.TopicRepository;
import mercurio.service.interfaces.TopicService;

import java.util.List;

@ApplicationScoped
public class TopicServiceImpl implements TopicService {

    @Inject
    TopicRepository repository;

    @Override
    @Transactional
    public TopicResponseDTO create(TopicCreateDTO dto) {
        if (dto == null)
            return null; // TODO Fix this gambiarra
        Topic t = TopicMapper.toEntity(dto);
        repository.persist(t);
        return TopicMapper.toResponse(t); // FIXME id?
    }

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

    @Override
    @Transactional
    public void update(TopicCreateDTO dto, Long id) {
        if (dto == null || id == null)
            return;

        Proficiency p = Proficiency.of(dto.proficiencyId());
//        FIXME Optional type?
        Topic topic = repository.findById(id);

//        TODO maybe an exception?
        if (topic == null)
            return;

        topic.setProficiency(p);
        topic.setDescription(dto.description());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
