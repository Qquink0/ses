package org.example.ses.worker.scheduled;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import store.dao.SendEmailTaskDAO;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class SendEmailTaskScheduler {

    SendEmailTaskDAO sendEmailTaskDAO;

    @Scheduled(cron = "*/5 * * * * *")
    public void sentEmail() {

    }
}
