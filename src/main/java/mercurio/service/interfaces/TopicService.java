package mercurio.service.interfaces;

import mercurio.dto.topic.TopicCreateDTO;
import mercurio.dto.topic.TopicResponseDTO;
import mercurio.model.Topic;

import java.util.List;

public interface TopicService {
//    Topic create(TopicCreateDTO dto);

    TopicResponseDTO findById(Long id);
    List<TopicResponseDTO> findAll();
}
