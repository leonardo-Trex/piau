package mercurio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mercurio.dto.exam.ExamResponseDTO;
import mercurio.mapper.ExamMapper;
import mercurio.repository.ExamRepository;
import mercurio.service.interfaces.ExamService;

import java.util.List;

@ApplicationScoped
public class ExamServiceImpl implements ExamService {

    @Inject
    ExamRepository repository;

    @Override
    public ExamResponseDTO findById(Long id) {
        return ExamMapper
                .toResponse(repository.findById(id));
    }

    @Override
    public List<ExamResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(ExamMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
