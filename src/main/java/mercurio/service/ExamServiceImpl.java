package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mercurio.dto.exam.ExamCreateDTO;
import mercurio.dto.exam.ExamResponseDTO;
import mercurio.mapper.ExamMapper;
import mercurio.model.Exam;
import mercurio.model.Topic;
import mercurio.model.enums.Status;
import mercurio.repository.ExamRepository;
import mercurio.repository.TopicRepository;
import mercurio.service.interfaces.ExamService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ExamServiceImpl implements ExamService {

    @Inject
    ExamRepository examRepository;

    @Inject
    TopicRepository topicRepository;

    @Override
    public ExamResponseDTO findById(Long id) {
        return ExamMapper
                .toResponse(examRepository.findById(id));
    }

    @Override
    public List<ExamResponseDTO> findAll() {
        return examRepository.findAll().stream()
                .map(ExamMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public ExamResponseDTO create(ExamCreateDTO dto) {
        if(dto == null)
            return null;

        Exam exam = ExamMapper.toEntity(dto);
        List<Topic> list = findTopicsByIds(dto.topicIds()); // Not elegant
        exam.addTopics(list);
        examRepository.persist(exam);

        return ExamMapper.toResponse(exam);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, ExamCreateDTO dto) {
        if (dto == null || id == null)
            return;


        Exam exam = examRepository.findById(id);
        //        TODO maybe an exception?
        if (exam == null)
            return;

        Status status = Status.of(dto.statusId());
        List<Topic> topics = findTopicsByIds(dto.topicIds());

        exam.setDeadline(dto.deadline());
        exam.setStatus(status);
        exam.setDescription(dto.description());
        exam.addTopics(topics);
    }

    private List<Topic> findTopicsByIds(List<Long> ids) {
        return ids.stream()
                .map(id -> topicRepository.findById(id))
                .toList();
    }
}
