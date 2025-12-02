/* package bc.auth.application.service.impl;
import bc.auth.application.dto.*;
import bc.auth.application.service.AuthService;
import bc.auth.infrastructure.persistence.SpringDataUserRepositoryImpl;
import bc.auth.infrastructure.persistence.UserEntity;
import bc.auth.infrastructure.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final SpringDataUserRepositoryImpl userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(SpringDataUserRepositoryImpl userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserResponseDto register(RegisterRequestDto request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // si tienes más campos, setéalos aquí

        UserEntity saved = userRepository.save(user);

        return new UserResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail());

        UserResponseDto userDto = new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return new LoginResponseDto(token, userDto);
    }
} */