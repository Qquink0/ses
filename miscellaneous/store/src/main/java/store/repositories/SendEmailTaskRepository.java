package store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.entities.SendEmailTaskEntity;

public interface SendEmailTaskRepository extends JpaRepository<SendEmailTaskEntity, Long> {
}
