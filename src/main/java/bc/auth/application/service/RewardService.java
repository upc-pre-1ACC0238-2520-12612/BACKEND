package bc.auth.application.service;

import bc.auth.application.dto.RewardDto;
import java.util.List;

public interface RewardService {

    List<RewardDto> getAll();

    RewardDto getById(Long id);

    RewardDto create(RewardDto dto);

    RewardDto update(Long id, RewardDto dto);

    void delete(Long id);
}
