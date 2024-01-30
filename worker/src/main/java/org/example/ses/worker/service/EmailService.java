package org.example.ses.worker.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class EmailService {

    /**
     * @return true if email delivered to destination email
     */
    public boolean sendEmail(String destinationEmail, String message) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }
}
