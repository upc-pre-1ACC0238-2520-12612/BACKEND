package bc.auth.infrastructure.web;

import bc.auth.application.dto.AuthLoginResponseDto;
import bc.auth.application.dto.LoginRequestDto;
import bc.auth.application.dto.PagedResponseDto;
import bc.auth.application.dto.RegisterRequestDto;
import bc.auth.application.dto.UserResponseDto;
import bc.auth.domain.model.User;
import bc.auth.domain.service.AuthService;
import bc.auth.infrastructure.config.JwtUtil;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody RegisterRequestDto dto) {
        User user = authService.register(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getUserType()
        );
        return ResponseEntity.ok(toDto(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthLoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        User user = authService.login(dto.getEmail(), dto.getPassword());

        String token = jwtUtil.generateToken(user.getEmail());

        AuthLoginResponseDto response = new AuthLoginResponseDto(
                token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserType()
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        User user = authService.getById(id);
        return ResponseEntity.ok(toDto(user));
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> create(@RequestBody RegisterRequestDto dto) {
        User user = authService.create(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getUserType()
        );
        return ResponseEntity.ok(toDto(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> update(
            @PathVariable Long id,
            @RequestBody RegisterRequestDto dto
    ) {
        User user = authService.update(id, dto.getName(), dto.getUserType());
        return ResponseEntity.ok(toDto(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public ResponseEntity<PagedResponseDto<UserResponseDto>> getUsersPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) String search
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> usersPage = authService.getPage(pageable, search);

        List<UserResponseDto> content = usersPage.getContent()
                .stream().map(this::toDto).toList();

        PagedResponseDto<UserResponseDto> response =
                new PagedResponseDto<>(
                        content,
                        usersPage.getNumber(),
                        usersPage.getSize(),
                        usersPage.getTotalElements(),
                        usersPage.getTotalPages(),
                        usersPage.isLast()
                );

        return ResponseEntity.ok(response);
    }

    private UserResponseDto toDto(User u) {
        return new UserResponseDto(
                u.getId(),
                u.getName(),
                u.getEmail(),
                u.getUserType()
        );
    }
}
