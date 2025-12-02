/* package bc.auth.infrastructure.web;

import bc.auth.application.dto.CreateUserRequestDto;
import bc.auth.application.dto.PagedResponseDto;
import bc.auth.application.dto.UserResponseDto;
import bc.auth.application.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public PagedResponseDto<UserResponseDto> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) String search
    ) {
        return service.getUsers(page, size, sortBy, direction, search);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody CreateUserRequestDto request) {
        return service.createUser(request);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(
            @PathVariable Long id,
            @RequestBody CreateUserRequestDto request
    ) {
        return service.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
} */