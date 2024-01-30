package ses.client.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import store.dao.SendEmailTaskDAO;
import store.entities.SendEmailTaskEntity;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class EmailController {

    SendEmailTaskDAO sendEmailTaskDao;

    public static final String SEND_EMAIL = "/api/email/send";

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(SEND_EMAIL)
    public void sendEmail(
            @RequestParam("destination_email") String destinationEmail,
            @RequestParam String message) {

        sendEmailTaskDao.save(
                SendEmailTaskEntity.builder()
                        .destinationEmail(destinationEmail)
                        .message(message)
                        .build()
        );
    }
}
