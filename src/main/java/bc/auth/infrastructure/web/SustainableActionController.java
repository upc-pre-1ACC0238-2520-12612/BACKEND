package bc.auth.infrastructure.web;

import bc.auth.application.dto.SustainableActionDto;
import bc.auth.application.service.SustainableActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
@CrossOrigin(origins = "*")
public class SustainableActionController {

    private final SustainableActionService service;

    public SustainableActionController(SustainableActionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SustainableActionDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SustainableActionDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public SustainableActionDto create(@RequestBody SustainableActionDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public SustainableActionDto update(@PathVariable Long id,
                                       @RequestBody SustainableActionDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
