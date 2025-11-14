package bc.auth.application.service;

import bc.auth.application.dto.SustainableActionDto;

import java.util.List;

public interface SustainableActionService {

    List<SustainableActionDto> getAll();

    SustainableActionDto getById(Long id);

    SustainableActionDto create(SustainableActionDto dto);

    SustainableActionDto update(Long id, SustainableActionDto dto);

    void delete(Long id);
}
