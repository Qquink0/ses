package org.example.ses.worker.scheduled;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.example.ses.worker.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import store.dao.SendEmailTaskDAO;

@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class SendEmailTaskScheduler {

    SendEmailTaskDAO sendEmailTaskDAO;

    EmailService emailService;

    @Scheduled(cron = "*/5 * * * * *")
    public void executeSendEmails() {

        sendEmailTaskDAO
                .findAllNotProcessed()
                .forEach(sendEmailTask -> {

                    String destinationEmail = sendEmailTask.getDestinationEmail();
                    String message = sendEmailTask.getMessage();

                    boolean delivered = emailService.sendEmail(destinationEmail, message);

                    if (delivered) {
                        log.debug("Task %d already processed.".formatted(sendEmailTask.getId()));
                        sendEmailTaskDAO.markAsProcessed(sendEmailTask);
                    } else {
                        log.debug("Task %d already processed.".formatted(sendEmailTask.getId()));
                        sendEmailTaskDAO.updateLatestTryAt(sendEmailTask) {
                        }
                    }
                });

    }
}
