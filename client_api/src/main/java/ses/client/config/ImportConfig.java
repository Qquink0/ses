package ses.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        EnableSesStore.class
})
@Configuration
public class ImportConfig {
}
