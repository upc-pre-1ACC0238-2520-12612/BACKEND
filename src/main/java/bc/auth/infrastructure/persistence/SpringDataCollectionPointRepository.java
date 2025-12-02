package bc.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCollectionPointRepository
        extends JpaRepository<CollectionPointEntity, Long> {
}
