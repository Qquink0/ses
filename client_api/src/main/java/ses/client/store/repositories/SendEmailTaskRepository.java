package ses.client.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ses.client.store.entities.SendEmailTaskEntity;

public interface SendEmailTaskRepository extends JpaRepository<SendEmailTaskEntity, Long> {
}
