package store.dao;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import store.entities.SendEmailTaskEntity;
import store.repositories.SendEmailTaskRepository;

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

}
