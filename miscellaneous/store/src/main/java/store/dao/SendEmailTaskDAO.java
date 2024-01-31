package store.dao;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import store.entities.SendEmailTaskEntity;
import store.repositories.SendEmailTaskRepository;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Repository
@Transactional(readOnly = true)
public class SendEmailTaskDAO {

    SendEmailTaskRepository sendEmailTaskRepository;

    @Transactional
    public SendEmailTaskEntity save(SendEmailTaskEntity entity) {
        return sendEmailTaskRepository.save(entity);
    }

    public List<SendEmailTaskEntity> findAllNotProcessed() {
        return sendEmailTaskRepository.findAllNotProcessed();
    }

    @Transactional
    public void markAsProcessed(SendEmailTaskEntity entity) {
        sendEmailTaskRepository.markAsProcessed(entity.getId());
    }

    public void updateLatestTryAt(SendEmailTaskEntity entity) {
        sendEmailTaskRepository.updateLatestTryAt(entity.getId());
    }
}
