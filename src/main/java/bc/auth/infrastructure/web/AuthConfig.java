package bc.auth.infrastructure.config;

import bc.auth.domain.repository.UserRepository;
import bc.auth.domain.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    @Bean
    public AuthService authService(UserRepository userRepository) {
        return new AuthService(userRepository);
    }
}
