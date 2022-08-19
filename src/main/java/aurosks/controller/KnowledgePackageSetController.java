package aurosks.controller;

import aurosks.dto.mapper.KnowledgePackageSetMapper;
import aurosks.dto.request.KnowledgePackageSetRequestDto;
import aurosks.dto.responce.KnowledgePackageSetResponseDto;
import aurosks.model.KnowledgePackageSet;
import aurosks.service.KnowledgePackageSetService;
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
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService service;
    private final KnowledgePackageSetMapper mapper;

    public KnowledgePackageSetController(KnowledgePackageSetService service,
                                         KnowledgePackageSetMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public KnowledgePackageSetResponseDto create(
            @RequestBody KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = service.create(mapper.toModel(requestDto));
        return mapper.toResponseDto(knowledgePackageSet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<KnowledgePackageSetResponseDto> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
