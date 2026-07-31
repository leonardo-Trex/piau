package mercurio.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mercurio.model.GroupProject;

@ApplicationScoped
public class GroupProjectRepository implements PanacheRepository<GroupProject> {
}
