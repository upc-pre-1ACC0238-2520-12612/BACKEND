package bc.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRewardRepository
        extends JpaRepository<RewardEntity, Long> {
}
