package bc.auth.domain.service;

import bc.auth.domain.model.User;
import bc.auth.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER
    public User register(String name, String email, String password, String userType) {
        userRepository.findByEmail(email).ifPresent(u -> {
            throw new IllegalArgumentException("Email ya registrado");
        });

        User user = User.newUser(name, email, password, userType);
        return userRepository.save(user);
    }

    // LOGIN
    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new IllegalArgumentException("Credenciales incorrectas"));
    }

    // CRUD normal (sin paginación, por si lo quieres usar)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    public User create(String name, String email, String password, String userType) {
        return register(name, email, password, userType);
    }

    public User update(Long id, String name, String userType) {
        User user = getById(id);
        user.update(name, userType);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // ------- NUEVO: paginación + búsqueda -------

    public Page<User> getPage(Pageable pageable, String search) {
        if (search == null || search.trim().isEmpty()) {
            return userRepository.findAll(pageable);
        }
        return userRepository.search(search.trim(), pageable);
    }
}
