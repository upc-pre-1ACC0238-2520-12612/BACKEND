package bc.auth.application.service;

import bc.auth.application.dto.CollectionPointDto;

import java.util.List;

public interface CollectionPointService {

    List<CollectionPointDto> getAll();

    CollectionPointDto getById(Long id);

    CollectionPointDto create(CollectionPointDto dto);

    CollectionPointDto update(Long id, CollectionPointDto dto);

    void delete(Long id);
}
