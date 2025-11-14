package bc.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSustainableActionRepository
        extends JpaRepository<SustainableActionEntity, Long> {
}
