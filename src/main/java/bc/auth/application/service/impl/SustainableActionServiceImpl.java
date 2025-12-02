package bc.auth.application.service.impl;

import bc.auth.application.dto.SustainableActionDto;
import bc.auth.application.service.SustainableActionService;
import bc.auth.infrastructure.persistence.SustainableActionEntity;
import bc.auth.infrastructure.persistence.SpringDataSustainableActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SustainableActionServiceImpl implements SustainableActionService {

    private final SpringDataSustainableActionRepository repository;

    public SustainableActionServiceImpl(SpringDataSustainableActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SustainableActionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SustainableActionDto getById(Long id) {
        SustainableActionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acción no encontrada"));
        return toDto(entity);
    }

    @Override
    public SustainableActionDto create(SustainableActionDto dto) {
        SustainableActionEntity entity = toEntity(dto);
        entity.setId(null);
        SustainableActionEntity saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public SustainableActionDto update(Long id, SustainableActionDto dto) {
        SustainableActionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acción no encontrada"));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setPointsPerUnit(dto.getPointsPerUnit());
        entity.setUnit(dto.getUnit());
        entity.setActive(dto.isActive());

        SustainableActionEntity updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SustainableActionDto toDto(SustainableActionEntity e) {
        return new SustainableActionDto(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                e.getCategory(),
                e.getPointsPerUnit(),
                e.getUnit(),
                e.isActive()
        );
    }

    private SustainableActionEntity toEntity(SustainableActionDto dto) {
        return new SustainableActionEntity(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getPointsPerUnit(),
                dto.getUnit(),
                dto.isActive()
        );
    }
}
