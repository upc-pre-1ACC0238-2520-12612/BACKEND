package bc.auth.infrastructure.persistence;

import bc.auth.domain.model.User;
import bc.auth.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository jpaRepo;

    public UserRepositoryImpl(SpringDataUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    private UserEntity toEntity(User u) {
        UserEntity e = new UserEntity();
        e.setId(u.getId());
        e.setName(u.getName());
        e.setEmail(u.getEmail());
        e.setPassword(u.getPassword());
        e.setUserType(u.getUserType());
        return e;
    }

    private User toDomain(UserEntity e) {
        return new User(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getPassword(),
                e.getUserType()
        );
    }

    @Override
    public User save(User user) {
        UserEntity saved = jpaRepo.save(toEntity(user));
        return toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepo.findAll()
                .stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }
    @Override
    public Page<User> findAll(Pageable pageable) {
        return jpaRepo.findAll(pageable)
                .map(this::toDomain);
    }

    @Override
    public Page<User> search(String search, Pageable pageable) {
        return jpaRepo
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        search, search, pageable)
                .map(this::toDomain);
    }
}
