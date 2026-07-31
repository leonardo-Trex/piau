package mercurio.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mercurio.model.Topic;

@ApplicationScoped
public class TopicRepository implements PanacheRepository<Topic> {

}
