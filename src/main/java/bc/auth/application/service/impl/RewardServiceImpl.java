package bc.auth.application.service.impl;

import bc.auth.application.dto.RewardDto;
import bc.auth.application.service.RewardService;
import bc.auth.infrastructure.persistence.RewardEntity;
import bc.auth.infrastructure.persistence.SpringDataRewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    private final SpringDataRewardRepository repository;

    public RewardServiceImpl(SpringDataRewardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RewardDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RewardDto getById(Long id) {
        RewardEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recompensa no encontrada"));
        return toDto(entity);
    }

    @Override
    public RewardDto create(RewardDto dto) {
        RewardEntity entity = toEntity(dto);
        entity.setId(null);
        RewardEntity saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public RewardDto update(Long id, RewardDto dto) {
        RewardEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recompensa no encontrada"));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setRequiredPoints(dto.getRequiredPoints());
        entity.setActive(dto.isActive());

        RewardEntity updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private RewardDto toDto(RewardEntity e) {
        return new RewardDto(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                e.getRequiredPoints(),
                e.isActive()
        );
    }

    private RewardEntity toEntity(RewardDto dto) {
        return new RewardEntity(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getRequiredPoints(),
                dto.isActive()
        );
    }
}
