package store;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("store.dao")
@EntityScan("store.entities")
@EnableJpaRepositories("store.repositories")
public class EnableSesStore {
}
