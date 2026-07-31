package mercurio.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mercurio.model.Exam;

@ApplicationScoped
public class ExamRepository implements PanacheRepository<Exam> {
}
