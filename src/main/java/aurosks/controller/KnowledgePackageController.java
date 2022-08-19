package aurosks.controller;

import aurosks.dto.mapper.KnowledgePackageMapper;
import aurosks.dto.request.KnowledgePackageRequestDto;
import aurosks.dto.responce.KnowledgePackageResponseDto;
import aurosks.model.KnowledgePackage;
import aurosks.service.KnowledgePackageService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageService service;
    private final KnowledgePackageMapper mapper;

    public KnowledgePackageController(KnowledgePackageService service,
                                      KnowledgePackageMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public KnowledgePackageResponseDto create(@RequestBody KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = service.create(mapper.toModel(requestDto));
        return mapper.toResponseDto(knowledgePackage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/")
    public List<KnowledgePackageResponseDto> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
