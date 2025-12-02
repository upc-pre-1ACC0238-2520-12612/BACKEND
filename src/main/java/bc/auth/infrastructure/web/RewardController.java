package bc.auth.infrastructure.web;

import bc.auth.application.dto.RewardDto;
import bc.auth.application.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
@CrossOrigin(origins = "*")
public class RewardController {

    private final RewardService service;

    public RewardController(RewardService service) {
        this.service = service;
    }

    @GetMapping
    public List<RewardDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RewardDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public RewardDto create(@RequestBody RewardDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public RewardDto update(@PathVariable Long id,
                            @RequestBody RewardDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
