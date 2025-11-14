package bc.auth.infrastructure.web;

import bc.auth.application.dto.CollectionPointDto;
import bc.auth.application.service.CollectionPointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection-points")
@CrossOrigin(origins = "*")
public class CollectionPointController {

    private final CollectionPointService service;

    public CollectionPointController(CollectionPointService service) {
        this.service = service;
    }

    @GetMapping
    public List<CollectionPointDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CollectionPointDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CollectionPointDto create(@RequestBody CollectionPointDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CollectionPointDto update(@PathVariable Long id,
                                     @RequestBody CollectionPointDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
