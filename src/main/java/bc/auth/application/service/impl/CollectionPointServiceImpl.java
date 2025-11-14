package bc.auth.application.service.impl;

import bc.auth.application.dto.CollectionPointDto;
import bc.auth.application.service.CollectionPointService;
import bc.auth.infrastructure.persistence.CollectionPointEntity;
import bc.auth.infrastructure.persistence.SpringDataCollectionPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionPointServiceImpl implements CollectionPointService {

    private final SpringDataCollectionPointRepository repository;

    public CollectionPointServiceImpl(SpringDataCollectionPointRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CollectionPointDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CollectionPointDto getById(Long id) {
        CollectionPointEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punto de acopio no encontrado"));
        return toDto(entity);
    }

    @Override
    public CollectionPointDto create(CollectionPointDto dto) {
        CollectionPointEntity entity = toEntity(dto);
        entity.setId(null);
        CollectionPointEntity saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public CollectionPointDto update(Long id, CollectionPointDto dto) {
        CollectionPointEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punto de acopio no encontrado"));

        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setSchedule(dto.getSchedule());
        entity.setActive(dto.isActive());

        CollectionPointEntity updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CollectionPointDto toDto(CollectionPointEntity e) {
        return new CollectionPointDto(
                e.getId(),
                e.getName(),
                e.getAddress(),
                e.getLatitude(),
                e.getLongitude(),
                e.getSchedule(),
                e.isActive()
        );
    }

    private CollectionPointEntity toEntity(CollectionPointDto dto) {
        return new CollectionPointEntity(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getLatitude(),
                dto.getLongitude(),
                dto.getSchedule(),
                dto.isActive()
        );
    }
}
