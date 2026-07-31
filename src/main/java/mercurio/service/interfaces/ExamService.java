package mercurio.service.interfaces;

import mercurio.dto.exam.ExamCreateDTO;
import mercurio.dto.exam.ExamResponseDTO;

import java.util.List;

public interface ExamService {

    ExamResponseDTO findById(Long id);

    List<ExamResponseDTO> findAll();

    ExamResponseDTO create(ExamCreateDTO dto);

    void deleteById(Long id);
}
